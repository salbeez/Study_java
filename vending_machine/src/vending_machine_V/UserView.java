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

public class UserView extends JFrame {

	public JButton bt_menu[];
	public JButton bt_bill1, bt_bill5, bt_bill10, bt_bill50, bt_exch, bt_admin, bt_out;
	public JTextField tf_balance;
	public JTextArea ta_info;

	public JPanel p_all, p_la1, p_la2, p_bt1, p_bt2, p_bill, p_exch;

	public JLabel la_product, la_inform, la_bill, la_bar1, la_bar2, la_out;
	public JLabel la[];

	public ImageIcon icon[];
	public ImageIcon icon_null, icon_exch, icon_admin, icon_out;

	public UserView() {
		setTitle("Farmer's Vending Machine");
		bt_menu = new JButton[8];
		for (int i = 0; i < 8; i++) {
			bt_menu[i] = new JButton();
			bt_menu[i].setBackground(Color.red);
		}

		bt_bill1 = new JButton("1,000");
		bt_bill5 = new JButton("5,000");
		bt_bill10 = new JButton("10,000");
		bt_bill50 = new JButton("50,000");

		bt_exch = new JButton("�ܵ�");
		bt_exch.setBounds(305, 575, 80, 80);

		bt_admin = new JButton("#");
		bt_admin.setBounds(5, 615, 50, 40);

		bt_out = new JButton("��ǰ�����°�");
		bt_out.setBounds(420, 450, 140, 30);

		icon = new ImageIcon[16];
		icon[0] = new ImageIcon("image/����.jpg");
		icon[1] = new ImageIcon("image/����.jpg");
		icon[2] = new ImageIcon("image/����.jpg");
		icon[3] = new ImageIcon("image/��ȣ��.jpg");
		icon[4] = new ImageIcon("image/���.jpg");
		icon[5] = new ImageIcon("image/����.jpg");
		icon[6] = new ImageIcon("image/��.jpg");
		icon[7] = new ImageIcon("image/����.jpg");
		icon[8] = new ImageIcon("image/����ݸ�.jpg");
		icon[9] = new ImageIcon("image/�ñ�ġ.jpg");
		icon[10] = new ImageIcon("image/��ȣ��.jpg");
		icon[11] = new ImageIcon("image/�����.jpg");
		icon[12] = new ImageIcon("image/����.jpg");
		icon[13] = new ImageIcon("image/����.jpg");
		icon[14] = new ImageIcon("image/����.jpg");
		icon[15] = new ImageIcon("image/������ī.jpg");
		icon_null = new ImageIcon("image/m.jpg");

		la = new JLabel[8];
		for (int i = 0; i < 8; i++) {
			la[i] = new JLabel(icon_null);
		}

		la_out = new JLabel(icon_null);
		la_out.setBounds(420, 325, 140, 110);

		la_bar1 = new JLabel("�ż��� ����,ä�Ҹ� �����ϰ�^^!");
		// la_bar1.setBounds(180,310,400,15);
		la_bar2 = new JLabel("��ǰ�� ���Խ��ϴ�.�����մϴ�^^!");
		la_bar2.setBounds(180, 505, 400, 15);

		tf_balance = new JTextField();
		tf_balance.setBounds(280, 530, 130, 40);

		ta_info = new JTextArea();
		ta_info.setBounds(60, 325, 340, 170);
		ta_info.setText("\n\t<��깰���Ǳ�>");
		ta_info.append("\n ���� ���Ӱ� �԰�Ǵ� �ż��� ��깰");
		ta_info.append("\n ���Ͻô� ��ǰ�� ������ ��ǰ�� ���� ������ ���ɴϴ�.");
		ta_info.append("\n ���� ���Խ� ��ǰ���ù�ư���� ����˴ϴ�.");
		ta_info.append("\n ����ó : 02-1234-5678");

		p_bill = new JPanel();
		p_bill.setLayout(new GridLayout(4, 1));
		p_bill.add(bt_bill1);
		p_bill.add(bt_bill5);
		p_bill.add(bt_bill10);
		p_bill.add(bt_bill50);
		p_bill.setBounds(180, 530, 80, 100);

		p_la1 = new JPanel();
		p_la1.setLayout(new GridLayout(1, 4));
		p_la1.setBounds(10, 30, 560, 110);
		for (int i = 0; i < 4; i++) {
			p_la1.add(la[i]);
		}

		p_la2 = new JPanel();
		p_la2.setLayout(new GridLayout(1, 4));
		p_la2.setBounds(10, 160, 560, 110);
		for (int i = 4; i < 8; i++) {
			p_la2.add(la[i]);
		}

		p_bt1 = new JPanel();
		p_bt1.setLayout(new GridLayout(1, 4));
		p_bt1.setBounds(10, 140, 560, 30);
		for (int i = 0; i < 4; i++) {
			p_bt1.add(bt_menu[i]);
		}

		p_bt2 = new JPanel();
		p_bt2.setLayout(new GridLayout(1, 4));
		p_bt2.setBounds(10, 270, 560, 30);
		for (int i = 4; i < 8; i++) {
			p_bt2.add(bt_menu[i]);
		}

		p_all = new JPanel();
		p_all.setLayout(null);
		p_all.setBackground(Color.orange);
		p_all.add(p_la1);
		p_all.add(p_bt1);
		p_all.add(p_la2);
		p_all.add(p_bt2);
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
		setBounds(500, 50, 600, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
}
