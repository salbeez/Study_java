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
	}//생성자 끝


	private void init() {
		tf_Search = new JTextField(5);
		la_Search = new JLabel("검색할 속성 선택과 찾을 이름을 써주세요");
		combo_Search = new JComboBox<>();
		bt_Search_Cancel = new JButton("검색 취소");
		bt_Search_Submit = new JButton("검색 전송");
		searchP = new JPanel();
		searchP2 = new JPanel();
	}//초기화
	
	private void setting() {
		setTitle("검색폼");
		setLayout(new GridLayout(3, 1));
		add(la_Search);	//1행
		
		combo_Search.addItem("OO으로 시작하는");
		combo_Search.addItem("OO이 있는");
		
		
		searchP.setLayout(new FlowLayout());
		searchP.add(combo_Search);
		searchP.add(tf_Search);
		
		searchP2.setLayout(new FlowLayout());
		searchP2.add(bt_Search_Submit);
		searchP2.add(bt_Search_Cancel);
		
		add(searchP);//2행
		add(searchP2);//3행
		
		setVisible(false);
		setBounds(400, 300, 270, 150);
	}
}
