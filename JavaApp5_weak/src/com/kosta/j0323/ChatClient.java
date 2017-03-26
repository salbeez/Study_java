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
   //소켓 입출력
   BufferedReader in;
   OutputStream out;
   
   public ChatClient() {
	 setTitle("채팅방");
	 
	 bt = new JButton("변경");
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
   }//생성자
   
   public void sendNickName(){//대화명을 서버에게 전달하기
	   try {
			String nickName = JOptionPane.showInputDialog(this,"대화명:");
			out.write(  (nickName+"\n").getBytes() );
		}catch (IOException e) {
			e.printStackTrace();
		}
   }//sendNickName
   
   //서버연결메소드
   public void connectProcess(){//model   
	   
	try {		
		Socket s = new Socket("192.168.0.103", 8282);//서버 연결 시도	
		   //소켓 입출력객체 생성
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
		  sendMsg();  //텍스트필드에 엔터키값이 입력되었을때
	   }else if(obj == bt){
		   String newName = JOptionPane.showInputDialog(this,"변경할 대화명");
		   try {
			out.write(  ("@"+newName+"\n").getBytes());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	   }
	  
	  
   }//actionPerformed
   
   public void sendMsg(){//TF입력값 ----> 서버에게 메시지보내기
	   try {
			String msg = tf.getText();										//Control 부분
			if(msg==null  ||  msg.trim().length() == 0) return;
			   out.write( (msg+"\n").getBytes() );							//model 부분
			   tf.setText("");														//view 부분
		  } catch (IOException e1) {
			e1.printStackTrace();
		  }
   }
   
   
   @Override
   public void run() {//이유? 언제 보낼지 모르는 서버의 메시지를 대기하기 위해서
	try {
		while(true){
		    String msg = in.readLine(); //서버가 보낸 메시지를  얻어오기 ----> ta에 출력
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
