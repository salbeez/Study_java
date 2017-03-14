package com.kosta.j0314;

import java.awt.FlowLayout;
import java.awt.event.MouseListener;

import javax.swing.*;

import org.w3c.dom.events.MouseEvent;

public class MouseEventTest extends JFrame implements MouseListener {
	JButton bt;

	public MouseEventTest() {

		setTitle("마우스 이벤트");

		bt = new JButton("♤♤♤");

		setLayout(new FlowLayout());
		add(bt);

		setVisible(true);
		setBounds(300, 200, 300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		bt.addMouseListener(this);
	}

	public static void main(String[] args) {
		new MouseEventTest();
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("1");
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("2");
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("3");
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("4");
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("5");
	}
}
