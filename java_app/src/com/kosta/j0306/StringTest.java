package com.kosta.j0306;

public class StringTest {
	public static void main(String[] args) {
		String str = "JavaPrograming";

		// ���ڿ� ����
		System.out.println("str�� ���ڿ� ���� : " + str.length() + "\n---------");

		// �κ� ���ڿ� "Pro"
		System.out.println("Pro ���ڿ� ��� : " + str.substring(4, 7));
		System.out.println("Programming ���ڿ� ��� : " + str.substring(4) + "\n---------");

		// Ư�� ������ �ε���
		System.out.println(str.indexOf('a'));// ã���� ���ϸ� -1��ȯ ã���� �ش� �ε����� ��ȯ
		System.out.println(str.charAt(0));

		// ���ڿ� ġȯ
		str = str.replace("J", "C");
		str = str.replace("Programing", "C");
		System.out.println(str);

		// ���ڿ��� ���� �߰�
		str = "  JavaPrograming  ";
		System.out.println(str.length());
		
		//���ڿ� ���� ����
		str = str.trim();
		str.length();
		System.out.println(str+" "+str.length());
		
	}
}
