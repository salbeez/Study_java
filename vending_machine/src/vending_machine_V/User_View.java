package vending_machine_V;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class User_View extends JFrame {
	JButton bt_menu[];
	JButton bt_bill1, bt_bill5, bt_bill10, bt_bill50, bt_exch, bt_admin, bt_out;
	JTextField tf_balance;
	JTextArea ta_info;

	JPanel p_la[], p_bt[];
	JPanel p_all, p_bill, p_exch;
	
	JLabel laArr[];
	JLabel la_product, la_inform, la_bill, la_out,la_bar1,la_bar2;
	ImageIcon icon_exch, icon_admin, icon_out;

	public User_View() {
		init();
		setting();

		icon_out = new ImageIcon();

		la_out = new JLabel(icon_out);
		la_out.setBounds(420, 325, 140, 110);


		la_bar2.setBounds(180, 505, 400, 15);

		tf_balance = new JTextField();
		tf_balance.setBounds(280, 530, 130, 40);


		ta_info.setBounds(60, 325, 340, 170);
		ta_info.setText("\n\t<농산물자판기>");
		ta_info.append("\n 매일 새롭게 입고되는 신선한 농산물");
		ta_info.append("\n 원하시는 상품을 누르면 상품에 대한 정보가 나옵니다.");
		ta_info.append("\n 지폐 투입시 상품선택버튼으로 변경됩니다.");
		ta_info.append("\n 문의처 : 02-1234-5678");


		p_all = new JPanel();
		p_all.setLayout(null);
		p_all.setBackground(Color.orange);
		p_all.add(p_la[0]);
		p_all.add(p_bt[1]);
		p_all.add(p_la[0]);
		p_all.add(p_bt[1]);
		p_all.add(la_bar1);
		p_all.add(ta_info);
		p_all.add(la_bar2);
		p_all.add(p_bill);
		p_all.add(tf_balance);
		p_all.add(bt_exch);
		p_all.add(bt_admin);
		p_all.add(la_out);
		p_all.add(bt_out);

		add(p_all);
		setBounds(300, 200, 600, 700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	private void init() {
		bt_menu = new JButton[8];
		for (int i = 0; i < bt_menu.length; i++) {
			bt_menu[i] = new JButton("제품" + i + 1);
			bt_menu[i].setBackground(Color.red);
		}

		laArr = new JLabel[8];
		for (int i = 0; i < bt_menu.length; i++) {
			laArr[i] = new JLabel(new ImageIcon("m.jpg"));
		}

		bt_bill1 = new JButton("1,000");
		bt_bill5 = new JButton("5,000");
		bt_bill10 = new JButton("10,000");
		bt_bill50 = new JButton("50,000");
		bt_exch = new JButton("잔돈");
		bt_admin = new JButton("#");
		bt_out = new JButton();

		p_la = new JPanel[2];
		for (int i = 0; i < p_la.length; i++) {
			p_la[i] = new JPanel();
		}
		p_bt = new JPanel[2];
		for (int i = 0; i < p_bt.length; i++) {
			p_bt[i] = new JPanel();
			p_bt[i].setLayout(new GridLayout(1, 4));
		}
		
		la_bar1 = new JLabel("신선한 과일,채소를 간편하게^^!");
		la_bar2 = new JLabel("제품이 나왔습니다.감사합니다^^!");
		ta_info = new JTextArea();
		
		p_bill = new JPanel();
		p_bill.setLayout(new GridLayout(4, 1));
		
		
	}

	private void setting() {
		bt_exch.setBounds(305, 575, 80, 80);
		bt_admin.setBounds(5, 615, 40, 40);
		bt_out.setBounds(420, 450, 140, 30);
		
		p_la[0].setBounds(10, 30, 560, 110);
		p_la[0].add(laArr[0]);
		p_la[0].add(laArr[1]);
		p_la[0].add(laArr[2]);
		p_la[0].add(laArr[3]);
		
		p_la[1].setBounds(10, 160, 560, 110);
		p_la[1].add(laArr[4]);
		p_la[1].add(laArr[5]);
		p_la[1].add(laArr[6]);
		p_la[1].add(laArr[7]);

		p_bt[0].setBounds(10, 140, 560, 30);
		p_bt[1].add(bt_menu[0]);
		p_bt[2].add(bt_menu[1]);
		p_bt[3].add(bt_menu[2]);
		p_bt[4].add(bt_menu[3]);

		p_bt[0].setBounds(10, 270, 560, 30);
		p_bt[1].add(bt_menu[4]);
		p_bt[2].add(bt_menu[5]);
		p_bt[3].add(bt_menu[6]);
		p_bt[4].add(bt_menu[7]);
		
		p_bill.setBounds(180, 530, 80, 100);
		p_bill.add(bt_bill1);
		p_bill.add(bt_bill5);
		p_bill.add(bt_bill10);
		p_bill.add(bt_bill50);
	}

	public static void main(String[] args) {
		new User_View();
	}
}
