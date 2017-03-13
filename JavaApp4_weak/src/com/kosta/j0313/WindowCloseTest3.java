package com.kosta.j0313;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowCloseTest3 extends Frame {

	public WindowCloseTest3() {
		// TODO Auto-generated constructor stub
		
		setTitle("â �ݱ� x");
		setVisible(true);
		setSize(200, 200);
		
/*�͸��� ���� Ŭ����
 * class C implements WindowListener{
 * }
 * class C extends WindowAdapter{}
 * 
 * addWindowListener(new C());
 * C c = new C();
 * addWindowListener(c)
 * */
		
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});//== extends WindowAdapter
	}

	public static void main(String[] args) {
		new WindowCloseTest3();
	}

}
