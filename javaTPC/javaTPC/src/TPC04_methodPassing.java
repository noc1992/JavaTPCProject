public class TPC04_methodPassing {

	public static void main(String[] args) {
		
		int a = 20;
		float b= 56.78f;
		
		float v = sum(a, b);  // call by value(°ª)
		System.out.println(v);
		
		int[] arr= {1,2,3,4,5}; // call by reference(¹øÁö)
		int vv=arrSum(arr);
		
	}
	private static int arrSum(int[] x) {
		int hap = 0;
		for(int i=0;i<x.length;i++) {
			hap+=x[i];
		}
		return 0;
	}
	public static float sum(int a, float b) {
		float v = a+b;
		return v;
	}
}
