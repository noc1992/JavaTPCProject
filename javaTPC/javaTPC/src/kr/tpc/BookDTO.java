package kr.tpc;

public class BookDTO {
	public String title;
	public int price;
	public String company;
	public int page;
	
	public BookDTO() {
		//초기화 작업
		this.title="java";
		this.price=18000;
		this.company="ezs";
		this.page=780;	
	}
	//생성자 메서드의 오버라이드
	public BookDTO(String title, int price, String company, int page) {
		//초기화 작업
		this.title=title;
		this.price=price;
		this.company=company;
		this.page=page;	
	}
	// 클래스 안에 생성자가 없으면 디폴트 생성자 생성, 
	// 있으면 디폴트 생성자 없음.
	
}
