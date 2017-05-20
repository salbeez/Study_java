package com.kosta.t0515.mission;

public class UserInfo {//JavaBeans, DTO, VO
	//���� ���ü� �ִ� �Ӽ����� ����, DB ���̺��� ������ �ڹٰ�ü�� ǥ��
	//DAO�� �޼ҵ忡�� �����ϴ� ������ �Ǵ� �޼ҵ� ������ ���ϵǴ� �����͸� ǥ��.
	//id,pass,name,jumin,birth,zip,addr,email,job
	private String id,pass,name,jumin,birth,zip,addr,email,job;
	
	public UserInfo() {
	}

	public UserInfo(String id, String pass, String name, String jumin, String birth, String zip, String addr,
			String email, String job) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.jumin = jumin;
		this.birth = birth;
		this.zip = zip;
		this.addr = addr;
		this.email = email;
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

	public String getJumin() {
		return jumin;
	}

	public void setJumin(String jumin) {
		this.jumin = jumin;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
	
	
}
