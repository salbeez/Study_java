package com.kosta.j0323;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements ActionListener,Runnable{
   JTextArea ta;
   JScrollPane scroll_ta;
   
   JTextField tf;
   JButton bt;
   JPanel p;
   //���� �����
   BufferedReader in;
   OutputStream out;
   
   public ChatClient() {
	 setTitle("ä�ù�");
	 
	 bt = new JButton("����");
	 ta = new JTextArea();
	 scroll_ta = new JScrollPane(ta);
	 
	 tf = new JTextField(15);
	 
	 p =new JPanel();
	 p.add(tf);
	 p.add(bt);
	 
	 add("Center", scroll_ta);
	 add("South", p);
	 
	 setBounds(300,200, 300, 500);
	 setVisible(true);
	 setDefaultCloseOperation(EXIT_ON_CLOSE);
	 
	 connectProcess();
	 sendNickName();
     new Thread(this).start();
	 
	 tf.addActionListener(this);	 
	 bt.addActionListener(this);
   }//������
   
   public void sendNickName(){//��ȭ���� �������� �����ϱ�
	   try {
			String nickName = JOptionPane.showInputDialog(this,"��ȭ��:");
			out.write(  (nickName+"\n").getBytes() );
		}catch (IOException e) {
			e.printStackTrace();
		}
   }//sendNickName
   
   //��������޼ҵ�
   public void connectProcess(){//model   
	   
	try {		
		Socket s = new Socket("192.168.0.103", 8282);//���� ���� �õ�	
		   //���� ����°�ü ����
		in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		out = s.getOutputStream();		   
	  } catch (UnknownHostException e) {
		e.printStackTrace();
	  } catch (IOException e) {
		e.printStackTrace();
	 }
	   
   }//connectProcess
   
   
   @Override
   public void actionPerformed(ActionEvent e) {
	   Object obj = e.getSource();
	   if(obj ==tf){
		  sendMsg();  //�ؽ�Ʈ�ʵ忡 ����Ű���� �ԷµǾ�����
	   }else if(obj == bt){
		   String newName = JOptionPane.showInputDialog(this,"������ ��ȭ��");
		   try {
			out.write(  ("@"+newName+"\n").getBytes());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	   }
	  
	  
   }//actionPerformed
   
   public void sendMsg(){//TF�Է°� ----> �������� �޽���������
	   try {
			String msg = tf.getText();										//Control �κ�
			if(msg==null  ||  msg.trim().length() == 0) return;
			   out.write( (msg+"\n").getBytes() );							//model �κ�
			   tf.setText("");														//view �κ�
		  } catch (IOException e1) {
			e1.printStackTrace();
		  }
   }
   
   
   @Override
   public void run() {//����? ���� ������ �𸣴� ������ �޽����� ����ϱ� ���ؼ�
	try {
		while(true){
		    String msg = in.readLine(); //������ ���� �޽�����  ������ ----> ta�� ���
		    ta.append(msg+"\n");
		    ta.setCaretPosition(ta.getText().length());
		  }
	  } catch (IOException e) {
		e.printStackTrace();
	  }
   }//run
   
   public static void main(String[] args) {
	   new ChatClient();
   }


}
