package com.kosta.j0314;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class NumberBaseBall extends JFrame implements ActionListener {

	JLabel la;//
	JButton b_new, b_solution, b_clear, b_exit;
	JTextField tf;//
	JTextArea ta;//

	JPanel p1, p1_1, p2;//
	Random rd;
	String solution;// 컴퓨터가 발생한 문제

	public NumberBaseBall() {
		setTitle("숫자 야구 게임");

		la = new JLabel("입력 : ");
		ta = new JTextArea(30, 30);
		tf = new JTextField(10);

		b_clear = new JButton("지우기");
		b_exit = new JButton("종료");
		b_new = new JButton("새 게임");
		b_solution = new JButton("정답");

		p1 = new JPanel();
		p1_1 = new JPanel();
		p2 = new JPanel();

		p1_1.setLayout(new GridLayout(1, 2));
		p1_1.add(la);
		p1_1.add(tf);

		p1.setLayout(new BorderLayout());
		p1.add("Center", ta);
		p1.add("South", p1_1);

		p2.setBounds(75, 100, 200, 200);
		p2.add(b_new);
		p2.add(b_solution);
		p2.add(b_clear);
		p2.add(b_exit);

		setLayout(new GridLayout(1, 2));
		add(p1);
		add(p2);
		setVisible(true);
		setSize(300, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		b_clear.addActionListener(this);
		b_exit.addActionListener(this);
		b_new.addActionListener(this);
		b_solution.addActionListener(this);
		tf.addActionListener(this);
	}

	public static void main(String[] args) {
		new NumberBaseBall();
	}

	public int[] com_sol() {// 랜덤한 변수 조작
		rd = new Random();
		int comsol[] = { 0, 0, 0 };
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < i; j++) {
				comsol[i] = rd.nextInt(9) + 1;
				if (i > 0 && (comsol[i] == comsol[j])) {// 중복된 값이 없이
					i--;
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			System.out.println(comsol.toString());
		}

		return comsol;
	}

	public void compar(String tf, int[] is) {
		char[] tf_=tf.toCharArray();
		int[] tf2 = null;
		for(int i =0; i<tf_.length ; i++){
			tf2[i] = Integer.parseInt(tf, tf.charAt(i));
			System.out.println("tf2[i]");
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int i = 0, j = 0;
		Object obj = e.getSource();
		if (obj == tf) {
			// 사용자가 생각하는 정답
			compar(tf.getText(),com_sol());

		} else if (obj == b_new) {
			System.out.println();
			ta.setText("새 게임이 시작되었습니다");
		}
	}
}
