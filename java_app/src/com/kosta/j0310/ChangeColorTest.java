package com.kosta.j0310;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Scrollbar;
import java.awt.TextArea;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class ChangeColorTest extends Frame implements AdjustmentListener {

	TextArea ta;
	Label la1, la2, la3;
	Scrollbar sc1, sc2, sc3;
	Panel big_p, p1, p2, p3;

	public ChangeColorTest() {
		ta = new TextArea();
		la1 = new Label("빨강 : ");
		la2 = new Label("파랑 : ");
		la3 = new Label("초록 : ");
		sc1 = new Scrollbar(Scrollbar.HORIZONTAL, 0, 0, 0, 256);
		sc2 = new Scrollbar(Scrollbar.HORIZONTAL, 0, 0, 0, 256);
		sc3 = new Scrollbar(Scrollbar.HORIZONTAL, 0, 0, 0, 256);
		sc3 = new Scrollbar(Scrollbar.HORIZONTAL, 0, 0, 0, 256);
		// int orientation, int value: 조절바 시작위치, int visible :조절바의 너비, int
		// minimum, int maximum

		big_p = new Panel();
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();

		p1.setLayout(new BorderLayout());
		p1.add("West", la1);
		p1.add("Center", sc1);

		p2.setLayout(new BorderLayout());
		p2.add("West", la2);
		p2.add("Center", sc2);

		p3.setLayout(new BorderLayout());
		p3.add("West", la3);
		p3.add("Center", sc3);

		big_p.setLayout(new GridLayout(5, 1, 10, 10));
		big_p.add(new Label());
		big_p.add(p1);
		big_p.add(p2);
		big_p.add(p3);

		setLayout(new GridLayout(1, 2));
		add(big_p);
		add(ta);
		// ---
		sc1.setValue(0);
		sc2.setValue(0);
		sc3.setValue(0);

		sc1.addAdjustmentListener(this);
		sc2.addAdjustmentListener(this);
		sc3.addAdjustmentListener(this);
		//
		setSize(300, 300);
		setVisible(true);

	}

	public static void main(String[] args) {
		new ChangeColorTest();
	}

	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		int red = sc1.getValue();
		int green = sc3.getValue();
		int blue = sc2.getValue();
		
		System.out.println(sc1.getValue());
		ta.setBackground(new Color(red, green, blue));
		ta.setText("red=" + red + " green=" + green + " blue=" + blue);
//		ta.append("red=" + red + " green=" + green + " blue=" + blue);
	}
}
