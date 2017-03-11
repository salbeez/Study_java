package com.kosta.j0308;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

public class BorderTest {

	Frame f;
	Button b1,b2,b3,b4,b5;
	public BorderTest() {
		f=new Frame();
		b1 = new Button("��ư1");
		b2 = new Button("��ư2");
		b3 = new Button("��ư3");
		b4 = new Button("��ư4");
		b5 = new Button("��ư5");
		
		f.setLayout(new BorderLayout());
		f.add("North",b1 );
		f.add("South",b2 );
		f.add("East",b3 );
		f.add("West",b4 );
		f.add("Center",b5 );
		
		f.setSize(300, 300);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new BorderTest();
	}
}
