package com.kosta.j0308;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionTest2 {

	public static void main(String[] args) {

		try {
			FileReader fr = new FileReader("b.txt");// ���⼭ �������� catch�� �ٷ� �б�
			
			System.out.println("������ ã�ҽ��ϴ�");

		} catch (FileNotFoundException e) {
			System.out.println("������ ã�� ���߽��ϴ�");
			
//			e.���� �޼��� ��ü ���� ����ϴ� �޼ҵ�
			e.getMessage();
			e.toString();
			e.printStackTrace();
		}
	}

}
