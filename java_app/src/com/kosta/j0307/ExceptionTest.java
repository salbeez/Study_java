package com.kosta.j0307;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * <자바 입출력 4대 클래스> - 추상클래스
 * ----------------------->byte단위의 입출력
 * 1. InputStream 입력쪽
 * 2. OutputStream
 * 
 * ---------->char(2byte)단위의 입력, 출력
 * 3. reader 
 * 4. Writer
 * 
 * =========
 * FileInputStream
 * FileReader
 * 
 * a
 * */

public class ExceptionTest {

	// 파일(안의 내용)을 읽어서 콘솔에 출력
	void readFile(){

		try{ //만약에 try내에서 예외가 발생한다면 ex)경로가 잘못됬거나 파일이 없거나 등
			FileReader fr = new FileReader("a.txt");	//File NOT Found
			
			int i;
			while( (i=fr.read()) !=-1){	//텍스트가 끝날때 까지
//				s.o.f(  (char)97  )
			System.out.print((char)i);// IOException	//13,10 Enter
			}
			
		/*	while( (fr.read() !=-1){	//텍스트가 끝날때 까지
				s.o.f(  (char)97  )
				System.out.print((char)fr.read());
				이렇게 하면 abcd가 출력되지 않고 bd만 출력
				이유 : while문에서 a 읽고 s.o.f에서 b읽고 ....다시 while에서 c읽고 s.o.f에서 d읽고
			}		
		System.out.println("\n파일 읽기 성공");*/
			
		} catch(FileNotFoundException fe){
			System.out.println("파일을 찾지 못했습니다 [경로확인,존재여부 검사]");
		} catch(IOException ie) {
			
		}
	}

	public static void main(String[] args) {
		ExceptionTest ex = new ExceptionTest();
					ex.readFile();
			
	}
}
