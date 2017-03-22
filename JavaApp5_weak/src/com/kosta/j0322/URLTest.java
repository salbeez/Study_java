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
			
			System.out.println("url의 프로토콜 : "+url.getProtocol());
			System.out.println("호스트 : "+url.getHost());//host : 서비스 단말(PC);
			System.out.println("경로 : "+url.getPath());
			System.out.println("서비스파일명 : "+url.getFile());
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			is = url.openStream();//읽기
			br2 = new BufferedReader(new InputStreamReader(is,"UTF-8"));
			

			fos = new FileOutputStream(new File("Test.html"));//쓰기
			bw = new BufferedWriter(new OutputStreamWriter(fos, "UTF-8") );
			
//			소스 긁어오기
			String str;
			while(  (str = br2.readLine()) != null){//먼저 읽고
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
