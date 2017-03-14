package com.kosta.j0313;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;

public class GUITest extends Frame {

	Button bt, bt2;
	TextField tf;
	public GUITest() {
		bt = new Button("1번 버튼");
		bt2 = new Button("2번 버튼");
		tf =new TextField(10);
		
		setLayout(new FlowLayout());
		add(bt);
		add(bt2);
		add(tf);
		setSize(200, 200);
		setVisible(true);
		
		//감시자
		A a = new A();
		B b = new B();
		bt.addActionListener(a);
		bt2.addActionListener(a);
	}

	public static void main(String[] args) {
		new GUITest();
	}
}
