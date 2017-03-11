package com.kosta.j0306;

public class StringTest {
	public static void main(String[] args) {
		String str = "JavaPrograming";

		// 문자열 길이
		System.out.println("str의 문자열 길이 : " + str.length() + "\n---------");

		// 부분 문자열 "Pro"
		System.out.println("Pro 문자열 얻기 : " + str.substring(4, 7));
		System.out.println("Programming 문자열 얻기 : " + str.substring(4) + "\n---------");

		// 특정 문자의 인덱스
		System.out.println(str.indexOf('a'));// 찾지를 못하면 -1반환 찾으면 해당 인덱스를 반환
		System.out.println(str.charAt(0));

		// 문자열 치환
		str = str.replace("J", "C");
		str = str.replace("Programing", "C");
		System.out.println(str);

		// 문자열에 공백 추가
		str = "  JavaPrograming  ";
		System.out.println(str.length());
		
		//문자열 공백 제거
		str = str.trim();
		str.length();
		System.out.println(str+" "+str.length());
		
	}
}
