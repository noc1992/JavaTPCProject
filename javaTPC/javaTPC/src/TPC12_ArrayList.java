import java.util.ArrayList;
import java.util.List;

import kr.tpc.BookDTO;

public class TPC12_ArrayList {

	public static void main(String[] args) {
		List<BookDTO> list = new ArrayList<BookDTO>();
		list.add(new BookDTO("�ڹ�", 12000, "��������", 700));
		list.add(new BookDTO("�ڹ�1", 13000, "������", 780));
		list.add(new BookDTO("�ڹ�2", 14000, "������", 777));
		
		for(int i=0;i<list.size();i++) {
			Object o=list.get(i);
			BookDTO vo=(BookDTO)o;
			System.out.println(vo);
		}
		
	}

}