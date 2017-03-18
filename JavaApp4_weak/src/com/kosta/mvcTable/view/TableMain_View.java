package com.kosta.mvcTable.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.ScrollPane;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TableMain_View extends JFrame {

	public JButton bt_input;
	public JButton bt_update;
	public JButton bt_del;
	public JButton bt_exit;
	public JButton bt_selectName;
	public JButton bt_selectPersons;
	public JTable table;
	public DefaultTableModel model;
	JScrollPane scroll;
	JPanel p;

	public TableMain_View() {
		init();
		setting();
	}

	private void setting() {
		setTitle("MVC CRUD���̺�");
		
		setLayout(new BorderLayout());
		
		p.setLayout(new FlowLayout());
		p.add(bt_input);
		p.add(bt_update);
		p.add(bt_del);
		p.add(bt_selectName);
		p.add(bt_selectPersons);
		p.add(bt_exit);
		
		add("Center",scroll);
		add("South",p);
		
		setVisible(true);
		setBounds(400, 300, 470, 300);//setBounds(x, y, width, height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void init() {// ��ü ����
		bt_input = new JButton("�Է�");
		bt_update = new JButton("����");
		bt_del = new JButton("����");
		bt_exit = new JButton("����");
		bt_selectName = new JButton("�κ� �˻�");
		bt_selectPersons = new JButton("��ü �˻�");
		
		String col[] ={"��ȣ","�̸�","����","����"}; 
		Object data[][] = new Object[0][4];//0�� addrow.�� ������ �ε���
		
		model = new DefaultTableModel(data,col);
		table = new JTable(model);
		scroll = new JScrollPane(table);
		
		p = new JPanel();
	}
}
