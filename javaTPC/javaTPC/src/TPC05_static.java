
public class TPC05_static {

	public static void main(String[] args) {
		
		int a = 30;
		int b = 50;
		
		int v = add(a, b);
		System.out.println(v);
		
		TPC05_static tpc = new TPC05_static();
		int m = tpc.minus(a, b);
		System.out.println(m);
		
	}
	
	public static int add (int a, int b) {
		int sum = a + b;
		return sum;
	}
	public int minus (int a, int b) {
		int sum = a - b;
		return sum;
	}
}
