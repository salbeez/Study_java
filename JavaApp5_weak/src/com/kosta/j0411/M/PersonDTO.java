package com.kosta.j0411.M;

public class PersonDTO {
	// DTO (Date Transfer Object), VO(value object) ,JavaBeans
	// 서로 관련성 있는 속성을 묶어주는 클래스
	// DB테이블과 동기화 해주는 클래스
	// 테이블내의 레코드 하나를 표현하는 객체!!

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
