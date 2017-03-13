package com.kosta.j0313;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowCloseTest extends Frame implements WindowListener{
	public WindowCloseTest() {
		// TODO Auto-generated constructor stub
	
	setTitle("창 닫기 x");
	setVisible(true);
	setSize(200, 200);
	
	addWindowListener(this);
	}

	public static void main(String[] args) {
		new WindowCloseTest();
	}

	@Override//이게 닫기 버튼과 매칭할수 있는 함수
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}


	public void windowOpened(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowActivated(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}
}
