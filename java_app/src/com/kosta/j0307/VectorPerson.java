package com.kosta.j0307;

import java.util.Vector;

class Person {
	String name = "ȫ�浿";
	int age = 13;
	String job = "�л�";
}

public class VectorPerson {
	public static void main(String[] args) {
			//0��° ������ �̸��� ����Ͻÿ�
		Vector<Person> v = new Vector<>();
		
		v.add(new Person());
		System.out.println(v.get(0).name);
	}
}
