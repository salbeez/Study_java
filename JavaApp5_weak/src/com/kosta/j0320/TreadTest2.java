package com.kosta.j0320;

class YouThread extends Thread {
	public YouThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		// ���� ������ �ڵ带 ��ġ
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
		YouThread t1 = new YouThread("�浿");
		YouThread t2 = new YouThread("����");
		YouThread t3 = new YouThread("�ֿ�");
		
		//������ �켱���� �ο�(1~10) ���� ���ڰ� �켱������ ���� 
		t1.setPriority(10);
		t2.setPriority(5);
		t3.setPriority(1);
//		t1.setPriority(Thread.MAX_PRIORITY);
		
		t1.start();
		t2.start();
		t3.start();
	}
}
