package com.kosta.j0306;

class A {
	int su = 10;

	void hello() {
		System.out.println("AŬ���� �ȳ�");
	}
}

class NullPointEx {
	A obj;

	void callTest() {
//		 obj = new A(); // ȣ���ʿ��� null������ �߻� ������ ��ü ������ ���� �ʾƼ�
//		������ ' . ' �տ� �ִ� ���� �����̳� ������ '( �Ű����� )' ������ ������ ���⵵ �Ѵ�
		obj.hello();
	}
}

public class NullPointTest {
	public static void main(String[] args) {
		NullPointEx nullTest = new NullPointEx();
		nullTest.callTest();
	}
}
