package com.spring.study.model;

@SuppressWarnings("serial")
public class Users extends BaseModel {
	String email;
	String pw;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
}
