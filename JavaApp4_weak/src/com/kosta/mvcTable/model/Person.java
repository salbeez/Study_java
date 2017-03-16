package com.kosta.mvcTable.model;

public class Person {
	private int No;
	private String name;
	private String age;
	private String job;
	
	public Person(int no,String name, String age, String job) {
		this.No = no;
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	public void setPerson(String age, String job){
		this.age = age;
		this.job = job;
	}

	public int getNo() {
		return No;
	}

	public void setNo(int no) {
		No = no;
	}
}
