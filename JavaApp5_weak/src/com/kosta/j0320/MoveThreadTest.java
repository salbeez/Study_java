package com.kosta.j0320;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Thread.State;

import javax.swing.*;

public class MoveThreadTest extends JFrame implements Runnable, ActionListener {

	JLabel la;
	JButton bt_start, bt_stop;
	int x, y;
	Thread t;// start�� ���� �����带stop���� ����ϰ� �ϱ� ���Ͽ�

	public MoveThreadTest() {
		ImageIcon icon = new ImageIcon("image/RIGHT.GIF");

		bt_start = new JButton("����");
		bt_start.setBounds(0, 500, 70, 50);
		bt_stop = new JButton("����");
		bt_stop.setBounds(70, 500, 70, 50);
		la = new JLabel(icon);
		la.setBounds(0, 0, 55, 50);
		setTitle("�����̴� ȭ��ǥ");
		setLayout(null);
		add(bt_start);
		add(bt_stop);
		add(la);
		setBounds(300, 200, 600, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		bt_start.addActionListener(this);
		bt_stop.addActionListener(this);
	}

	public static void main(String[] args) {
		new MoveThreadTest();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {
			while (true) {
				Thread.sleep(50);
				if (x < 525) {
					x += 5;
				} else if (y < 525) {
					y += 5;
				}
				la.setLocation(x, y);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == bt_start) {
			if(t==null || t.getState() == State.TERMINATED){
				t = new Thread(this);
				t.start();	
			}
			
		} else if (e.getSource() == bt_stop) {
			t.stop();
		}

	}

}
