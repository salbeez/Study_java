package com.kosta.mvcTable.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

import com.sun.org.apache.xml.internal.security.Init;

public class TableInput_View extends JFrame {
	JLabel la_name,la_age,la_job;
	public JTextField t_name,t_age,t_job;
	public JButton b_input,b_cancel;
	JPanel p,p2,p3,p4;
	
	public TableInput_View() {//������
		init_obj();
		setting();
	}

	private void setting() {
		setTitle("�Է���");
		setLayout(new GridLayout(4, 1));
		
		p.setLayout(new FlowLayout());
		p.add(la_name);
		p.add(t_name);
		
		p2.setLayout(new FlowLayout());
		p2.add(la_age);
		p2.add(t_age);
		
		p3.setLayout(new FlowLayout());
		p3.add(la_job);
		p3.add(t_job);
		
		p4.setLayout(new FlowLayout());
		p4.add(b_input);
		p4.add(b_cancel);
		
		add(p);
		add(p2);
		add(p3);
		add(p4);
		
		setVisible(false);
		setBounds(400, 300, 200, 250);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void init_obj() {
		// TODO Auto-generated method stub
		la_name = new JLabel("�̸� : ");
		la_age = new JLabel("���� : ");
		la_job = new JLabel("���� : ");
		
		t_name = new JTextField(5);
		t_age = new JTextField(5);
		t_job = new JTextField(5);
		
		b_input = new JButton("�Է�");
		b_cancel = new JButton("���");
		
		p = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
	}

}
