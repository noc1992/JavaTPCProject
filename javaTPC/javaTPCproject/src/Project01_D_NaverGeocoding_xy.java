import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Project01_D_NaverGeocoding_xy {

	public static void main(String[] args) {

		String apiURL = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query=";
		String client_id = "6hjxzeph3g";
		String client_secret = "vGSMGEukNQOMOw6u6FwsFEH5RC27xsVJrgoyNc5r";
		
		BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("�ּҸ� �Է��ϼ���: ");
			String address=io.readLine();
			String addr=URLEncoder.encode(address, "UTF-8");
			String reqURL=apiURL+addr;
			
			URL url=new URL(reqURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", client_id);
			con.setRequestProperty("X-NCP-APIGW-API-KEY", client_secret);
			BufferedReader br;
			int responseCode=con.getResponseCode();
			if (responseCode==200) {
				br=new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
			} else {
				br=new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String line;
			StringBuffer response=new StringBuffer();
			while((line=br.readLine())!=null) {
				response.append(line);
			}
			br.close();
			
			JSONTokener tokener = new JSONTokener(response.toString());
			JSONObject object = new JSONObject(tokener);
			System.out.println(object.toString());
			
			JSONArray arr = object.getJSONArray("addresses");
			for (int i = 0;i<arr.length();i++) {
				JSONObject temp = (JSONObject) arr.get(i);
				System.out.println("address: " + temp.get("roadAddress"));
				System.out.println("jibunAddress: " + temp.get("jibunAddress"));
				System.out.println("�浵: " + temp.get("x"));
				System.out.println("����: " + temp.get("y"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}