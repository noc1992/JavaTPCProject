import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.Date;
import org.json.*;
import kr.inflearn.AddressVO;
import javax.swing.ImageIcon;

public class NaverMap implements ActionListener {
	Project01_Fin_NaverGeocode_GUI naverMap;
	public NaverMap(Project01_Fin_NaverGeocode_GUI naverMap) {
		this.naverMap=naverMap;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String clintId = "6hjxzeph3g";
		String clintSecret = "vGSMGEukNQOMOw6u6FwsFEH5RC27xsVJrgoyNc5r";
		AddressVO vo = null;
		try {
			String address = naverMap.address.getText();
			String addr = URLEncoder.encode(address, "UTF-8");
			String apiURL = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query=" + addr;
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clintId);
			con.setRequestProperty("X-NCP-APIGW-API-KEY", clintSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode==200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			JSONTokener tokener = new JSONTokener(response.toString());
			JSONObject object=new JSONObject(tokener);
			System.out.println(object);
			
			JSONArray arr = object.getJSONArray("addresses");
			for (int i=0;i<arr.length();i++) {
				JSONObject temp = (JSONObject) arr.get(i);
				vo = new AddressVO();
				vo.setRoadAddress((String)temp.get("roadAddress"));
				vo.setJibunAddress((String)temp.get("jibunAddress"));
				vo.setX((String)temp.get("x"));
				vo.setY((String)temp.get("y"));
				System.out.println(vo);
			}
			map_service(vo);
		} catch (Exception err) {
			System.out.println(err);
		}
		
	}
	public void map_service(AddressVO vo) {
		String URL_STATICMAP = "https://naveropenapi.apigw.ntruss.com/map-static/v2/raster?";
		try {
			String pos = URLEncoder.encode(vo.getX() + " " + vo.getY(), "UTF-8");
			String url = URL_STATICMAP;
			url += "center=" + vo.getX() + "," + vo.getY();
			url += "&level=16&w=700&h=500";
			url += "&marker=type:t|size:mid|pos:"+pos+"|label:"+URLEncoder.encode(vo.getRoadAddress(),"UTF-8");
			URL u = new URL(url);
			
			HttpURLConnection con = (HttpURLConnection)u.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", "6hjxzeph3g");
			con.setRequestProperty("X-NCP-APIGW-API-KEY", "vGSMGEukNQOMOw6u6FwsFEH5RC27xsVJrgoyNc5r");
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode==200) {
				InputStream is = con.getInputStream();
				int read = 0;
				byte[] bytes = new byte[1024];
				String tempname = Long.valueOf(new Date().getTime()).toString();
				File f = new File(tempname + ".jpg");
				f.createNewFile();
				OutputStream outputStream = new FileOutputStream(f);
				while ((read =is.read(bytes)) != -1) {
					outputStream.write(bytes, 0, read);
				}
				is.close();
				ImageIcon img = new ImageIcon(f.getName());
				naverMap.imageLabel.setIcon(img);
				naverMap.resAddress.setText(vo.getRoadAddress());
                naverMap.jibunAddress.setText(vo.getJibunAddress());
                naverMap.resX.setText(vo.getX());
                naverMap.resY.setText(vo.getY());
				
			} else {
				System.out.println(responseCode);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
