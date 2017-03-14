package com.kosta.j0314;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class MouseMotionEventTest extends JFrame implements MouseMotionListener{

	JLabel green,red;
	public MouseMotionEventTest() {
		green = new JLabel("move");
		green.setBackground(Color.GREEN);
		green.setOpaque(true);
		
		red = new JLabel("DRAG");
		red.setBackground(Color.RED);
		
		green.setBounds(30, 30, 100, 100);
		red.setBounds(30, 130, 100, 100);
		red.setOpaque(true);
		
		setTitle("마우스 모션 테스트");
		setLayout(null);
		add(green);
		add(red);
		
		setBounds(200,100,600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setVisible(true);
		
		addMouseMotionListener(this);
	}

	public static void main(String[] args) {
		new MouseMotionEventTest();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX()-7-100;
		int y = e.getY()-30-100;
		
		red.setLocation(x, y);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX()-7-100;
		int y = e.getY()-30-100;
		
		green.setLocation(x,y);
	}
}
