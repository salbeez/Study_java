package com.kosta.j0309;

import java.awt.Frame;

public class FrameTest1  {
	Frame f;	//�����̳� ��ü

	public FrameTest1() {
		f= new Frame("�ѱ�");
//		aSDJHASDF
		f.setSize(300,300);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new FrameTest1();
	}
}