import java.io.InputStream;
import org.json.*;

public class Project01_C_JSONArray {

	public static void main(String[] args) {
		String src= "info.json";
		InputStream is = Project01_C_JSONArray.class.getResourceAsStream(src);
		
		if (is == null) {
			throw new NullPointerException("Can't find resource file");
		}
		JSONTokener tokener = new JSONTokener(is);
		JSONObject object = new JSONObject(tokener);
		JSONArray students = object.getJSONArray("students");
		for (int i = 0; i < students.length(); i++) {
			JSONObject student = (JSONObject)students.get(i);
			System.out.print(student.get("name")+ "\t");
			System.out.print(student.get("address")+ "\t");
			System.out.println(student.get("phone"));
		}
	}

}
