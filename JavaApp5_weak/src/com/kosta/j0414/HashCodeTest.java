package com.kosta.j0414;

public class HashCodeTest {
	public static void main(String[] args) {
		Integer a=new Integer(123456);
		System.out.println(a.hashCode());
		
		String b = "ab";
		b.hashCode();//�ƽ�Ű �ڵ� ��
		System.out.println(b.hashCode());
	}
}
