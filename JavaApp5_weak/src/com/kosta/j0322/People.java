package com.kosta.j0322;

import java.io.Serializable;

public class People implements Serializable{ //Serializable�� ��ũ �������̽���
	private String name;								//����ȭ�� �Ѵٴ� �͸� �˷��ִ� �������̽�
	private int age;										//ObjectStream�� ������ �Ѵٸ� �� ����Ѵ�.
	private String job;									//������ ���� ���� ��´ٴ� ��������
//	transient String name // transient : ������ ������ ���� ���� ����. 
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
