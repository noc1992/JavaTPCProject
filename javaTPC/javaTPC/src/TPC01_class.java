import kr.bit.*;

public class TPC01_class {

	public static void main(String[] args) {
		Book a;
		a = new Book();
		a.title = "Java의 정석";
		a.price = 15000;
		a.company = "도우출판";
		a.page = 700;
		
		System.out.println(a.title);
		System.out.println(a.company);
		System.out.println(a.page);
		System.out.println(a.company);
		
		PersonVO p;
		p = new PersonVO();
		p.name = "stephen";
		p.age = 32;
		p.weight = 80.3f;
		p.height = 190;
	
		int[] arr = new int[3];
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 40;
				
		hap(10, 20, 40);
		hap1(arr);
	}
	
	public static void hap (int a, int b, int c) {
		int sum = a + b + c;
		System.out.println(sum);
	}
	public static void hap1 (int[] x) {
		int sum = 0;
		for (int i=0; i<x.length; i++)
		{
			sum += x[i];			
		}
		System.out.println(sum);
	}

}
