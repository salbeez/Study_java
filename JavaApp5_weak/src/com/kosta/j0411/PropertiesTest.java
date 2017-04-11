package com.kosta.j0411;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) {
		// Property 속성 데이터(TEXT)를 저장하는 클래스
		Properties pro = new Properties();
		// key는 유일한 값
		pro.setProperty("k1", "홍길동");
		pro.setProperty("k2", "길라임");
		pro.setProperty("k3", "김주원");

		// 덮어쓰기 해버린다
		pro.setProperty("k3", "김유신");

		// 데이터 출력
		System.out.println(pro.getProperty("k1"));

		// 키값을 알고 싶을때
		Enumeration enu = pro.propertyNames();
		while(enu.hasMoreElements()){
			Object obj=enu.nextElement();
			System.out.println(obj+" : " + pro.getProperty((String)obj));
		}
		
		try {
			String path = "C:\\Users\\kosta\\git\\Study_java\\JavaApp5_weak\\src\\com\\kosta\\j0411\\test.properties";
			pro.load(new FileInputStream(path));
			System.out.println(pro.getProperty("name"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
