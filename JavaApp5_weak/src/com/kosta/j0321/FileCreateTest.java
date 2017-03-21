package com.kosta.j0321;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
/*input output =>byte단위의 입출력 '단일 문자'
 * Reader Writer =>String 단위의 입출력*/
public class FileCreateTest {
	public static void main(String[] args) throws IOException {
		
		String path = null;
		String fileName = null;
		String content = null;		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("생성 경로 : ");
		path = bf.readLine()+"/";
		System.out.println("생성 파일 이름 : ");
		fileName = bf.readLine();
		System.out.println("파일에 들어갈 내용 : ");
		content = bf.readLine();
		System.out.println(content);
		File f =new File(path);
	
		if(!f.exists()){
				f.mkdirs();//디렉토리 만들고
		}
//		File f2 = new File(path+fileName);//파일 만들고
		File f2 = new File(path+fileName);
			System.out.println("**");
			FileWriter f3 = new FileWriter(f2);//파일에 쓸수 있게 만들고 output과 Writer은 파일 생성이 가능하다			
			f3.write(content+"\n");
			f3.close();
	}
}
