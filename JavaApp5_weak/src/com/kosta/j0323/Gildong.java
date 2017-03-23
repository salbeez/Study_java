package com.kosta.j0323;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Gildong extends JFrame implements ActionListener{
   JButton bt_reference, bt_add, bt_su, bt_lime;
   JTextArea ta;
   JScrollPane scroll_ta;
   
   JPanel southp;
   A a;	
   
   
   public Gildong() {
	 setTitle("�浿��ü");
	
	 a = A.getInstance();
	 bt_reference = new JButton("���۷���");
	 bt_add = new JButton("su���ϱ�");
	 bt_su = new JButton("su���");
	 bt_lime = new JButton("���Ӱ�ü");
	 
	 ta = new JTextArea();
	 scroll_ta = new JScrollPane(ta);
	 
	 southp = new JPanel();
	   southp.add(bt_reference);
	   southp.add(bt_add);
	   southp.add(bt_su);
	   southp.add(bt_lime);
	  
	 add("Center",ta);
	 add("South",southp);
	 
	 setSize(400, 300);
	 setVisible(true);
	 setDefaultCloseOperation(EXIT_ON_CLOSE);
	 
	 bt_reference.addActionListener(this);
	 bt_add.addActionListener(this);
	 bt_su.addActionListener(this);
	 bt_lime.addActionListener(this);
   }//������
   
   
   @Override
   public void actionPerformed(ActionEvent e) {
	  Object ob = e.getSource();
	   //actionPerformed�� ȣ���� �̺�Ʈ �ҽ��� ���۷��� ��� 
	  String str;
	  if(ob==bt_reference){
		  str="���۷���: "+a;
	  }else if(ob==bt_add){
		  a.su++;
		  str="su�� ���� 1����";
	  }else {//if(ob==bt_su){
		  str="su="+a.su;
	  }
	  
	  
	  if(ob==bt_lime){
		  new Lime();
	  }else{	  
	    ta.append(str+"\n");
	  }
   }//actionPerformed
   
   public static void main(String[] args) {
	  new Gildong();
   }


}
