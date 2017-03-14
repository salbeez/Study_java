package com.kosta.j0314;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class JRadioButtonTest extends JFrame {
	
	JRadioButton bt,bt2,bt3;
	ButtonGroup group;
	
	public JRadioButtonTest() {
		bt = new JRadioButton("아침");
		bt2 = new JRadioButton("점심");
		bt3 = new JRadioButton("저녁");
		
		group = new ButtonGroup();
		group.add(bt);
		group.add(bt2);
		group.add(bt3);
		
		setLayout(new GridLayout(3, 1));
		add(bt);
		add(bt2);
		add(bt3);
		
		setBounds(300,200,300,300);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JRadioButtonTest();
	}
}
