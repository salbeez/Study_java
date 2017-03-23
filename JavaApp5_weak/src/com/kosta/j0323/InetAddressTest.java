package com.kosta.j0323;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
   public static void main(String[] args) {
	  //InetAddress ia = InetAddress.getByName(String host);
	   String host= "kosta.or.kr" ;//"naver.com";
	   //호스트: 서비스를 제공하는 단말(PC)
	   //naver.com: 도메인 (ip주소에 적용하는 문자)
	   
	   try {
		InetAddress ia = InetAddress.getByName(host);
		
		String name = ia.getHostName();
		String addr = ia.getHostAddress();
		System.out.println("호스트이름: "+ name); //도메인 이름
		System.out.println("호스트주소: "+ addr); //도메인에 매핑된 실제 ip주소
		
		System.out.println("======================");
		//도메인에 매핑된 모든 서버ip 얻어오기
		String host2="www.daum.net";
		InetAddress [] ias= InetAddress.getAllByName(host2);
		System.out.println(host2+"의 서버ip");
		for (int i = 0; i < ias.length; i++) {
			System.out.println(" "+ ias[i].getHostAddress());
		}
		
		
	  } catch (UnknownHostException e) {
		e.printStackTrace();
	}
   }//main
}




