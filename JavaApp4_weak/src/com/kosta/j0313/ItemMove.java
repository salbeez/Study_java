package com.kosta.j0313;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ItemMove extends Frame implements ActionListener {

	List list, list2;
	TextField tf, tf2;
	Button bt, bt2, bt3, bt4;
	Panel p, p2, p3;

	public ItemMove() {

		p = new Panel();
		p2 = new Panel();
		p3 = new Panel();

		bt = new Button("▷");
		bt2 = new Button("▶");
		bt3 = new Button("◁");
		bt4 = new Button("◀");

		tf = new TextField();
		tf2 = new TextField();

		list = new List();
		list2 = new List();
		// --
		p.setLayout(new BorderLayout());
		p.add("Center", list);
		p.add("South", tf);

		p2.setLayout(new GridLayout(6, 3, 0, 10));
		p2.setBackground(Color.ORANGE);
		p2.add(bt);
		p2.add(bt2);
		p2.add(bt3);
		p2.add(bt4);

		p3.setLayout(new BorderLayout());
		p3.add("Center", list2);
		p3.add("South", tf2);

		// --

		add(p);
		add(p2);
		add(p3);
		setLayout(new GridLayout(1, 3));
		setVisible(true);
		setSize(200, 200);

		// --
		tf.addActionListener(this);
		tf2.addActionListener(this);
		bt.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		new ItemMove();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == tf) {
			String str = tf.getText().trim();// 빈 공간 지우기
			if (str.length() != 0) {
				list.add(tf.getText());
				tf.setText("");
			}

		} else if (e.getSource() == tf2) {
			String str = tf2.getText().trim();// 빈 공간 지우기
			if (str.length() != 0) {
				list2.add(tf2.getText());
				tf2.setText("");
			}
		} else if (e.getSource() == bt) {

			if (list.getSelectedItem() != null) {// 선택을 했을때만 이동
				list2.add(list.getSelectedItem());
				list.remove(list.getSelectedIndex());
			}
		} else if (e.getSource() == bt2) {
			for (int i = 0; i < list.getItemCount(); i++) {
				list2.add(list.getItem(i));
			}
			list.removeAll();
		} else if (e.getSource() == bt3) {

			if (list2.getSelectedItem() != null) {
				list.add(list2.getSelectedItem());
				list2.remove(list2.getSelectedIndex());
			}
		} else if (e.getSource() == bt4) {
			for (int i = 0; i < list2.getItemCount(); i++) {
				list.add(list2.getItem(i));
			}
			list2.removeAll();
		} else {
			System.out.println("망했다");
		}
	}
}
