package com.kosta.j0323;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Lime extends JFrame implements ActionListener{
   JButton bt_reference, bt_add, bt_su;
   JTextArea ta;
   JScrollPane scroll_ta;
   
   JPanel southp;
   A a;	
   
   
   public Lime() {
	 setTitle("라임객체");
	
	 a = A.getInstance();
	 bt_reference = new JButton("레퍼런스");
	 bt_add = new JButton("su더하기");
	 bt_su = new JButton("su출력");
	 
	 ta = new JTextArea();
	 scroll_ta = new JScrollPane(ta);
	 
	 southp = new JPanel();
	   southp.add(bt_reference);
	   southp.add(bt_add);
	   southp.add(bt_su);
	  
	 add("Center",ta);
	 add("South",southp);
	 
	 setSize(300, 300);
	 setVisible(true);
	 setDefaultCloseOperation(EXIT_ON_CLOSE);
	 
	 bt_reference.addActionListener(this);
	 bt_add.addActionListener(this);
	 bt_su.addActionListener(this);
   }//생성자
   
   
   @Override
   public void actionPerformed(ActionEvent e) {
	  Object ob = e.getSource();
	   //actionPerformed를 호출한 이벤트 소스의 레퍼런스 얻기 
	  String str;
	  if(ob==bt_reference){
		  str="레퍼런스: "+a;
	  }else if(ob==bt_add){
		  a.su++;
		  str="su의 값을 1증가";
	  }else {//if(ob==su){
		  str="su="+a.su;
	  }
	  
	  ta.append(str+"\n");
   }//actionPerformed
   
   public static void main(String[] args) {
	  new Lime();
   }


}
