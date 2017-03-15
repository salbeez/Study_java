package com.kosta.j0314;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.Arrays;
import java.util.Random;
import java.util.Vector;

import javax.swing.*;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/**
 * @author ksota 추가 기능 1.힌트 2.게임 시작시 포커스 맞춰주기 .requestFocus();** 3.최초 게임시 설명**
 *         4.TextField내에서 쓰기 금지** 5.새게임 버튼 클릭하기 전까지 tf도 쓰기 금지** 6.사용자가 입력한
 *         데이터네대한 검사** 7.새게임 버튼 클릭 -> 게임 초기화**
 */
public class NumberBaseBall extends JFrame implements ActionListener {

	JLabel la;//
	JButton b_new, b_solution, b_clear, b_exit, b_hint;
	JTextField tf;//
	JTextArea ta;//

	JPanel p1, p1_1, p2;//
	Random rd;
	int[] solution = new int[3];// 컴퓨터가 발생한 문제
	int[] myanswer = new int[3];// 내가 쓴 답
	int count;

	JScrollPane scrollPane;
	Vector<String> duplecarion;
	int duple_Count;
	public NumberBaseBall() {
		setTitle("숫자 야구 게임");

		duplecarion=new Vector<>();
		
		la = new JLabel("입력 : ");
		ta = new JTextArea(30, 30);
		tf = new JTextField(10);

		b_clear = new JButton("지우기");
		b_exit = new JButton("종료");
		b_new = new JButton("새 게임");
		b_solution = new JButton("정답");
		b_hint = new JButton("힌트");

		p1 = new JPanel();
		p1_1 = new JPanel();
		p2 = new JPanel();

		p1_1.setLayout(new FlowLayout());
		p1_1.add(la);
		p1_1.add(tf);

		scrollPane = new JScrollPane(ta);

		ta.setFont(new Font("궁서", Font.BOLD, 28));
		ta.setLineWrap(true);// 자동 줄 바꿈 기능
		p1.setLayout(new BorderLayout());
		p1.add("Center", scrollPane);
		p1.add("South", p1_1);

		p2.setLayout(new FlowLayout());
		p2.add(b_new);
		p2.add(b_solution);
		p2.add(b_clear);
		p2.add(b_hint);
		p2.add(b_exit);

		init();// 게임 설명 부분및 기타 초기화

		setLayout(new GridLayout(1, 2));
		add(p1);
		add(p2);
		setVisible(true);
		setSize(300, 300);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		eventUP();// 연결자 등록
		// ===========
		tf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				if (tf.isEnabled() == false) {
					JOptionPane.showMessageDialog(tf, "새 게임을 눌러주세여");
				}
			}
		});
	}

	private void eventUP() {
		b_clear.addActionListener(this);
		b_exit.addActionListener(this);
		b_new.addActionListener(this);
		b_solution.addActionListener(this);
		b_hint.addActionListener(this);
		tf.addActionListener(this);
	}

	public void hint() {
		if (count != 0) {
			// System.out.println(solution[rd.nextInt(3)]);
			ta.append("\n힌트 : " + Integer.toString(solution[rd.nextInt(3)]));
			b_hint.setEnabled(false);
		}
	}
	
	public boolean duplecateCheck(String tf){
		
		if(duple_Count!=0){
			for(int i=0; i<duplecarion.size();i++){
				if(tf.equals(duplecarion.get(i))){
					System.out.println("1");
					ta.append("\n중복된 값을 입력했습니다");
					return false;
				}
			}
		}
		System.out.println("2");
		duplecarion.add(tf);
		duple_Count++;
		return true;
	}
	
	public static void main(String[] args) {
		new NumberBaseBall();
	}

	public void init() {// 초기 상태 설정

		ta.setEditable(false);
		tf.setEnabled(false);// textF의 초기 상태
		b_solution.setEnabled(false);
		b_hint.setEnabled(false);
		ta.setText("==========" + "\n==========" + "\n==========" + "\n설명 난 지금 궁서체다");
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

	public void changeToArrayInt(String textF) {
		char[] tf = textF.toCharArray();

		for (int i = 0; i < tf.length; i++) {
			myanswer[i] = (int) tf[i] - 48;// 문자 -> 숫자로
			System.out.println(myanswer[i]);
		}
	}

	public void compar(int[] solution) {
		int sk = 0, ball = 0;
		// 숫자로 끝
		// ====

		for (int i = 0; i < myanswer.length; i++) {
			for (int j = 0; j < solution.length; j++) {
				if (myanswer[i] == solution[j]) {
					count++;

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
			complete();
		} else {
			ta.append("\n" + count + " ▶ "+Arrays.toString(myanswer)+" sk : " + sk + " ball : " + ball);
		}

	}

	public void complete() {
		b_solution.setEnabled(false);
		b_hint.setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int i = 0;
		Object obj = e.getSource();
		if (obj == tf) {
			// 사용자가 생각하는 정답
			if (solution != null) {// 랜덤 숫자 발생하지 않음
				String tftest = tf.getText();
				if (tftest.matches("[0-9]{3}") && duplecateCheck(tftest)) {// 세자리 숫자값이 아닌경우 && 중복체크
					
						changeToArrayInt(tftest);// 내가 쓴값을 숫자 배열로 만들고
						compar(solution);
						tf.setText("");

				} else {
					ta.append("\n세자리의 숫자값을 입력해 주세여");
					tf.setText("");
				}

			} else {
				ta.append("\n랜덤 숫자 발생 안함.. 새 게임을 눌러 주세요");
			}

		} else if (obj == b_new) {
			count = 0;

			b_hint.setEnabled(true);
			b_solution.setEnabled(true);
			duplecarion.removeAllElements();
			tf.setEnabled(true);
			tf.requestFocus();
			random_Com();// 랜덤 숫자 발생
			ta.setText("새 게임이 시작되었습니다");
		} else if (obj == b_solution) {
			ta.append("\n" + Arrays.toString(solution));
		} else if (obj == b_clear) {
			ta.setText("");
		} else if (obj == b_exit) {
			System.exit(0);
		} else if (obj == b_hint) {
			System.out.println("*");
			hint();
		}
	}
}