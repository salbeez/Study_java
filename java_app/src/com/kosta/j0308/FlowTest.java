package com.kosta.j0308;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class FlowTest {
//	���α׷��� �ʿ��� ��ü(container,component)�� ����
	
	Frame f;
	Button bt1,bt2,bt3,bt4,bt5;
	
	public FlowTest() {
//	����� ��ü ����
		f = new Frame("FlowTest");
		bt1 = new Button("��ư1");
		bt2 = new Button("��ư2");
		bt3 = new Button("��ư3");
		bt4 = new Button("��ư4");
		bt5 = new Button("��ư5");
//	�Ӽ� ����(���̾ƿ�, ���̱� �۾�)
//		FlowLayout fl = new FlowLayout(); �ѹ��� ���Ŵϱ�
		f.setLayout(new FlowLayout());
		f.add(bt1);
		f.add(bt2);
		f.add(bt3);
		f.add(bt4);
		f.add(bt5);
//	������ 2�� [����ڿ��� �����ִ� ] �� �������� ����(Frame size, Frame visible set)
		f.setSize(300, 300);
		f.setVisible(true);
	}
	public static void main(String[] args) {
//		������ ȣ�� 1���� �Ѵ� ���ο�����
//		FlowTest ft = new FlowTest();
		new FlowTest();//ft�� ���ο��� �� ���� �����ϱ�...
	}
}
