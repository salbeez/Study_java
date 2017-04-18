package com.kosta.j0412.V;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class LoginForm extends JFrame {
	
	JPanel p,p2,p3;
	JLabel la_id,la_pw;
	public JButton bt_log,bt_newJoin;
	public JTextField tf_id;
	public JPasswordField tf_pw;
	
	public LoginForm() {
		setTitle("LOGIN");
		init();
		setting();
	}

	private void setting() {
		
		p.setLayout(new FlowLayout());
		p.add(la_id);
		p.add(tf_id);
		p.add(bt_newJoin);
		
		p2.setLayout(new FlowLayout());
		p2.add(la_pw);
		p2.add(tf_pw);
		
		p3.setLayout(new FlowLayout());
		p3.add(bt_log);

		
		setLayout(new GridLayout(3,1));
		add(p);
		add(p2);
		add(p3);
		
		
		setSize(250, 150);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void init() {
		p = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		
		la_id = new JLabel("ID");
		la_pw = new JLabel("Password");
		
		bt_log = new JButton("로그인");
		bt_newJoin = new JButton("신규가입");
		
		tf_id = new JTextField(5);
		tf_pw = new JPasswordField(5);
	}
	
	public void init_text(){

		tf_id.setText("");
		tf_pw.setText("");
	}
    public void showMsg(String message){
   	 JOptionPane.showMessageDialog(this, message);
    }
}
