package com.kosta.mvcCalculation.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * @author ksota 계산기 폼
 */
public class View extends JFrame {

	public JTextField tf_su1, tf_su2;
	public JComboBox<String> combo_oper;
	public JButton bt_calc;
	public JLabel la_result;

	public View() {
		setTitle("MVC 간단 계산기");

		tf_su1 = new JTextField(5);
		tf_su2 = new JTextField(5);
		combo_oper = new JComboBox<>();
			combo_oper.addItem("+");
			combo_oper.addItem("-");
			combo_oper.addItem("/");
			combo_oper.addItem("*");

		bt_calc = new JButton("계산");
		la_result = new JLabel("");

		setLayout(new FlowLayout());
		
		add(tf_su1);
		add(combo_oper);
		add(tf_su2);
		add(bt_calc);
		add(la_result);
		
		setVisible(true);
		setBounds(400, 300, 300, 100);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
			
	}
}
