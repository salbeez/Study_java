package com.kosta.sponsor;

public class Custommer extends Thread {// ������ ������ .... (�������� ������)
	Account account;

	public Custommer(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		// 1ȸ õ���� ���
		try {
			for (int i = 1; i <= 200; i++) {
				Thread.sleep(100);
				account.deposit(1000);
				System.out.println(getName() + " : " + i + "ȸ ���");

				if (account.getTotal() >= 500000) {// ��ǥ���� �޼�
					break;// for�� Ż��
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
