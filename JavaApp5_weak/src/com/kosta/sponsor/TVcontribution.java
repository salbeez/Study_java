package com.kosta.sponsor;

public class TVcontribution {
	public static void main(String[] args) throws InterruptedException {
		
		Account account = new Account();
		//������ 5���� ����
		Custommer c_group[] = new Custommer[5];//-->null �⺻��
		for(int i=0; i<c_group.length; i++){
			c_group[i] = new Custommer(account);
		}
		
		for(int i=0; i<c_group.length; i++){
			c_group[i].start();
		}
		for(int i=0; i<c_group.length; i++){
			c_group[i].join();//���� �����尡 �ٸ� ������ ������� ��ٷ���!!
		}
		
		System.out.println("�� ���ݾ� : "+account.getTotal());
	}
}
