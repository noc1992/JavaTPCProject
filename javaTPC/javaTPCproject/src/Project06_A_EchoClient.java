import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Project06_A_EchoClient {
	public static void main (String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 9999);
			System.out.println("Connection Success!!!");
			Scanner scanner = new Scanner(System.in);
			String message = scanner.nextLine();
			OutputStream out = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(out);
			dos.writeUTF(message);
			
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			System.out.println("Received:" + dis.readUTF());
			
			dis.close();
			dos.close();
			socket.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
