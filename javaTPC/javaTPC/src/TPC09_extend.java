import kr.tpc.Animal;
import kr.tpc.Cat;
import kr.tpc.Dog;

public class TPC09_extend {

	public static void main(String[] args) {

		Animal d = new Dog();
		d.eat();
		
		Animal c = new Cat(); // ��ĳ����
		c.eat();
		((Cat)c).night();  // �ٿ�ĳ����
		
	}

}
