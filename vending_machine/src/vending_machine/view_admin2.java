package vending_machine;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


	

public class view_admin2 extends JFrame{
	
	 JButton bt_month, bt_week, bt_day, bt_vet1, bt_vet2, bt_vet3, bt_vet4, bt_vet5, 
	 			bt_vet6, bt_vet7, bt_vet8, bt_re;
	 JLabel la_one, la_five, la_ten, la_fifty, la_sum;
	 JTextField tf_one, tf_five, tf_ten, tf_fifty, tf_sum;
	 
	JPanel panel_chart, panel_vet, panel_don, panel_admin;
	
	public view_admin2() {
		setTitle("�����ڸ��");
		
		panel_chart = new JPanel();
		
		bt_month = new JButton("��");
		bt_week = new JButton("�ְ�");
		bt_day  = new JButton("�ϰ�");
		bt_vet1 = new JButton("��ä1");
		bt_vet2 = new JButton("��ä2");
		bt_vet3 = new JButton("��ä3");
		bt_vet4 = new JButton("��ä4");
		bt_vet5 = new JButton("��ä5");
		bt_vet6 = new JButton("��ä6");
		bt_vet7 = new JButton("��ä7");
		bt_vet8 = new JButton("��ä8");
		bt_re = new JButton("���ư���");
		
		la_one= new  JLabel("1,000��");
		la_five = new  JLabel("5,000��");
		la_ten = new  JLabel("10,000��");
		la_fifty = new  JLabel("50,000��");
		la_sum = new  JLabel("�Ѿ׼�");
		
		tf_one = new  JTextField();
		tf_five = new  JTextField();
		tf_ten = new  JTextField();
		tf_fifty = new  JTextField();
		tf_sum = new  JTextField();
		
		panel_vet = new JPanel();
		panel_vet.setLayout(new GridLayout(2,4,10,50));
		panel_vet.add(bt_vet1);
		panel_vet.add(bt_vet2);
		panel_vet.add(bt_vet3);
		panel_vet.add(bt_vet4);
		panel_vet.add(bt_vet5);
		panel_vet.add(bt_vet6);
		panel_vet.add(bt_vet7);
		panel_vet.add(bt_vet8);
		
		panel_don = new JPanel();
		panel_don.setLayout(new GridLayout(4, 2));
		panel_don.add(la_one);
		panel_don.add(tf_one);	
		panel_don.add(la_five);
		panel_don.add(tf_five);	
		panel_don.add(la_ten);
		panel_don.add(tf_ten);	
		panel_don.add(la_fifty);
		panel_don.add(tf_fifty);	
		panel_don.add(la_sum);
		panel_don.add(tf_sum);	
		
		panel_admin = new JPanel();
		panel_admin.setLayout(new BorderLayout());
		panel_admin.add("North", la_sum);
		panel_admin.add("East",bt_re);
		
		
		
		setLayout(null);
	
		
		panel_chart.setBounds(0, 0, 300, 300);
		panel_vet.setBounds(15, 300, 300,150);
		panel_don.setBounds(300, 0, 200, 300);
		panel_admin.setBounds(280, 300, 200, 150);
		
		panel_chart.add(new JLabel());
		add(panel_chart);
		add(panel_vet);
		add(panel_don);
		
		add(panel_admin);
		setBounds(500,500,500,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	
	}
	
	
	public static void main(String[] args) {
		new view_admin2();

	}

}
