import kr.tpc.Animal;
import kr.tpc.Cat;
import kr.tpc.Dog;

public class TPC09_extend {

	public static void main(String[] args) {

		Animal d = new Dog();
		d.eat();
		
		Animal c = new Cat(); // 업캐스팅
		c.eat();
		((Cat)c).night();  // 다운캐스팅
		
	}

}
