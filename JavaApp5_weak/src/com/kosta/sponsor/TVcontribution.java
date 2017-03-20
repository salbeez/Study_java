package com.kosta.sponsor;

public class TVcontribution {
	public static void main(String[] args) throws InterruptedException {
		
		Account account = new Account();
		//성금자 5명을 모집
		Custommer c_group[] = new Custommer[5];//-->null 기본값
		for(int i=0; i<c_group.length; i++){
			c_group[i] = new Custommer(account);
		}
		
		for(int i=0; i<c_group.length; i++){
			c_group[i].start();
		}
		for(int i=0; i<c_group.length; i++){
			c_group[i].join();//메인 스레드가 다른 스레드 종료까지 기다려라!!
		}
		
		System.out.println("총 성금액 : "+account.getTotal());
	}
}
