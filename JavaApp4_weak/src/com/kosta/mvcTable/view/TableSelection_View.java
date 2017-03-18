package com.kosta.mvcTable.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;


public class TableSelection_View extends JFrame {
	public JTextField tf_Search;
	public JComboBox<String> combo_Search;
	public JButton bt_Search_Submit;
	public JButton bt_Search_Cancel;
	
	private JLabel la_Search;
	private JPanel searchP,searchP2;
	
	public TableSelection_View() {
		init();
		setting();
	}//������ ��


	private void init() {
		tf_Search = new JTextField(5);
		la_Search = new JLabel("�˻��� �Ӽ� ���ð� ã�� �̸��� ���ּ���");
		combo_Search = new JComboBox<>();
		bt_Search_Cancel = new JButton("�˻� ���");
		bt_Search_Submit = new JButton("�˻� ����");
		searchP = new JPanel();
		searchP2 = new JPanel();
	}//�ʱ�ȭ
	
	private void setting() {
		setTitle("�˻���");
		setLayout(new GridLayout(3, 1));
		add(la_Search);	//1��
		
		combo_Search.addItem("OO���� �����ϴ�");
		combo_Search.addItem("OO�� �ִ�");
		
		
		searchP.setLayout(new FlowLayout());
		searchP.add(combo_Search);
		searchP.add(tf_Search);
		
		searchP2.setLayout(new FlowLayout());
		searchP2.add(bt_Search_Submit);
		searchP2.add(bt_Search_Cancel);
		
		add(searchP);//2��
		add(searchP2);//3��
		
		setVisible(false);
		setBounds(400, 300, 270, 150);
	}
}
