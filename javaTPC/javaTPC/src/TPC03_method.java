public class TPC03_method {

	public static void main(String[] args) {
		int a = 67;
		int b = 98;
		
		int result = sum(a,b);
		System.out.println(result);
		
		int[] arr = makeArr();
		int hap = 0;
		for(int i=0;i<arr.length;i++) {
			hap+=arr[i];
		}
		System.out.println(hap);
				
	}
	public static int sum(int a,int b) {  //static : 메인과 같은 형태여야 바로 호출가능    void : 리턴 값을 주지 않을 것이다.
		int sum = a+b;
		return sum;
	}
	public static int[] makeArr() {
		int x=10;
		int y=20;
		int z=40;
		int[] arr = new int[3];
		arr[0] = x;
		arr[1] = y;
		arr[2] = z;
		
		return arr;
	}
}
