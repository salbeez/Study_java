package com.kosta.sponsor;

public class Account {//모금함(저금통)
	private int total;
	
	public synchronized void deposit(int account){
		//메소드 동기화(메소드에 집입한 스레드가 있을 경우 다른 스레드들은 대기하게하는 역할)
		
		//동기화할 객체 synchronized(동기화 객체){}---> 특정 영역 동기화
		total += account;
	}
	public int getTotal(){
		return total;
	}
}
