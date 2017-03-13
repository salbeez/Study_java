package com.kosta.j0313;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUITest2 extends Frame implements ActionListener{

	Button bt, bt2;
	TextField tf;
	public GUITest2() {
		bt = new Button("1�� ��ư");
		bt2 = new Button("2�� ��ư");
		tf =new TextField(10);
		
		setLayout(new FlowLayout());
		add(bt);
		add(bt2);
		add(tf);
		
		setSize(200, 200);
		setVisible(true);
		
		//������
		bt.addActionListener(this);
		bt2.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == bt){
			System.out.println("��ư 1");
		}else{
			System.out.println("��ư 2");			
		}
	}

	public static void main(String[] args) {
		new GUITest2();
	}

}
