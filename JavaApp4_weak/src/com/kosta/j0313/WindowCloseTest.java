package com.kosta.j0313;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowCloseTest extends Frame implements WindowListener{
	public WindowCloseTest() {
		// TODO Auto-generated constructor stub
	
	setTitle("â �ݱ� x");
	setVisible(true);
	setSize(200, 200);
	
	addWindowListener(this);
	}

	public static void main(String[] args) {
		new WindowCloseTest();
	}

	@Override//�̰� �ݱ� ��ư�� ��Ī�Ҽ� �ִ� �Լ�
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
