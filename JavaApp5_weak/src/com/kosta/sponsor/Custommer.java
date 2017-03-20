package com.kosta.sponsor;

public class Custommer extends Thread {// 성금자 스레드 .... (경쟁적인 성금자)
	Account account;

	public Custommer(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		// 1회 천원씩 모금
		try {
			for (int i = 1; i <= 200; i++) {
				Thread.sleep(100);
				account.deposit(1000);
				System.out.println(getName() + " : " + i + "회 모금");

				if (account.getTotal() >= 500000) {// 목표액이 달성
					break;// for문 탈출
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
