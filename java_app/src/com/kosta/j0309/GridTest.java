package com.kosta.j0309;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

public class GridTest {
	
	Frame f;
	Button b1,b2,b3,b4,b5;
	public GridTest() {//��� �� ���̾ƿ� �׽�Ʈ[���� ũ���� ����]

		f =new Frame();
		b1  = new Button("��ư 1");
		b2  = new Button("��ư 2");
		b3  = new Button("��ư 3");
		b4  = new Button("��ư 4");
		b5  = new Button("��ư 5");
		
		
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
