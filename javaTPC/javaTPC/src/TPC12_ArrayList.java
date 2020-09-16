import java.util.ArrayList;
import java.util.List;

import kr.tpc.BookDTO;

public class TPC12_ArrayList {

	public static void main(String[] args) {
		List<BookDTO> list = new ArrayList<BookDTO>();
		list.add(new BookDTO("자바", 12000, "도우출판", 700));
		list.add(new BookDTO("자바1", 13000, "도우출", 780));
		list.add(new BookDTO("자바2", 14000, "도우판", 777));
		
		for(int i=0;i<list.size();i++) {
			Object o=list.get(i);
			BookDTO vo=(BookDTO)o;
			System.out.println(vo);
		}
		
	}

}
