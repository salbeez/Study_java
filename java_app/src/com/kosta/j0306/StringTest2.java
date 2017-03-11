package com.kosta.j0306;

import java.util.StringTokenizer;

public class StringTest2 {
	public static void main(String[] args) {
		String str = "Java3Prog7rammi9ng";

		// 문제) str안에 숫자의 갯수를 출력하시오
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			if (ch >= '0' && ch <= '9') {
				sum++;
			}

		}
		System.out.println(sum);

		// str 대 소문자 변환
		System.out.println(str.toUpperCase());
		System.out.println(str.toLowerCase());

		// 바이트 변환
		byte[] s1 = str.getBytes();
		System.out.println(s1);

		// 바이트를 string으로
		String str2 = new String(s1);
		System.out.println(str2);

		//
		String t1 = "java";
		String t2 = "JAVA";

		if (t1.equals(t2)) {
			System.out.println("문자열 같음");
		} else {
			System.out.println("문자열 다름");
		}

		if (t1.equalsIgnoreCase(t2)) {
			System.out.println("문자열 같음");
		} else {
			System.out.println("문자열 다름");
		}
		
		//문제 2 string tel 010=123=4567
		String tel = "010-123-4567";
		String tel1,tel2,tel3;
		tel1 = tel.substring(0, 3);
		tel2 = tel.substring(4,7);
		tel3 = tel.substring(8);
		
		System.out.println(tel1 + " * "+tel2+ " * "+tel3);
		
//		tel = tel.replace("-", "");
//		tel.indexOf("-");
		
		tel1 = tel.substring(0, tel.indexOf("-"));
		tel2 = tel.substring(tel.indexOf("-")+1,tel.lastIndexOf("-"));
		tel3 = tel.substring(tel.lastIndexOf("-")+1);
		
		System.out.println(tel1 + " * "+tel2+ " * "+tel3);
		
		String tel4[] = tel.split("-");
		System.out.println(tel4[1]);
//		문자열을 특정 구문자로 분리해준는 클라스
//		str : 구분하고자 하는 문자열 (기준 부[[문자열)
		StringTokenizer st = new StringTokenizer (tel,"-");
		st.hasMoreTokens();
		
	}
}
