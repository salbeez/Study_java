package com.kosta.j0320;

class YouThread extends Thread {
	public YouThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		// 동시 실행할 코드를 위치
		try {
			for (int i = 0; i < 11; i++) {
				Thread.sleep(500);// 0.5sec
				System.out.println(getName() + " : " + i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class TreadTest2 {

	public static void main(String[] args) {
		YouThread t1 = new YouThread("길동");
		YouThread t2 = new YouThread("라임");
		YouThread t3 = new YouThread("주원");
		
		//스레드 우선순위 부여(1~10) 높은 숫자가 우선순위가 높다 
		t1.setPriority(10);
		t2.setPriority(5);
		t3.setPriority(1);
//		t1.setPriority(Thread.MAX_PRIORITY);
		
		t1.start();
		t2.start();
		t3.start();
	}
}
