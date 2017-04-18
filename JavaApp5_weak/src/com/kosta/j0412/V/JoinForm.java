package com.kosta.j0412.V;



import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.*;

public class JoinForm extends JFrame {
	
	JLabel la_id,la_pw,la_pw2,la_name,la_ssn,la_phone,la_addr,la_job;
	public JTextField tf_id,tf_name,tf_ss1,tf_ph1,tf_ph2,tf_ph3,tf_addr;
	public JPasswordField pw,pw2,ssn2;
	public JComboBox<String> combo;
	public JButton bt_submmit,bt_duple,bt_cancel;
	public boolean flag = false;
	
	JPanel p[] = new JPanel[9]; //size 9
	JPanel p_1,p_2;
	public JoinForm() {
		setTitle("회원가입");
		init();
		setting();
	}

	private void init() {
		la_id = new JLabel("ID :");
		la_pw = new JLabel("비번 :");
		la_pw2 = new JLabel("비번확인 :");
		la_name = new JLabel("이름 :");
		la_ssn = new JLabel("주민번호 :");
		la_phone = new JLabel("전화번호 :");
		la_addr = new JLabel("주소 :");
		la_job = new JLabel("직업 :");
		
		tf_id= new JTextField(6);
		tf_name= new JTextField(6);
		tf_ss1= new JTextField(4);
		tf_ph1= new JTextField(4);
		tf_ph2= new JTextField(4);
		tf_ph3= new JTextField(4);
		tf_addr= new JTextField(12);
		
		pw =new JPasswordField(6);
		pw2 =new JPasswordField(6);
		ssn2 = new JPasswordField(4);
		
		combo = new JComboBox<>();
		bt_submmit =new JButton("등록");
		bt_duple = new JButton("중복확인");
		bt_cancel = new JButton("취소");
		
		p[0] = new JPanel(); 
		p[1] = new JPanel(); 
		p[2] = new JPanel(); 
		p[3] = new JPanel(); 
		p[4] = new JPanel(); 
		p[5] = new JPanel(); 
		p[6] = new JPanel(); 
		p[7] = new JPanel(); 
		p[8] = new JPanel(); 
		
		p_1= new JPanel();
		p_2 = new JPanel();
	}

	private void setting() {
		p[0].setLayout(new GridLayout(1, 3));
		p[0].add(la_id);
		p[0].add(tf_id);
		p[0].add(bt_duple);
		
		p[1].setLayout(new GridLayout(1, 3));
		p[1].add(la_pw);
		p[1].add(pw);

		p[2].setLayout(new GridLayout(1, 3));
		p[2].add(la_pw2);
		p[2].add(pw2);
		
		p[3].setLayout(new GridLayout(1, 3));
		p[3].add(la_name);
		p[3].add(tf_name);
		
		p[4].setLayout(new GridLayout(1, 3));
		p[4].add(la_ssn);
			p_1.setLayout(new FlowLayout());
			p_1.add(tf_ss1);
			p_1.add(new JLabel("-"));
			p_1.add(ssn2);	
		p[4].add(p_1);
		
		p[5].setLayout(new GridLayout(1, 3));
		p[5].add(la_phone);
			p_2.setLayout(new FlowLayout());
			p_2.add(tf_ph1);
			p_2.add(new JLabel("-"));
			p_2.add(tf_ph2);
			p_2.add(new JLabel("-"));
			p_2.add(tf_ph3);
		p[5].add(p_2);
		
		p[6].setLayout(new GridLayout(1, 3));
		p[6].add(la_addr);
		p[6].add(tf_addr);
		
		p[7].setLayout(new GridLayout(1, 3));
		p[7].add(la_job);
		combo.addItem("학생");
		combo.addItem("백수");
		combo.addItem("망나니");
		p[7].add(combo);
		
		p[8].setLayout(new FlowLayout());
		p[8].add(bt_submmit);
		p[8].add(bt_cancel);
		
		setLayout(new GridLayout(10,0));
		add(p[0]);
		add(p[1]);
		add(p[2]);
		add(p[3]);
		add(p[4]);
		add(p[5]);
		add(p[6]);
		add(p[7]);
		add(p[8]);
		
		setSize(400,500);
		setVisible(false);
	}
	public void init_text(){

		tf_id.setText("");
		tf_name.setText("");
		tf_ss1.setText("");
		tf_ph1.setText("");
		tf_ph2.setText("");
		tf_ph3.setText("");
		tf_addr.setText("");
		
		pw.setText("");
		pw2.setText("");
		ssn2.setText("");
	}
    public void showMsg(String message){
   	 JOptionPane.showMessageDialog(this, message);
    }
}
