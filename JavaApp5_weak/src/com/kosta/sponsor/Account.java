package com.kosta.sponsor;

public class Account {//�����(������)
	private int total;
	
	public synchronized void deposit(int account){
		//�޼ҵ� ����ȭ(�޼ҵ忡 ������ �����尡 ���� ��� �ٸ� ��������� ����ϰ��ϴ� ����)
		
		//����ȭ�� ��ü synchronized(����ȭ ��ü){}---> Ư�� ���� ����ȭ
		total += account;
	}
	public int getTotal(){
		return total;
	}
}
