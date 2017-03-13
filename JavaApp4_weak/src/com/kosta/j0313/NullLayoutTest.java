package com.kosta.j0313;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NullLayoutTest extends Frame {
	
	Button bt;
	public NullLayoutTest() {
		bt = new Button("qwe");
		bt.setSize(10,10);
		//null ���̾ƿ��� ����� ��� ������Ʈ�� ���μ��� ���̿� x,y�� ������ �ؾ���
	
		setLayout(null);
//		bt.setLocation(10, 10);
		//-->size + location ==> bounds
		bt.setBounds(30, 30, 30, 30);
		add(bt);

		setVisible(true);
		//setSize(300,300);
		setBounds(300,200,300,300);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		new NullLayoutTest();
	}
}
