package com.kosta.j0321;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SpeedTest {
	
// byte���� �����
	FileInputStream fis;
	FileOutputStream fos;
	FileInputStream fis2;
	FileOutputStream fos2;
// char���� �����
	FileReader fr;
	FileWriter fw;
//	Buffered �����
	BufferedReader br;
	BufferedWriter bw;

	public SpeedTest() throws IOException{
		fis = new FileInputStream("a.txt");//-------------------------------
		fos = new FileOutputStream("b.txt");
		
		int i;
		long start = System.currentTimeMillis();
		while((i=fis.read())!=-1){//�����Ͱ� �����Ѵٸ�
			fos.write(i);
		}
		long end = System.currentTimeMillis();
		fis.close();
		fos.close();
		System.out.println("���Ϻ��� ����"+(end-start));
		
		fr= new FileReader("a.txt");//-------------------------------
		fw = new FileWriter("b.txt");
		
		i=0;
		start = System.currentTimeMillis();
		while((i=fr.read())!=-1){//�����Ͱ� �����Ѵٸ�
			fw.write(i);
		}
		end = System.currentTimeMillis();
		fr.close();
		fw.close();
		System.out.println("���Ϻ��� ����"+(end-start));
		
		br = new BufferedReader(new FileReader("a.txt"));//-------------------------------
		bw = new BufferedWriter(new FileWriter("B.txt"));
				
		i=0;
		start = System.currentTimeMillis();
		while((i=br.read())!=-1){//�����Ͱ� �����Ѵٸ�
				bw.write(i);
		}
		end = System.currentTimeMillis();
		br.close();
		bw.close();
		System.out.println("���Ϻ��� ����"+(end-start));	
		
		//byte�迭�� ���
		fis2 = new FileInputStream("a.txt");//-------------------------------
		fos2 = new FileOutputStream("b.txt");
		byte b[] = new byte[1024];//���� 512,1024byte �� ����Ѵ�
		start = System.currentTimeMillis();
		while((i=fis2.read(b))!=-1){//�����Ͱ� �����Ѵٸ�
			fos2.write(b,0,i);
		}
		end = System.currentTimeMillis();
		fis2.close();
		fos2.close();
		System.out.println("���Ϻ��� ����"+(end-start));
	}
// Speed����
	public static void main(String[] args) throws IOException {
		new SpeedTest();
	}
}
