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
		setTitle("MVC CRUD테이블");
		
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

	private void init() {// 객체 생성
		bt_input = new JButton("입력");
		bt_update = new JButton("수정");
		bt_del = new JButton("삭제");
		bt_exit = new JButton("종료");
		bt_selectName = new JButton("부분 검색");
		bt_selectPersons = new JButton("전체 검색");
		
		String col[] ={"번호","이름","나이","직업"}; 
		Object data[][] = new Object[0][4];//0행 addrow.시 시작할 인덱스
		
		model = new DefaultTableModel(data,col);
		table = new JTable(model);
		scroll = new JScrollPane(table);
		
		p = new JPanel();
	}
}
