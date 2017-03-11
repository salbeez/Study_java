package com.kosta.j0307;

/**
 * @author ksota
 *
 *         class 이름 {
 *
 *         필드
 *
 *         class 이름2{ static이 선언되면 정적클래스, 없으면 비정적 inner클래스라고 한다
 *							static은 따로 메모리 할당이되 있음으로 static끼리는 사용할수 있으나...
 *         }
 *
 *         메소드
 * 
 *         }
 */
class NestClass { //]
	static int i =10;
	void hello() {
		NestedClass nested = new NestedClass();
		nested.print();//내부 클래스를 하기 위해서는 객체 생성
	}

	static class NestedClass {
		int j = 20;

		void print() {
			System.out.println("i = "+ i +"\nj = "+ j);
		}
	}
}

public class NestedClassTest {
	
	public static void main(String[] args) {
		NestClass nesting = new NestClass();
		nesting.hello();
		
//		print()메소드 직접 호출
//		외부 클래스명.내부클래스 참조변수 = new 외부 클래스(). 외부 클래스
		
//		비정적 static 안 붙은거
//		NestClass.NestedClass nested = new NestClass().new NestedClass();
		
//		static 붙은거
		NestClass.NestedClass nested = new NestClass.NestedClass();
		nested.print();
	}

}
