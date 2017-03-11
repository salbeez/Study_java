package com.kosta.j0307;

import java.util.Vector;

class Person {
	String name = "홍길동";
	int age = 13;
	String job = "학생";
}

public class VectorPerson {
	public static void main(String[] args) {
			//0번째 백터의 이름을 출력하시오
		Vector<Person> v = new Vector<>();
		
		v.add(new Person());
		System.out.println(v.get(0).name);
	}
}
