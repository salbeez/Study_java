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
			fos.write(arr,0,i);//-->abcdefghie// �����ġ , ������ ���ο� ���� �ε��� ,������ ����Ʈ�� ��
		}
		fis.close();
		fos.close();
		System.out.println("���� ����");
	}
}
