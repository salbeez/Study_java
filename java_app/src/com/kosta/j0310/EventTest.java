package com.kosta.j0310;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author ksota Frame�� �⺻ ���̾ƿ��� BorderLayout
 */

public class EventTest extends Frame implements ActionListener {
	Button bt, bt2;
	int count;

	public EventTest() {
		setTitle("�̺�Ʈ �׽�Ʈ");
		bt = new Button("��ư");
		bt2 = new Button("��ư2");

		setLayout(new FlowLayout());
		add(bt);
		add(bt2);
		setSize(300, 300);
		setVisible(true);

		bt.addActionListener(this);
		bt2.addActionListener(this);
	}

	public static void main(String[] args) {
		new EventTest();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//���� Ȱ��ȭ �ߴ��� Ȯ��
//		String e.getComponentAt(); ==>return String
//		������ �̺�Ʈ �ҽ��� ��ư�̶�� Button�̶�� ��ư�� ���� ����

//		e.getSource(); ==>return Object 
//		������ bt�� ���� �̺�Ʈ�ڵ鷯�� ȣ���ߴٸ� 
//				Object obj = bt; �ּҰ��� �����ؼ� obj���� ���� 
//		�����) e.getSource()�� �̺�Ʈ �ҽ��� ���۷����� ����
		
//		String label = e.getActionCommand();
//		if(label.equals("��ư")){ case 1;
		
		Object obj = e.getSource();// case 2; �̰� ����... �����ٰ� �Ѵ�
		if(obj==bt){
		setTitle("�ȳ�");
		bt.setLabel(""+count);
		count++;
		}
		else{
		//���α׷� ���� �޼ҵ�
		System.exit(0);
		}

	}

}
