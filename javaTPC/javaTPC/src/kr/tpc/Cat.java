package kr.tpc;

public class Cat extends Animal {
	public void night() {
		System.out.println("�㿡 ������ ���� ����!");
	}

	@Override
	public void eat() {
		super.eat();
		System.out.println("����� ó�� �Դ�.");
	}
	
}
