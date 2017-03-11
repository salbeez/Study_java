package com.kosta.j0306;

public class StringConverTest {

	void convert1() {
		String s1 = "�츮����";
		String s2 = "���ѹα� ����!";

		s1 += s2;
		System.out.println(s1);
		/*
		 * 	String Ŭ���� : ���� ���� ���ڿ�
		 * 1. String Ŭ���� ��ü ����
		 * 2. ���ڿ� ��ȯ�� ���ؼ� �ӽ÷�, StringBufferŬ���� ��ü ����
		 * 3.appand() �޼ҵ� ȣ��
		 * 4.StringBuffer��ü�� String��ü�� ��ȯ
		 * 5.�ӽû����� StringBuffer��ü�� �Ҹ�
		 * */
	}

	void convert2() {	//�� �κ��� ���ɻ� �� �����ٰ� �Ѵ�
		StringBuffer s1 = new StringBuffer("�츮����");
		s1.append("���ѹα� ����");
		System.out.println(s1);
		/*
		 * 1. StringBufferŬ���� ��ü ����
		 * 2. append()�޼ҵ� ����
		 * */
	}

	public static void main(String[] args) {
		StringConverTest sct = new StringConverTest();
		sct.convert1();
		sct.convert2();
		
	}
}
