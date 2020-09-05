import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import kr.inflearn.BookDTO;

public class project01_A_JSON {

	public static void main(String[] args) {
		BookDTO dto = new BookDTO("�ڹ�", 21000, "���̺�", 670);
		Gson g = new Gson();
		String json = g.toJson(dto);
		System.out.println(json);
		
		BookDTO dto1 = g.fromJson(json, BookDTO.class);
		System.out.println(dto1);
		
		List<BookDTO> lst=new ArrayList<BookDTO>();
		lst.add(new BookDTO("�ڹ�1", 21000, "���̺�", 670));
		lst.add(new BookDTO("�ڹ�2", 23000, "���̺�", 700));
		lst.add(new BookDTO("�ڹ�3", 10000, "���̺�", 170));
		
		String lstJson = g.toJson(lst);
		System.out.println(lstJson);
		
		List<BookDTO> lst1 = g.fromJson(lstJson, new TypeToken<List<BookDTO>>(){}.getType());
		for (BookDTO vo : lst1) {
			System.out.println(vo);
		}
	}

}