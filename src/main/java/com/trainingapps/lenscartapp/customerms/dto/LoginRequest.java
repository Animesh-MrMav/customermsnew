package com.trainingapps.lenscartapp.customerms.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;


public class LoginRequest
{
	@Email
	@Column(name="email",unique=true,nullable=false)
	private String email;
	
	@Column(name = "password")
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginRequest()
	{
		
	}
	
	
	
}
