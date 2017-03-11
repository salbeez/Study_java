package com.kosta.j0308;

/*
 * 사용자 정의 Exception 클래스
 * */
class MyException extends Exception {
	// 자식이 부모의 속성을 다 받으니깐 사용자 정의를 지정할 수 있다.

	public MyException(String mesege) {
		super(mesege);
	}
}

// 상위 클래스의 상속에서 빠지는 것 2개 (private, 부모 생성자)
public class MyExceptionTest {
	public static void main(String[] args) {
		try {
			throw new MyException("당신 에러");
		} catch (MyException e) {
			e.printStackTrace();
		}
	}
}
