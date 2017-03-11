package com.kosta.j0307;

import java.util.Vector;

/**
 * Vector<E> : <E>는 제네릭 타입 : 뭘 집어넣을지 자료형 선언(명시)->명료성이 높아짐
 * 
 * <E> : element(요소)로 사용될 자료형을 명시.
 * <K> : key
 * <V> : value
 * <T> : type
 * <등등 자료형>
 * */

class A {
	void hello(){
		System.out.println("A class hello");
	}
}
public class VectorTest2 {

		public static void main(String[] args) {
			Vector v = new Vector();
			v.add(new A());
			
			Object ob= v.get(0);//얻어 오기 (index)단위로
//			ob.hello();// 에러!! (이유: 부모 레퍼런스를 통해 자식요소 호출불가)
			A a = (A)ob;
			a.hello();//자식 캐스팅
			
			Vector<A> v2 = new Vector<A>();
//			Vector<A> v2 = new Vector<>(); //jdk 7버전 부터 <>지원 생략 가능
			v2.add(new A());
			
			A a2 = v2.get(0);
			a2.hello();
			
			v2.toArray();//벡터를 배열로 변경
		}
}
