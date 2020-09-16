import kr.inflearn.IntArray;
import kr.inflearn.ObjectArray;
import kr.tpc.A;
import kr.tpc.B;

public class TPC11_MyAPI {

	public static void main(String[] args) {

		IntArray arr = new IntArray(5);
		arr.add(10);
		arr.add(20);
		arr.add(30);
		
		for (int i=0;i<arr.size();i++) {
			System.out.println(arr.get(i));
		}
		
		ObjectArray arr1 = new ObjectArray(5);
		arr1.add(new A());
		arr1.add(new B());
		arr1.add(new A());
		arr1.add(new A());
		arr1.add(new A());
	
	for (int i=0;i<arr1.size();i++) {
		Object o = arr1.get(i);
		if(o instanceof A) {
			((A)o).go();
		} else {
			((B)o).go();
		}
	}
	
}
}


