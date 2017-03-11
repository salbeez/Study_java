package com.kosta.j0309;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

public class GridTest {
	
	Frame f;
	Button b1,b2,b3,b4,b5;
	public GridTest() {//행과 열 레이아웃 테스트[같은 크기의 격자]

		f =new Frame();
		b1  = new Button("버튼 1");
		b2  = new Button("버튼 2");
		b3  = new Button("버튼 3");
		b4  = new Button("버튼 4");
		b5  = new Button("버튼 5");
		
		
		f.setLayout(new GridLayout(3, 2, 50, 10));
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		
		f.setSize(300, 300);
		f.setVisible(true);
		
	}
	public static void main(String[] args) {
		new GridTest();
	}
}
