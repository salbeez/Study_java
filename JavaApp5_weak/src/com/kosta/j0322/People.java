package com.kosta.j0322;

import java.io.Serializable;

public class People implements Serializable{ //Serializable은 마크 인터페이스로
	private String name;								//직렬화를 한다는 것만 알려주는 인터페이스
	private int age;										//ObjectStream을 쓰려고 한다면 꼭 써야한다.
	private String job;									//우편에서 도장 쾅쾅 찍는다는 느낌으로
//	transient String name // transient : 데이터 전달을 하지 않을 변수. 
	public People(String name, int age, String job) {
		super();
		this.name = name;
		this.age = age;
		this.job = job;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
}
