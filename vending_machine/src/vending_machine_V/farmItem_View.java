package vending_machine_V;

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
		
		bt[0] = new JButton("1",new ImageIcon("image/가지.jpg"));
		bt[1] = new JButton("2",new ImageIcon("image/감자.jpg"));
		bt[2] = new JButton("3",new ImageIcon("image/고구마.jpg"));
		bt[3] = new JButton("4",new ImageIcon("image/단호박.jpg"));
		bt[4] = new JButton("5",new ImageIcon("image/당근.jpg"));
		bt[5] = new JButton("6",new ImageIcon("image/대파.jpg"));
		bt[6] = new JButton("7",new ImageIcon("image/무.jpg"));
		bt[7] = new JButton("8",new ImageIcon("image/부추.jpg"));
		bt[8] = new JButton("9",new ImageIcon("image/브로콜리.jpg"));
		bt[9] = new JButton("10",new ImageIcon("image/시금치.jpg"));
		bt[10] = new JButton("11",new ImageIcon("image/애호박.jpg"));
		bt[11] = new JButton("12",new ImageIcon("image/양배추.jpg"));
		bt[12] = new JButton("13",new ImageIcon("image/양파.jpg"));
		bt[13] = new JButton("14",new ImageIcon("image/연근.jpg"));
		bt[14] = new JButton("15",new ImageIcon("image/열무.jpg"));
		bt[15] = new JButton("16",new ImageIcon("image/파프리카.jpg"));
	}

	private void setting() {

		setLayout(new GridLayout(4, 4));

		for (int i = 0; i < bt.length; i++) {
			add(bt[i]);
		}
		setVisible(false);
		setSize(300, 300);
		// setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
