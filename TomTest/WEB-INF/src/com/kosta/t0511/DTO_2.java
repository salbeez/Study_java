package com.kosta.t0511;

public class DTO_2 {
	private String id;
	private String pw;

	public DTO_2() {
	}

	public DTO_2(String id, String pw) {
		this.id = id;
		this.pw = pw;
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

	@Override
	public String toString() {
		return "DTO_2 [id=" + id + ", pw=" + pw + "]";
	}

}
