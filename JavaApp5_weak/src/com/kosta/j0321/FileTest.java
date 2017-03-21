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
			File f2 = new File(path2);//���Ͽ��� ���丮 ��������� �ִ�.
			if(!f2.exists()){
				f2.mkdirs();				
			}
			FileOutputStream fos =new FileOutputStream(path2+fileName);
			fos.close();//�������� �� ���� ������ �ݾ�����Ѵ�.
			
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
