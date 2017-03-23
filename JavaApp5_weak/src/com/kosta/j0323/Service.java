package com.kosta.j0323;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Vector;

public class Service extends Thread{
   //소켓관련 입출력서비스
   BufferedReader in;
   OutputStream out;
   
   Vector<Service> v;
   Socket s;
   
   String nickName;
   
   public Service(Socket s, Vector<Service> v) { 
	   this.v = v; // v:Server에서 한번 생성된 벡터 
	   this.s = s;
	   
	   try {		
		in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		out = s.getOutputStream();
		
		start();
	  } catch (IOException e) {
		e.printStackTrace();
	 }
   }//생성자
   
   @Override
   public void run() {
	 try {
		nickName = in.readLine();
		while(true){
		    String msg = in.readLine();//클라이언트가 메시지를 보낼 때 마다 실행
		    
		   if(msg == null) return; //비정상적인 종료
		   
		   if(msg.trim().length() > 0){
		   
		    System.out.println("from Client: "+ msg +":"+
		                  s.getInetAddress().getHostAddress());
		    //out.write(  ("from Server >> "+msg+"\n").getBytes() );
		    //클라이언트에게 메시지 보내기
		    
		    //접속된 전체클라이언트에게 메시지 보내기
		    messageAll("["+nickName +"]▶ "+msg);
		   }
		}
	 }catch (IOException e) {
		 System.out.println("★");
		e.printStackTrace();
	}
   }//run
   
   
   public void messageAll(String msg){
	   //벡터에 저장된 모든 클라이언트(Service)에게 메시지 전달
	   for(int i=0; i<v.size(); i++){//벡터 인덱스
		  Service service = v.get(i); //각각의 클라이언트 얻어오기
		  try {
			service.messageTo(msg);
		} catch (IOException e) {
			//에러발생 ---> 클라이언트 접속 끊음!!
			v.remove(i--); //접속 끊긴 클라이언트를 벡터에서 삭제!!
		    System.out.println("클라이언트 접속 끊음!!");
		}
	   }
   }//messageAll
   
   public void messageTo(String msg) throws IOException{
	   //특정 클라이언트에게 메시지 전달 (실제 서버--->클라이언트 메시지 전달)
	   out.write(  (msg+"\n").getBytes()   );
   }
	
}



