package com.kosta.j0308;

/*
 * ����� ���� Exception Ŭ����
 * */
class MyException extends Exception {
	// �ڽ��� �θ��� �Ӽ��� �� �����ϱ� ����� ���Ǹ� ������ �� �ִ�.

	public MyException(String mesege) {
		super(mesege);
	}
}

// ���� Ŭ������ ��ӿ��� ������ �� 2�� (private, �θ� ������)
public class MyExceptionTest {
	public static void main(String[] args) {
		try {
			throw new MyException("��� ����");
		} catch (MyException e) {
			e.printStackTrace();
		}
	}
}
