package kr.tpc;

public class Cat extends Animal {
	public void night() {
		System.out.println("¹ã¿¡ ´«¿¡¼­ ºûÀÌ ³­´Ù!");
	}

	@Override
	public void eat() {
		super.eat();
		System.out.println("°í¾çÀÌ Ã³·³ ¸Ô´Ù.");
	}
	
}
