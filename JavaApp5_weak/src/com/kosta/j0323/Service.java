package com.kosta.j0323;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Vector;

public class Service extends Thread{
   //���ϰ��� ����¼���
   BufferedReader in;
   OutputStream out;
   
   Vector<Service> v;
   Socket s;
   
   String nickName;
   
   public Service(Socket s, Vector<Service> v) { 
	   this.v = v; // v:Server���� �ѹ� ������ ���� 
	   this.s = s;
	   
	   try {		
		in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		out = s.getOutputStream();
		
		start();
	  } catch (IOException e) {
		e.printStackTrace();
	 }
   }//������
   
   @Override
   public void run() {
	 try {
		nickName = in.readLine();
		while(true){
		    String msg = in.readLine();//Ŭ���̾�Ʈ�� �޽����� ���� �� ���� ����
		    
		   if(msg == null) return; //���������� ����
		   
		   if(msg.trim().length() > 0){
		   
		    System.out.println("from Client: "+ msg +":"+
		                  s.getInetAddress().getHostAddress());
		    //out.write(  ("from Server >> "+msg+"\n").getBytes() );
		    //Ŭ���̾�Ʈ���� �޽��� ������
		    
		    //���ӵ� ��üŬ���̾�Ʈ���� �޽��� ������
		    messageAll("["+nickName +"]�� "+msg);
		   }
		}
	 }catch (IOException e) {
		 System.out.println("��");
		e.printStackTrace();
	}
   }//run
   
   
   public void messageAll(String msg){
	   //���Ϳ� ����� ��� Ŭ���̾�Ʈ(Service)���� �޽��� ����
	   for(int i=0; i<v.size(); i++){//���� �ε���
		  Service service = v.get(i); //������ Ŭ���̾�Ʈ ������
		  try {
			service.messageTo(msg);
		} catch (IOException e) {
			//�����߻� ---> Ŭ���̾�Ʈ ���� ����!!
			v.remove(i--); //���� ���� Ŭ���̾�Ʈ�� ���Ϳ��� ����!!
		    System.out.println("Ŭ���̾�Ʈ ���� ����!!");
		}
	   }
   }//messageAll
   
   public void messageTo(String msg) throws IOException{
	   //Ư�� Ŭ���̾�Ʈ���� �޽��� ���� (���� ����--->Ŭ���̾�Ʈ �޽��� ����)
	   out.write(  (msg+"\n").getBytes()   );
   }
	
}



