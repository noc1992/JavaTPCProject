package kr.tpc;

public class TV implements Remocon {
	int initialCH=0;
	@Override
	public void chUp() {
		if(initialCH<Remocon.MAXCH) {
			initialCH++;
			System.out.println("현재 채널: " + initialCH);
		} else {
		initialCH=0;
		System.out.println("현재 채널: " + initialCH);
		}
		
	}

	@Override
	public void chDown() {
		if(initialCH > Remocon.MINCH) {
			initialCH--;
			System.out.println("현재 채널: " + initialCH);
		} else {
			initialCH=100;
			System.out.println("현재 채널: " + initialCH);
		}
			
	}

	@Override
	public void internet() {
		System.out.println("인터넷이 된다.");
	}
	
}
