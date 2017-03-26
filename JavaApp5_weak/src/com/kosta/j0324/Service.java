package com.kosta.j0324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Vector;

public class Service extends Thread{
   //Service == 접속 클라이언트 한명!!	
	
   Room myRoom;//클라이언트가 입장한 대화방	
	
   //소켓관련 입출력서비스
   BufferedReader in;
   OutputStream out;
   
   Vector<Service> allV;//모든 사용자(대기실사용자 + 대화방사용자)
   Vector<Service> waitV;//대기실 사용자	   
   Vector<Room> roomV;//개설된 대화방 Room-vs(Vector) : 대화방사용자
   
   Socket s;
   
   String nickName;
   
   public Service(Socket s, Server server) { 
	   allV=server.allV;
	   waitV=server.waitV;
	   roomV=server.roomV;
	   
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
		
		while(true){
		    String msg = in.readLine();//클라이언트의 모든 메시지를 받기
		    
		   if(msg == null) return; //비정상적인 종료
		   
		   if(msg.trim().length() > 0){  
		     System.out.println("from Client: "+ msg +":"+
		                  s.getInetAddress().getHostAddress());
		     //서버에서 상황을 모니터!!
		     
            String msgs[]=msg.split("\\|");
            String protocol = msgs[0];
            
		    switch(protocol){
		      case "150": //대화명
		    	          nickName=msgs[1]; 
		                  break;
		      case "160": //방만들기
		    	  myRoom = new Room();
		    	    myRoom.title =msgs[1];//방제목
		    	    myRoom.count = 1;
		    	    myRoom.boss = nickName;
		    	          
		    	          roomV.add(myRoom);
		    	          
		    	          //대기실----> 대화방 이동!!
		    	          waitV.remove(this);
		    	          myRoom.userV.add(this);
		    	          
		    	          //대기실 사용자들에게 방정보를 출력
		    	          //예) 대화방명:JavaLove
		    	          //-----> roomInfo(JList) :  JavaLove--1		    	          
		    	          messageWait("160|"+ getRoomInfo());		    	          
		    	          break;
		    	          
		      case "200": //방들어가기    ----> msgs[] = {"200","자바방"}
		    	         for(int i=0; i<roomV.size(); i++){//방이름 찾기!!
		    	        	 Room r = roomV.get(i);
		    	        	 if(r.title.equals(msgs[1])){//일치하는 방 찾음!!		    	        	
		    	        		 myRoom = r;
		    	        		 myRoom.count++;//인원수 1증가
		    	        		 break;
		    	        	 }
		    	         }//for
		    	         messageRoom("300|"+nickName+"님이 입장했습니다");
		    	         //대기실----> 대화방 이동!!
		    	          waitV.remove(this);
		    	          myRoom.userV.add(this);	
		    	          
		    	         //들어갈 방의 title전달
		    	         
		    	         
		    	         messageWait("160|"+ getRoomInfo());
		    	         break;
		      case "250"://방 나가기
//		    	  System.out.println(roomV.get(0).title);
	    	      myRoom.count--;
		    	  messageRoom("300|"+nickName+"님이 퇴장 했습니다");
		    	  waitV.add(this);
		    	  myRoom.userV.remove(this);
		    	  System.out.println(waitV.size()+","+myRoom.userV.size()+",");
		    	  break;
		      case "300": //메시지
		    	          messageRoom("300|["+nickName +"]▶ "+msgs[1]);
		    	          //클라이언트에게 메시지 보내기
		    	          break;
		    }//서버 switch
		  }//if
		}//while
	 }catch (IOException e) {
		 System.out.println("★");
		e.printStackTrace();
	}
   }//run
   
   public String getRoomInfo(){
	  String str="";
	  for(int i=0; i<roomV.size(); i++){
		  //"자바방--1,오라클방--1,JDBC방--1"
		 Room r= roomV.get(i);
		 str += r.title+"--"+r.count;
		 if(i<roomV.size()-1)str += ",";
	  }
	  return str;
   }//getRoomInfo
   
   public void messageAll(String msg){//전체사용자
	   //접속된 모든 클라이언트(대기실+대화방)에게 메시지 전달	   
	   for(int i=0; i<allV.size(); i++){//벡터 인덱스
		  Service service = allV.get(i); //각각의 클라이언트 얻어오기
		  try {
			service.messageTo(msg);
		} catch (IOException e) {
			//에러발생 ---> 클라이언트 접속 끊음!!
			allV.remove(i--); //접속 끊긴 클라이언트를 벡터에서 삭제!!
		    System.out.println("클라이언트 접속 끊음!!");
		}
	   }
   }//messageAll
   
   public void messageWait(String msg){//대기실 사용자	   
	   for(int i=0; i<waitV.size(); i++){//벡터 인덱스
		   Service service = waitV.get(i); //각각의 클라이언트 얻어오기
		   try {
			   service.messageTo(msg);
		   } catch (IOException e) {
			   //에러발생 ---> 클라이언트 접속 끊음!!
			   waitV.remove(i--); //접속 끊긴 클라이언트를 벡터에서 삭제!!
			   System.out.println("클라이언트 접속 끊음!!");
		   }
	   }
   }//messageWait
   
   public void messageRoom(String msg){//대화방사용자
//	   System.out.println("msg="+msg);
//	   System.out.println("myRoom="+myRoom);
//	   System.out.println("myRoom 벡터="+ myRoom.userV.size());
	   for(int i=0; i< myRoom.userV.size(); i++){//벡터 인덱스
		   Service service = myRoom.userV.get(i); //각각의 클라이언트 얻어오기
		   try {
			   service.messageTo(msg);
		   } catch (IOException e) {
			   //에러발생 ---> 클라이언트 접속 끊음!!
			   myRoom.userV.remove(i--); //접속 끊긴 클라이언트를 벡터에서 삭제!!
			   System.out.println("클라이언트 접속 끊음!!");
		   }
	   }
   }//messageAll
   
   public void messageTo(String msg) throws IOException{
	   //특정 클라이언트에게 메시지 전달 (실제 서버--->클라이언트 메시지 전달)
	   out.write(  (msg+"\n").getBytes()   );
   }
	
}



