package com.kosta.j0321;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
/*input output =>byte������ ����� '���� ����'
 * Reader Writer =>String ������ �����*/
public class FileCreateTest {
	public static void main(String[] args) throws IOException {
		
		String path = null;
		String fileName = null;
		String content = null;		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("���� ��� : ");
		path = bf.readLine()+"/";
		System.out.println("���� ���� �̸� : ");
		fileName = bf.readLine();
		System.out.println("���Ͽ� �� ���� : ");
		content = bf.readLine();
		System.out.println(content);
		File f =new File(path);
	
		if(!f.exists()){
				f.mkdirs();//���丮 �����
		}
//		File f2 = new File(path+fileName);//���� �����
		File f2 = new File(path+fileName);
			System.out.println("**");
			FileWriter f3 = new FileWriter(f2);//���Ͽ� ���� �ְ� ����� output�� Writer�� ���� ������ �����ϴ�			
			f3.write(content+"\n");
			f3.close();
	}
}
