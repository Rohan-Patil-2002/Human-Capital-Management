package com.rohan.HCMS;

public class LoginRequest {
    private String email;
    private String empPass;

	public LoginRequest(String email, String empPass) {
		this.email = email;
		this.empPass = empPass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getEmpPass() {
		return empPass;
	}

	public void setEmpPass(String empPass) {
		this.empPass = empPass;
	}

	@Override
	public String toString() {
		return "LoginRequest [email=" + email + ", empPass=" + empPass + "]";
	}



}

