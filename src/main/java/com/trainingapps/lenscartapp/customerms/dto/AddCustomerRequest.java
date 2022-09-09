package com.trainingapps.lenscartapp.customerms.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class AddCustomerRequest
{
  
	@NotEmpty(message = "CustomerName should not be Empty")
	@Column(name = "customerName")
	private String customerName;

	@Email
	@Column(name="email",unique=true,nullable=false)
	private String email;

	@Column(name = "number")
	private String number;


	@Column(name = "password")
	private String password;

	@Column(name = "address")
	@NotBlank(message = "Customer address should not be blank")
	private String address;

	@Column(name = "role")
	@NotBlank(message = "Role should not be blank")
	private String role="customer";

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public AddCustomerRequest()
	{
		
	}
	
}
