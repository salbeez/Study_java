package com.kosta.j0323;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server implements Runnable{
    //ServerŬ����: ������ ���� ���Ӽ���, ����Ŭ���̾�Ʈ ����
	
	Vector<Service> v;//����Ŭ���̾�Ʈ(= Service) ���� ����  ----> ����!!

	public Server() {
		v = new Vector<>();
	   //Thread t = new Thread(run�޼ҵ��� ��ġ);  t.start();
		new Thread(this).start();
	}//������
	
	
	@Override
	public void run(){
	   try {
		ServerSocket ss = new ServerSocket(8282);
		     //���� �������� ip + ��õ� port ----> ���ϼ���   
			
		   System.out.println("Start Server.......");
		   while(true){
			   Socket s = ss.accept();//Ŭ���̾�Ʈ ���� ���	
			   //s: ������ Ŭ���̾�Ʈ�� ��������
			   Service ser = new Service(s,v);
			   v.add(ser);
		   }
		   
	   } catch (IOException e) {
		e.printStackTrace();
	  }	   
	}//run	
	
   public static void main(String[] args) {
	   new Server();
   }


}
