package com.trainingapps.lenscartapp.customerms.exceptions;

public class CustomerEmailAlreadyExistException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public CustomerEmailAlreadyExistException(String message) {
		super(message);
	}

}