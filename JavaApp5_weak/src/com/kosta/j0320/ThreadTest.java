package com.kosta.j0320;

import javax.swing.JFrame;

class MyThread extends Thread {
	// �ڽ��� �θ��---> MyThread�� Thread

	// ����Ʈ Ư¡ ---> run();
	@Override
	public void run() {// ������ �޼ҵ� !!
		// �̰� ���� ���Ƿ� ������ �޼ҵ尡 �ƴ�
		// ���� ������ �������� �ϴ� �ڵ� ����� ..
		try {
			for (int i = 0; i < 10; i++) {
				Thread.sleep(1000);
				System.out.println("�ڹ� ������1 " + i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}// class

class MyThread2 extends JFrame implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			for(int i=0; i<11;i++){
				Thread.sleep(1000);
				System.out.println("�ڹ� ������2 " + i);
				
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

public class ThreadTest {

	public static void main(String[] args) {
		MyThread t = new MyThread();					//-->������ ��ü
		// ������ run()�޼ҵ�� �ݵ�� start()���� ���� ȣ���ؾ��Ѵ�!!!
		// run()�޼ҵ带 ���� ȣ��ô� �Ϲ� �޼ҵ�� ���̰� ����
		t.start();
		
		MyThread2 r = new MyThread2();		//������ ��ü�� �ƴ� Runnable��ü�̴� 
		Thread t2 = new Thread(r);				//t2��----> ������ ��ü�̴�		
		t2.start();
		
//		t.run(); �̰� �Ϲ� �޼ҵ�� �����ѰŴ�  start�� ���ؼ� ȣ����
	}
}
