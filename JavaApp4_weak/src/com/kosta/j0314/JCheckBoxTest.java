package com.kosta.j0314;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class JCheckBoxTest extends JFrame{
	
	JCheckBox cb,cb2,cb3;
	JPanel p;
	public JCheckBoxTest() {
		
		setTitle("체크박스 테스트");
		new JCheckBox();
		//FM 정석은 image1이다
		ImageIcon image1 =new ImageIcon("C:\\Users\\ksota\\git\\Study_java\\JavaApp4_weak\\image\\LEFT.GIF");
		ImageIcon image2 =new ImageIcon("C:/Users/ksota/git/Study_java/JavaApp4_weak/image/leftRollover.gif");
		ImageIcon image3 =new ImageIcon("image/leftDown.gif");
		ImageIcon image4 =new ImageIcon("image/RIGHT.gif");
		ImageIcon image5 =new ImageIcon("image/rightDown.gif");
		ImageIcon image6 =new ImageIcon("image/rightRollover.gif");
		
		cb= new JCheckBox("1번",image1);
		cb.setRolloverIcon(image2);
		cb.setSelectedIcon(image3);
		cb2= new JCheckBox("2번",image4);
		cb2.setRolloverIcon(image5);
		cb2.setSelectedIcon(image6);
		cb2.setToolTipText("두번째 영역에 진입 했다");
		cb3= new JCheckBox("3번");
		p=new JPanel();
		
//		p.setBorder(new TitledBorder("패널 타이틀"));
		p.setBorder(new BevelBorder(BevelBorder.LOWERED));
		p.setLayout(new GridLayout(3, 1));
		p.add(cb);
		p.add(cb2);
		p.add(cb3);
		add(p);//default frame is BorderLayout
		
		setBounds(300,200,300,300);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		==
	}

	public static void main(String[] args) {
		new JCheckBoxTest();
	}
}
