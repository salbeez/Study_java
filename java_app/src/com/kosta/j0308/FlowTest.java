package com.kosta.j0308;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class FlowTest {
//	프로그램에 필요한 객체(container,component)를 선언
	
	Frame f;
	Button bt1,bt2,bt3,bt4,bt5;
	
	public FlowTest() {
//	선언된 객체 생성
		f = new Frame("FlowTest");
		bt1 = new Button("버튼1");
		bt2 = new Button("버튼2");
		bt3 = new Button("버튼3");
		bt4 = new Button("버튼4");
		bt5 = new Button("버튼5");
//	속성 설정(레이아웃, 붙이기 작업)
//		FlowLayout fl = new FlowLayout(); 한번만 쓸거니깐
		f.setLayout(new FlowLayout());
		f.add(bt1);
		f.add(bt2);
		f.add(bt3);
		f.add(bt4);
		f.add(bt5);
//	마무리 2개 [사용자에게 보여주는 ] 꼭 마지막에 설정(Frame size, Frame visible set)
		f.setSize(300, 300);
		f.setVisible(true);
	}
	public static void main(String[] args) {
//		생성자 호출 1개만 한다 메인에서는
//		FlowTest ft = new FlowTest();
		new FlowTest();//ft를 메인에서 쓸 일이 없으니깐...
	}
}
