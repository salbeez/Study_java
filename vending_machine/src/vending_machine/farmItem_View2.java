package vending_machine;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class farmItem_View2 extends JFrame{
	
	JButton bt1, bt2, bt3,bt4,bt5,bt6,bt7, bt8,	bt9, bt10, bt11,bt12, bt13,bt14,bt15,bt16;
			
	
	public farmItem_View2() {
		
		ImageIcon icon1 = new ImageIcon("image/����.jpg");
		ImageIcon icon2 = new ImageIcon("image/����.jpg");
		ImageIcon icon3 = new ImageIcon("image/����.jpg");
		ImageIcon icon4 = new ImageIcon("image/��ȣ��.jpg");
		ImageIcon icon5 = new ImageIcon("image/���.jpg");
		ImageIcon icon6 = new ImageIcon("image/����.jpg");
		ImageIcon icon7 = new ImageIcon("image/��.jpg");
		ImageIcon icon8 = new ImageIcon("image/����.jpg");
		ImageIcon icon9 = new ImageIcon("image/����ݸ�.jpg");
		ImageIcon icon10 = new ImageIcon("image/�ñ�ġ.jpg");
		ImageIcon icon11 = new ImageIcon("image/��ȣ��.jpg");
		ImageIcon icon12 = new ImageIcon("image/�����.jpg");
		ImageIcon icon13 = new ImageIcon("image/����.jpg");
		ImageIcon icon14= new ImageIcon("image/����.jpg");
		ImageIcon icon15= new ImageIcon("image/����.jpg");
		ImageIcon icon16 = new ImageIcon("image/������ī.jpg");
		
		bt1 = new JButton("", icon1);
		bt2 = new JButton("", icon2);
		bt3 = new JButton("", icon3);
		bt4 = new JButton("", icon4);
		bt5 = new JButton("", icon5);
		bt6 = new JButton("", icon6);
		bt7 = new JButton("", icon7);
		bt8= new JButton("", icon8);
		bt9 = new JButton("", icon9);
		bt10 = new JButton("", icon10);
		bt11 = new JButton("", icon11);
		bt12 = new JButton("", icon12);
		bt13 = new JButton("", icon13);
		bt14 = new JButton("", icon14);
		bt15 = new JButton("", icon15);
		bt16 = new JButton("", icon16);
		
		
		
		setLayout(new GridLayout(4, 4));
		add(bt1);
		add(bt2);
		add(bt3);
		add(bt4);
		add(bt5);
		add(bt6);
		add(bt7);
		add(bt8);
		add(bt9);
		add(bt9);
		add(bt10);
		add(bt11);
		add(bt12);
		add(bt13);
		add(bt14);
		add(bt15);
		add(bt16);
			
		
		setTitle("��ư�̹���");
		setBounds(300,200,300,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
	
	public static void main(String[] args) {
		new farmItem_View2();
		
		
		
	}
	
	
	
	
	
}