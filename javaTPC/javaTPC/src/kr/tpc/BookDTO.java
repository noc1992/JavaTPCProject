package kr.tpc;

public class BookDTO {
	public String title;
	public int price;
	public String company;
	public int page;
	
	public BookDTO() {
		//�ʱ�ȭ �۾�
		this.title="java";
		this.price=18000;
		this.company="ezs";
		this.page=780;	
	}
	//������ �޼����� �������̵�
	public BookDTO(String title, int price, String company, int page) {
		//�ʱ�ȭ �۾�
		this.title=title;
		this.price=price;
		this.company=company;
		this.page=page;	
	}
	// Ŭ���� �ȿ� �����ڰ� ������ ����Ʈ ������ ����, 
	// ������ ����Ʈ ������ ����.
	
}
