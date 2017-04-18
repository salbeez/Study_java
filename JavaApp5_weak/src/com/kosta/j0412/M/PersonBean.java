package com.kosta.j0412.M;

public class PersonBean {
	
	private String id;
	private String pass;
	private String name;
	private String ssn1;
	private String ssn2;
	private 	String tel;
	private 	String addr;
	private 	String job;
	
	public PersonBean(){}
	public PersonBean(String id, String pass, String name, String ssn1, String ssn2, String tel, String addr, String job) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.ssn1 = ssn1;
		this.ssn2 = ssn2;
		this.tel = tel;
		this.addr = addr;
		this.job = job;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSsn1() {
		return ssn1;
	}
	public void setSsn1(String ssn1) {
		this.ssn1 = ssn1;
	}
	public String getSsn2() {
		return ssn2;
	}
	public void setSsn2(String ssn2) {
		this.ssn2 = ssn2;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	
}
