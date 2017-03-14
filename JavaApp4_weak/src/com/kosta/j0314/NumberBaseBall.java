package com.kosta.j0314;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
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
	int[] solution = new int[3];// 컴퓨터가 발생한 문제
	int[] myanswer = new int[3];// 내가 쓴 답

	static int sk = 0, ball = 0;

	JScrollPane scrollPane;
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

		p1_1.setLayout(new FlowLayout());
		p1_1.add(la);
		p1_1.add(tf);

		scrollPane = new JScrollPane(ta);
		p1.setLayout(new BorderLayout());
		p1.add("Center", scrollPane);
		p1.add("South", p1_1);

		p2.setLayout(new GridBagLayout());
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

	public void random_Com() {// 랜덤한 변수 조작
		rd = new Random();

		for (int i = 0; i < 3; i++) {
			solution[i] = rd.nextInt(9) + 1;
			for (int j = 0; j < i; j++) {
				if (solution[i] == solution[j]) {
					i--;
					break;
				}
			}
		}
	}

	public void compar(String textF, int[] solution) {
		System.out.println("*");
		char[] tf = textF.toCharArray();

		for (int i = 0; i < tf.length; i++) {
			myanswer[i] = (int) tf[i] - 48;// 문자 -> 숫자로
			System.out.println(myanswer[i]);
		} // 숫자로 끝
			// ====

		for (int i = 0; i < tf.length; i++) {
			for (int j = 0; j < tf.length; j++) {
				if (myanswer[i] == solution[j]) {

					if (i == j) {
						sk++;
					} else {
						ball++;
					}
				}
			}
		} // sk ball 계산 끝

		if (sk + ball == 0) {// 다틀렸을 때
			ta.append("\n다 틀렸다");
		} else if (sk == 3) {// 정답
			ta.append("\n정답입니다");
		} else {
			ta.append("\nsk : " + sk + " ball : " + ball);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int i = 0, j = 0;
		Object obj = e.getSource();
		if (obj == tf) {
			// 사용자가 생각하는 정답
			sk = 0;
			ball = 0;
			if (solution != null) {// 랜덤 숫자 발생하지 않음
				String tftest = tf.getText();
				if (tftest.length() == 3) {// 사이즈가 지정된 것만
					compar(tftest, solution);
					tf.setText("");
				} else {
					ta.append("\n문자열이 너무 길거나 짧습니다 [3자릿수]");
				}
			} else {
				ta.append("\n랜덤 숫자 발생 안함.. 새 게임을 눌러 주세요");
			}

		} else if (obj == b_new) {
			System.out.println();
			random_Com();// 랜덤 숫자 발생
			sk = 0;
			ball = 0;
			ta.setText("새 게임이 시작되었습니다");
		} else if (obj == b_solution) {
			ta.append("\n" + Arrays.toString(solution));
		} else if (obj == b_clear) {
			ta.setText("");
		} else if (obj == b_exit) {
			System.exit(0);
		}
	}
}
