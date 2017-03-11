package com.kosta.j0308;

class Person {// 切郊 Beans
	private String name;
	private String job;
	private int age;

	public Person(String name, int age, String job) {// 持失切
		this.name = name;
		this.age = age;
		this.job = job;
	}

	public void setPerson(int age, String job) {
		this.age = age;
		this.job = job;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	public String getJob() {
		return this.job;
	}

	@Override
	public String toString() {
		return "[" + name + "," + age + "," + job + "]";
	}
}
