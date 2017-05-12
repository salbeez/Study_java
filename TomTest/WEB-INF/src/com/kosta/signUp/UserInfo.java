package com.kosta.signUp;

public class UserInfo {
	private String id;
	private String pw;
	private String name;
	private String jumin;
	private String birth;
	private String zip;
	private String adrr;
	private String eMail;
	private String job;

	public UserInfo() {
	}

	public UserInfo(String id, String pw, String name, String jumin, String birth, String zip, String adrr,
			String eMail, String job) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.jumin = jumin;
		this.birth = birth;
		this.zip = zip;
		this.adrr = adrr;
		this.eMail = eMail;
		this.job = job;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
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

	public String getAdrr() {
		return adrr;
	}

	public void setAdrr(String adrr) {
		this.adrr = adrr;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

}
