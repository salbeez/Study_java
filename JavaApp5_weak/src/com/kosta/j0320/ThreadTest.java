package com.kosta.j0320;

import javax.swing.JFrame;

class MyThread extends Thread {
	// 자식은 부모다---> MyThread는 Thread

	// 스레트 특징 ---> run();
	@Override
	public void run() {// 스레드 메소드 !!
		// 이건 내가 임의로 정의한 메소드가 아님
		// 동시 실행을 목적으로 하는 코드 문장들 ..
		try {
			for (int i = 0; i < 10; i++) {
				Thread.sleep(1000);
				System.out.println("자바 스레드1 " + i);
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
				System.out.println("자바 스레드2 " + i);
				
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

public class ThreadTest {

	public static void main(String[] args) {
		MyThread t = new MyThread();					//-->스레드 객체
		// 스레드 run()메소드는 반드시 start()ㄹ르 통해 호출해야한다!!!
		// run()메소드를 직접 호출시는 일반 메소드와 차이가 없음
		t.start();
		
		MyThread2 r = new MyThread2();		//스레드 객체는 아님 Runnable객체이다 
		Thread t2 = new Thread(r);				//t2는----> 스레드 객체이다		
		t2.start();
		
//		t.run(); 이건 일반 메소드로 실행한거다  start를 통해서 호출하
	}
}
