package com.kosta.j0321;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayTest {

	public static void main(String[] args) throws IOException{
		FileInputStream fis = new FileInputStream("c.txt");
		FileOutputStream fos = new FileOutputStream("d.txt");
		
		byte arr[] = new byte[5];
//		System.out.println(fis.read(arr));//
//		System.out.println(fis.read(arr));
//		System.out.println(fis.read(arr));
		
		int i; 
		while((i=fis.read(arr)) != -1){
			fos.write(arr,0,i);//-->abcdefghie// 상대위치 , 지정된 새로운 시작 인덱스 ,복사할 바이트의 수
		}
		fis.close();
		fos.close();
		System.out.println("복사 성공");
	}
}
