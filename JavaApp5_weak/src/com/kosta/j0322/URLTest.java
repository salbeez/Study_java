package com.kosta.j0322;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {
	public static void main(String[] args) {
		InputStream is =null;
		BufferedReader br2 = null;
		FileOutputStream fos =null;
		BufferedWriter bw = null;
		try {
			URL url = new URL("http://www.naver.com/index.html");
			
			System.out.println("url�� �������� : "+url.getProtocol());
			System.out.println("ȣ��Ʈ : "+url.getHost());//host : ���� �ܸ�(PC);
			System.out.println("��� : "+url.getPath());
			System.out.println("�������ϸ� : "+url.getFile());
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			is = url.openStream();//�б�
			br2 = new BufferedReader(new InputStreamReader(is,"UTF-8"));
			

			fos = new FileOutputStream(new File("Test.html"));//����
			bw = new BufferedWriter(new OutputStreamWriter(fos, "UTF-8") );
			
//			�ҽ� �ܾ����
			String str;
			while(  (str = br2.readLine()) != null){//���� �а�
				System.out.println(str+"\n");
				fos.write(str.getBytes());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				is.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
