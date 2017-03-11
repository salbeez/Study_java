package com.kosta.j0307;

import java.util.Vector;

/**
 * 제네릭 타입을 사용했을 때 장점 : 추가적인 자식 캐스팅이 필요없음
 */
public class VectorTest3 {
	public static void main(String[] args) {
		// 데이터 추가 검색 삭제 수정
		Vector<String> v = new Vector<>();

		// 추가함수
		/*
		 * v.addElement(obj);; v.add(e); v.insertElementAt(obj, index);
		 * v.add(int index, String element); insert랑 같다
		 * 
		 * 0: 홍길동 1: 길라임 2: 김주원
		 * 
		 * v.insertElementAt("김유신", 1); 0: 홍길동 1: 김유신 2: 길라임 3: 김주원
		 */

		// 추가 일단 이것만 쓰자 v.add(데이터)
		v.add("홍길동");
		v.add("길라임");
		v.add("김주원");
		v.add("홍길동");

		// 검색
		for (int i = 0; i < v.size(); i++) {// 벡터의 인덱스 표현
			// v.size() :백터의 저장된 요소 갯수
			String name = v.get(i);
		
			System.out.println(i + " " + name);
		}

		// 수정 (길라임) -> (차라임)

		// v.set(index, element);
		// v.setElementAt(obj, index);
		v.setElementAt("차라임", 1);// 수정

		// 삭제

		// v.remove(index);
		// v.remove(object o);

		v.remove("홍길동");// index 순으로 삭제 0번째가 삭제

		// 벡터내의 전체 데이터를 삭제
		v.removeAllElements();
		v.clear();

		//
		// is ~ 메소드 : 상태를 표현하는 메소든
		System.out.println(v.isEmpty());
	}

}
