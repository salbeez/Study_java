package com.kosta.j0323;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	
	public static void main(String[] args) throws IOException{
	  //ServerSocket ss = new ServerSocket(int port);
	  //ServerSocket: ���ϼ��񽺸� �ϴ� ������ü
	  ServerSocket ss = new ServerSocket(5000);//��1. �������ϰ�ü ����
	  //���� JVM�� ���� ip�ּҿ� ��õ� port��ȣ�� ���ϼ��񽺸� ������ �غ�
	  
	  System.out.println("���� ����(���Ӵ����).....");
	  while(true){
	   Socket s = ss.accept();//��2. Ŭ���̾�Ʈ ���� ��� �޼ҵ�
	    InetAddress ia = s.getInetAddress();
	    System.out.println("Ŭ���̾�Ʈ ����!! ["+ ia.getHostAddress() +"]"); 
	    
	  //��4. ����� ��ü ����
	    OutputStream out = s.getOutputStream();//��°�ü (�޽��� ������ ���)
		InputStream is = s.getInputStream();//�Է°�ü (�޽��� ������ ���)
		BufferedReader in = new BufferedReader(new InputStreamReader(is));
		  //�����б�
		
		//��6. �޽��� �б�
		System.out.println("from Client: "+ in.readLine());
		
		//��7. �޽��� ������
		String msg="���� ���� ���� ����̴ϴ�^^*\n";
		out.write( ("["+ia.getHostAddress()+"] "+msg).getBytes() );
	  }
	}//main

}
