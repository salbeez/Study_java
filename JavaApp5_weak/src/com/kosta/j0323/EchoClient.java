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
	   //host:서버ip  port:서비스 구분 번호
	   
	   Socket s = new Socket("192.168.0.104", 8282);// 5000);//★3. 서버접속 요청
	   System.out.println("서버접속 성공!!");
	   
	   //★4. 입출력 객체 생성
	   OutputStream out = s.getOutputStream();//출력객체 (메시지 보낼때 사용)
	   InputStream is = s.getInputStream();//입력객체 (메시지 받을때 사용)
	   BufferedReader in = new BufferedReader(new InputStreamReader(is));
	   
	   String msg="안녕하세요~!!\n";
	   
	   out.write(msg.getBytes());//★5. 메시지 보내기
	   
	   System.out.println(in.readLine());//★8. 메시지 읽기
   }//main
}



