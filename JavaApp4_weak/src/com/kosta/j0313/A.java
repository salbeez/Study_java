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
//		GUITest g = new GUITest();////여기도 또 생성하고 무한반복하네...
		if (e.getActionCommand()=="1번 버튼") {
			System.out.println("안녕!~~ 버튼 1");
		} else {
			System.out.println("안녕!~~ 버튼 2");
		}
	}

}
