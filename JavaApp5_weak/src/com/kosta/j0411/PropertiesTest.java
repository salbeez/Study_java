package com.kosta.j0411;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) {
		// Property �Ӽ� ������(TEXT)�� �����ϴ� Ŭ����
		Properties pro = new Properties();
		// key�� ������ ��
		pro.setProperty("k1", "ȫ�浿");
		pro.setProperty("k2", "�����");
		pro.setProperty("k3", "���ֿ�");

		// ����� �ع�����
		pro.setProperty("k3", "������");

		// ������ ���
		System.out.println(pro.getProperty("k1"));

		// Ű���� �˰� ������
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
