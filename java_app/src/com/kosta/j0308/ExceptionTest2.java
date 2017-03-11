package com.kosta.j0308;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionTest2 {

	public static void main(String[] args) {

		try {
			FileReader fr = new FileReader("b.txt");// 여기서 에러나면 catch로 바로 분기
			
			System.out.println("파일을 찾았습니다");

		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾지 못했습니다");
			
//			e.에러 메세지 객체 많이 사용하는 메소드
			e.getMessage();
			e.toString();
			e.printStackTrace();
		}
	}

}
