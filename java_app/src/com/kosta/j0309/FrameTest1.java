package com.kosta.j0309;

import java.awt.Frame;

public class FrameTest1  {
	Frame f;	//ÄÁÅ×ÀÌ³Ê °´Ã¼

	public FrameTest1() {
		f= new Frame("»Ñ±î");
//		aSDJHASDF
		f.setSize(300,300);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new FrameTest1();
	}
}