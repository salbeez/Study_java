package com.kosta.j0323;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
   public static void main(String[] args) {
	  //InetAddress ia = InetAddress.getByName(String host);
	   String host= "kosta.or.kr" ;//"naver.com";
	   //ȣ��Ʈ: ���񽺸� �����ϴ� �ܸ�(PC)
	   //naver.com: ������ (ip�ּҿ� �����ϴ� ����)
	   
	   try {
		InetAddress ia = InetAddress.getByName(host);
		
		String name = ia.getHostName();
		String addr = ia.getHostAddress();
		System.out.println("ȣ��Ʈ�̸�: "+ name); //������ �̸�
		System.out.println("ȣ��Ʈ�ּ�: "+ addr); //�����ο� ���ε� ���� ip�ּ�
		
		System.out.println("======================");
		//�����ο� ���ε� ��� ����ip ������
		String host2="www.daum.net";
		InetAddress [] ias= InetAddress.getAllByName(host2);
		System.out.println(host2+"�� ����ip");
		for (int i = 0; i < ias.length; i++) {
			System.out.println(" "+ ias[i].getHostAddress());
		}
		
		
	  } catch (UnknownHostException e) {
		e.printStackTrace();
	}
   }//main
}




