package com.kosta.j0306;

class A {
	int su = 10;

	void hello() {
		System.out.println("A클래스 안녕");
	}
}

class NullPointEx {
	A obj;

	void callTest() {
//		 obj = new A(); // 호출쪽에서 null에러가 발생 이유는 객체 생성을 하지 않아서
//		보통은 ' . ' 앞에 있는 놈이 문제이나 가끔은 '( 매개변수 )' 때문에 에러가 나기도 한다
		obj.hello();
	}
}

public class NullPointTest {
	public static void main(String[] args) {
		NullPointEx nullTest = new NullPointEx();
		nullTest.callTest();
	}
}
