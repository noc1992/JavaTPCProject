package kr.javatpc;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONObject;
public class IoTFrame extends JFrame implements ActionListener,ReceiveEventListner{
    private static final long serialVersionUID = 1L;
    private JTextField tmp = new JTextField(10);
    private JTextField hum = new JTextField(10);
    private JButton ledOn = new JButton("LED_ON");
    private JButton ledOff = new JButton("LED_OFF");  
    private JLabel msg = new JLabel("�½��� ����͸�");
    private JTextArea out = new JTextArea(20,40);
    private JPanel panel = new JPanel();
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private ScrollPane sp=new ScrollPane();    
    private MqttClass mqtt = null;
    
    public IoTFrame(MqttClass mqtt){
        this();
        this.mqtt = mqtt;
        this.mqtt.setMyEventListner(this);
    }   
    public IoTFrame(){
        super("MQTT �繰���ͳ� ��� ������Ʈ");
        setSize(400,400);
        panel.add(msg); 
        panel.add(ledOn); 
        panel.add(ledOff); 
        panel1.add(tmp); 
        panel1.add(hum);
        sp.add(out);
        add(BorderLayout.NORTH, panel); //jframe�� div
        add(BorderLayout.CENTER, sp); //jframe�� div
        add(BorderLayout.SOUTH, panel1);
        //add(BorderLayout.EAST, panel2);
        ledOn.addActionListener(this); //������ �� �ְ� ����
        ledOff.addActionListener(this); //������ �� �ְ� ����
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void recvMsg(String topic, MqttMessage msg) {
        System.out.println(topic+","+msg);
        String append = out.getText();
        out.setText(topic+","+msg+"\n"+append);
        JSONObject obj=new JSONObject(new String(msg.getPayload()));
        tmp.setText("�µ�:"+obj.get("tmp").toString());
        hum.setText("����:"+obj.get("hum").toString());
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        if(b.getText().equals("LED_ON")){
            mqtt.sendMessage("1");
        }else if(b.getText().equals("LED_OFF")) {
        	mqtt.sendMessage("2");
        }
    }
}