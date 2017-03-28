package vending_machine;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class farmItem_View extends JFrame {

	public JButton bt[] = new JButton[16];

	public farmItem_View() {
		init();
		setting();
	}

	private void init() {

		bt[0] = new JButton("1");
		bt[1] = new JButton("2");
		bt[2] = new JButton("3");
		bt[3] = new JButton("4");
		bt[4] = new JButton("5");
		bt[5] = new JButton("6");
		bt[6] = new JButton("7");
		bt[7] = new JButton("8");
		bt[8] = new JButton("9");
		bt[9] = new JButton("10");
		bt[10] = new JButton("11");
		bt[11] = new JButton("12");
		bt[12] = new JButton("13");
		bt[13] = new JButton("14");
		bt[14] = new JButton("15");
		bt[15] = new JButton("16");
	}

	private void setting() {

		setLayout(new GridLayout(4, 4));

		for (int i = 0; i < bt.length; i++) {
			add(bt[i]);
		}
		setVisible(false);
		setSize(300, 300);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
