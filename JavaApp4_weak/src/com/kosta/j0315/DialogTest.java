package com.kosta.j0315;

import java.awt.FlowLayout;

import javax.swing.*;

public class DialogTest {
	public static void main(String[] args) {
		JFrame f = new JFrame("���̾� �α� TEST");
		f.setBounds(300,200,300,300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton bt = new JButton("1�� ��ư");
		JButton bt2 = new JButton("2�� ��ư");
		JButton bt3 = new JButton("3�� ��ư");
		
		f.setLayout(new FlowLayout());
		f.add(bt);
		f.add(bt2);
		f.add(bt3);
		f.setSize(300, 300);
		f.setVisible(true);
		//�޽��� â
		JOptionPane.showMessageDialog(bt, "11");// bt������ �߻�
		JOptionPane.showMessageDialog(f, "22");
		//�Է� â
		String movieName= JOptionPane.showInputDialog(f, "�����ϴ� ��ȭ?");
		JOptionPane.showMessageDialog(f, movieName);
		//Ȯ�� â
		int t=JOptionPane.showConfirmDialog(f, "����");
		System.out.println(t);
//		��,�ƴϿ�,���,x��ư --->0,1,2,-1
		
		if(t==0){
			JOptionPane.showMessageDialog(f, "���� ó�� �Ǿ����ϴ�");
		}else{
			JOptionPane.showMessageDialog(f, "��� �Ǿ����ϴ�");			
		}
	}
}
