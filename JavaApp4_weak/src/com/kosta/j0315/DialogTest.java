package com.kosta.j0315;

import java.awt.FlowLayout;

import javax.swing.*;

public class DialogTest {
	public static void main(String[] args) {
		JFrame f = new JFrame("다이얼 로그 TEST");
		f.setBounds(300,200,300,300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton bt = new JButton("1번 버튼");
		JButton bt2 = new JButton("2번 버튼");
		JButton bt3 = new JButton("3번 버튼");
		
		f.setLayout(new FlowLayout());
		f.add(bt);
		f.add(bt2);
		f.add(bt3);
		f.setSize(300, 300);
		f.setVisible(true);
		//메시지 창
		JOptionPane.showMessageDialog(bt, "11");// bt위에서 발생
		JOptionPane.showMessageDialog(f, "22");
		//입력 창
		String movieName= JOptionPane.showInputDialog(f, "좋아하는 영화?");
		JOptionPane.showMessageDialog(f, movieName);
		//확인 창
		int t=JOptionPane.showConfirmDialog(f, "삭제");
		System.out.println(t);
//		예,아니오,취소,x버튼 --->0,1,2,-1
		
		if(t==0){
			JOptionPane.showMessageDialog(f, "삭제 처리 되었습니다");
		}else{
			JOptionPane.showMessageDialog(f, "취소 되었습니다");			
		}
	}
}
