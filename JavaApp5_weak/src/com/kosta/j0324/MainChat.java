package com.kosta.j0324;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

public class MainChat extends JFrame implements ActionListener, Runnable{
   JList<String> roomInfo,roomInwon,waitInfo;
   JScrollPane sp_roomInfo, sp_roomInwon, sp_waitInfo;
   JButton bt_create, bt_enter, bt_exit;
   
   JPanel p;
   ChatClient cc;
   
   //���� ����°�ü
   BufferedReader in;
   OutputStream out;
   
   String selectedRoom;
   
   public MainChat() {	 
	 setTitle("����");
	 
	 cc = new ChatClient();
	 roomInfo = new JList<String>();
	   roomInfo.setBorder(new TitledBorder("������"));
	   
	 roomInfo.addMouseListener(new MouseAdapter() {
	     @Override
	    public void mouseClicked(MouseEvent e) {
	    	 String str = roomInfo.getSelectedValue(); //"�ڹٹ�--1"
			 System.out.println("STR="+str);
			 selectedRoom = str.substring(0, str.indexOf("-"));
			         //"�ڹٹ�"  <----  substring(0,3)
	    }	 
	 });
	   
	   
	 roomInwon = new JList<String>();
	   roomInwon.setBorder(new TitledBorder("�ο�����"));
	 waitInfo = new JList<String>();
       waitInfo.setBorder(new TitledBorder("��������"));
       
     sp_roomInfo = new JScrollPane(roomInfo);
     sp_roomInwon = new JScrollPane(roomInwon);
     sp_waitInfo = new JScrollPane(waitInfo);
     
     bt_create = new JButton("�游���");
     bt_enter = new JButton("�����");
     bt_exit = new JButton("������");     
     
     p = new JPanel();
     
     sp_roomInfo.setBounds(10, 10, 300, 300);
     sp_roomInwon.setBounds(320, 10, 150, 300);
     sp_waitInfo.setBounds(10, 320, 300, 130);
     
     bt_create.setBounds(320,330,150,30);
     bt_enter.setBounds(320,370,150,30);
     bt_exit.setBounds(320,410,150,30);
     
     p.setLayout(null);
      p.setBackground(Color.orange);
     p.add(sp_roomInfo);
     p.add(sp_roomInwon);
     p.add(sp_waitInfo);
     p.add(bt_create);
     p.add(bt_enter);
     p.add(bt_exit);
     
     add(p);
     setBounds(300,200, 500, 500);
     setVisible(true);
     setDefaultCloseOperation(EXIT_ON_CLOSE); 
     
     connect();//��������õ� (in,out��ü����)
     new Thread(this).start();//�����޽��� ���
     
     String nickName = JOptionPane.showInputDialog(this,"��ȭ��:");
     sendMsg("150|"+nickName);
     
     eventUp();
   }//������
   
   private void eventUp(){//�̺�Ʈ�ҽ�-�̺�Ʈó���� ����
	 //����(MainChat)
	   bt_create.addActionListener(this);
	   bt_enter.addActionListener(this);
	   bt_exit.addActionListener(this);
	   
	 //��ȭ��(ChatClient)
	   cc.sendTF.addActionListener(this);
	   cc.bt_change.addActionListener(this);
	   cc.bt_exit.addActionListener(this);
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
	  Object ob = e.getSource();
	  if(ob==bt_create){//�游��� ��û
		 String title = JOptionPane.showInputDialog(this,"������:");
		 //�������� �������� ����
		 sendMsg("160|"+title);
		 
		 cc.setTitle("ä�ù�-["+title+"]");
		 
		 setVisible(false);
		 cc.setVisible(true); //��ȭ���̵�
		 
		 
	  }else if(ob==bt_enter){//����� ��û
		 
		 if(selectedRoom == null){
			JOptionPane.showMessageDialog(this, "���� ����!!");
			return;
		 }
		  
		 sendMsg("200|"+ selectedRoom);
		  
		 setVisible(false);
		 cc.setVisible(true);
	  }else if(ob==cc.bt_exit){//��ȭ�� ������ ��û
		 //�ش� ���� �ο��� ����
		 sendMsg("250|");
		 cc.setVisible(false);
		 setVisible(true); 
	  }else if(ob==cc.sendTF){//(TextField�Է�)�޽��� ������ ��û
		 String msg = cc.sendTF.getText();
		 sendMsg("300|"+msg); 
		 cc.sendTF.setText("");
	  }	  
	  
	  else if(ob==bt_exit){//������(���α׷�����) ��û
		  System.exit(0);//���� �������α׷� �����ϱ�
	  }	  
	  
   }//actionPerformed 
   
   public void connect(){//(����)�������� ��û
	try {
		//Socket s = new Socket(String host<����ip>, int port<���񽺹�ȣ>); 
		  Socket s = new Socket("192.168.0.103", 8282);//����õ�		  
		  in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		  //in: �����޽��� �бⰴü    ����-----msg------>Ŭ���̾�Ʈ
		  out = s.getOutputStream();
		  //out: �޽��� ������, ���ⰴü    Ŭ���̾�Ʈ-----msg----->����
	  } catch (UnknownHostException e) {
		e.printStackTrace();
	  } catch (IOException e) {
		e.printStackTrace();
	  }  
   }//connect
   
   public void sendMsg(String msg){//�������� �޽��� ������
	 try {
		out.write(  (msg+"\n").getBytes()  );
	 }catch (IOException e) {
		e.printStackTrace();
	}
   }//sendMsg
   
   public void run(){//������ ���� �޽��� �б�
	   //�� run�޼ҵ� ���? GUI���α׷����࿡ ���� ��ġ���ʴ� �ڵ� �ۼ�.
//�޼ҵ�ȣ���� �������� ����!!  ������޼ҵ�� ���ý���(��ٸ��� �ʴ� ���� ����)!!
	 try {
		while(true){
			   String msg = in.readLine();//msg: ������ ���� �޽���
			   //msg==> "300|�ȳ��ϼ���"  "160|�ڹٹ�--1,����Ŭ��--1,JDBC��--1"
			   String msgs[] = msg.split("\\|");
			   String protocol = msgs[0];
			   switch(protocol){
			     case "300": 
			    	   cc.ta.append(msgs[1]+"\n");
					   cc.ta.setCaretPosition(cc.ta.getText().length());
			    	       break;
			     case "160"://�游��� 
			    	       //�������� List�� �Ѹ���
			    	 String roomNames[] = msgs[1].split(",");
			    	                   //"�ڹٹ�--1,����Ŭ��--1,JDBC��--1"
			    	     roomInfo.setListData(roomNames);
			    	   break;
			   }//Ŭ���̾�Ʈ switch
			   
		   }
	  }catch (IOException e) {
		e.printStackTrace();
	 }
   }//run
   
   
   public static void main(String[] args) {
	  new MainChat();
   }





}



