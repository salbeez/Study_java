package com.kosta.j0313;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * GUITest
 * */
public class A implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		System.out.println(e.getActionCommand());
//		GUITest g = new GUITest();////���⵵ �� �����ϰ� ���ѹݺ��ϳ�...
		if (e.getActionCommand()=="1�� ��ư") {
			System.out.println("�ȳ�!~~ ��ư 1");
		} else {
			System.out.println("�ȳ�!~~ ��ư 2");
		}
	}

}
