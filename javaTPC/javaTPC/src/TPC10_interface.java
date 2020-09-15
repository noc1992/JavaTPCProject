import kr.tpc.*;

public class TPC10_interface {

	public static void main(String[] args) {
		Remocon r = new TV();
		r.chDown();
		r.chUp();
		r.internet();
		
		r = new Radio();
		r.chDown();
		r.chUp();
		r.internet();
	}

}
