package com.kosta.j0306;

public class MatchesTest {

	// boolean str.matches(String regex)
	// regex는 정규 표현식
	// regex를 통해 전달되는 패턴에 str이 부합 되면 true리턴

	public static void main(String[] args) {
		String str = "b";
		System.out.println(str.matches("[a]"));//a문자 한번
		System.out.println(str.matches("[a]?"));// a문자가 0,1과 한번을 표현할때
		System.out.println(str.matches("[a]*"));//a문자 0~무한대
		System.out.println(str.matches("[a]+"));//a문자 1~무한대
		
		System.out.println(str.matches("[abc]"));//a or b or c 중에 한번 출현시 true
		
		String str2 = "gildong";	//영문자 체크
		
		System.out.println(str2.matches("[a-z]+"));//영문자[소문자] 조합
		
		String su = "123456";
		System.out.println(su.matches("[0-9]+"));
		
		String hangle = "나한글";
		System.out.println(hangle.matches("[ㄱ-�R]+"));;
		
		String hangle2 = "나한글1123";
		System.out.println(hangle.matches("[a-z]+"));
		//회원 가입시
		String id = "gildong1004";
//		id = 8~12자리 이고 영문자와 숫자 조합
		System.out.println(id.matches("[a-z0-9]{8,12}"));
	}
}
