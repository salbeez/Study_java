package com.kosta.j0411.M;

public class PersonDTO {
	// DTO (Date Transfer Object), VO(value object) ,JavaBeans
	// ���� ���ü� �ִ� �Ӽ��� �����ִ� Ŭ����
	// DB���̺�� ����ȭ ���ִ� Ŭ����
	// ���̺��� ���ڵ� �ϳ��� ǥ���ϴ� ��ü!!

	private int no;
	private String name;
	private int age;
	private String job;

	public PersonDTO() {		
	}
	
	public PersonDTO(int no, String name, int age, String job) {
		super();
		this.no = no;
		this.name = name;
		this.age = age;
		this.job = job;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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
