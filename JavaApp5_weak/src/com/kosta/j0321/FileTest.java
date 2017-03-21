package com.kosta.j0321;

import java.io.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) {
		String path = FileTest.class.getResource("").getPath();
		File f = new File("C:\\Users\\ksota\\git\\Study_java\\JavaApp5_weak\\a.txt");
		System.out.println(path);
		try {
			if(f.exists() && f.isFile()){
				FileInputStream inputFile = new FileInputStream(f);
				int i=0;
				while((i =inputFile.read()) != -1){
					System.out.println((char)i);				
				}
			}
			String path2 = "gildong/";
			String fileName = "c.txt";
			File f2 = new File(path2);//파일에는 디렉토리 생성기능이 있다.
			if(!f2.exists()){
				f2.mkdirs();				
			}
			FileOutputStream fos =new FileOutputStream(path2+fileName);
			fos.close();//파일쪽은 꼭 쓰고 나서는 닫아줘야한다.
			
			File f7 = new File(path2+fileName);
			f7.delete();
					
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
