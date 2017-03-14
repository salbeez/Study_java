package com.kosta.j0314;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class SwingTest extends JFrame implements ActionListener{
	JButton bt;
	public SwingTest() {
		bt = new JButton("<html>나버튼</html>");
		
//		setLayout(new FlowLayout());
		setLayout(new FlowLayout());
		add(bt);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//종료버튼
		
		setBounds(300,200,300,300);
		setVisible(true);
		bt.addActionListener(this);
		
	}
	public static void main(String[] args) {
		new SwingTest();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("HELLO");
		JOptionPane.showConfirmDialog(this, "this");
		
	}
}
