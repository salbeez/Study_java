package com.kosta.j0313;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowCloseTest2 extends WindowAdapter {
	Frame f;

	public WindowCloseTest2() {
		// TODO Auto-generated constructor stub
		f = new Frame();
		f.setTitle("Ã¢ ´Ý±â x");
		f.setVisible(true);
		f.setSize(200, 200);

		f.addWindowListener(this);
	}

	public static void main(String[] args) {
		new WindowCloseTest2();
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}
}
