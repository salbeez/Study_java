package com.kosta.j0323;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class EchoClient {
   public static void main(String[] args) throws IOException {
	    
	   //Socket s = new Socket(String host, int port);
	   //host:����ip  port:���� ���� ��ȣ
	   
	   Socket s = new Socket("192.168.0.104", 8282);// 5000);//��3. �������� ��û
	   System.out.println("�������� ����!!");
	   
	   //��4. ����� ��ü ����
	   OutputStream out = s.getOutputStream();//��°�ü (�޽��� ������ ���)
	   InputStream is = s.getInputStream();//�Է°�ü (�޽��� ������ ���)
	   BufferedReader in = new BufferedReader(new InputStreamReader(is));
	   
	   String msg="�ȳ��ϼ���~!!\n";
	   
	   out.write(msg.getBytes());//��5. �޽��� ������
	   
	   System.out.println(in.readLine());//��8. �޽��� �б�
   }//main
}



