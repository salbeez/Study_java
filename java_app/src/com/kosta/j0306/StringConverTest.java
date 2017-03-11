package com.kosta.j0306;

public class StringConverTest {

	void convert1() {
		String s1 = "우리나라";
		String s2 = "대한민국 만세!";

		s1 += s2;
		System.out.println(s1);
		/*
		 * 	String 클래스 : 고정 길이 문자열
		 * 1. String 클래스 객체 생성
		 * 2. 문자열 변환을 위해서 임시로, StringBuffer클래스 객체 생성
		 * 3.appand() 메소드 호출
		 * 4.StringBuffer객체를 String객체로 변환
		 * 5.임시생성된 StringBuffer객체를 소멸
		 * */
	}

	void convert2() {	//이 부분이 성능상 더 빠르다고 한다
		StringBuffer s1 = new StringBuffer("우리나라");
		s1.append("대한민국 만세");
		System.out.println(s1);
		/*
		 * 1. StringBuffer클래스 객체 생성
		 * 2. append()메소드 실해
		 * */
	}

	public static void main(String[] args) {
		StringConverTest sct = new StringConverTest();
		sct.convert1();
		sct.convert2();
		
	}
}
