package com.kosta.j0306;

public class MatchesTest {

	// boolean str.matches(String regex)
	// regex�� ���� ǥ����
	// regex�� ���� ���޵Ǵ� ���Ͽ� str�� ���� �Ǹ� true����

	public static void main(String[] args) {
		String str = "b";
		System.out.println(str.matches("[a]"));//a���� �ѹ�
		System.out.println(str.matches("[a]?"));// a���ڰ� 0,1�� �ѹ��� ǥ���Ҷ�
		System.out.println(str.matches("[a]*"));//a���� 0~���Ѵ�
		System.out.println(str.matches("[a]+"));//a���� 1~���Ѵ�
		
		System.out.println(str.matches("[abc]"));//a or b or c �߿� �ѹ� ������ true
		
		String str2 = "gildong";	//������ üũ
		
		System.out.println(str2.matches("[a-z]+"));//������[�ҹ���] ����
		
		String su = "123456";
		System.out.println(su.matches("[0-9]+"));
		
		String hangle = "���ѱ�";
		System.out.println(hangle.matches("[��-�R]+"));
		
		//ȸ�� ���Խ�
		String id = "gildong1004";
//		id = 8~12�ڸ� �̰� �����ڿ� ���� ����
		System.out.println(id.matches("[a-z0-9]{8,12}"));
	}
}
