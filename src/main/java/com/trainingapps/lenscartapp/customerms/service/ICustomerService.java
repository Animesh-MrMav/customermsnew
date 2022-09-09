package com.trainingapps.lenscartapp.customerms.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.trainingapps.lenscartapp.customerms.dto.AddCustomerRequest;
import com.trainingapps.lenscartapp.customerms.dto.LoginRequest;
import com.trainingapps.lenscartapp.customerms.entity.Customer;
import com.trainingapps.lenscartapp.customerms.exceptions.CustomerEmailAlreadyExistException;
import com.trainingapps.lenscartapp.customerms.exceptions.CustomerNotFoundException;
import com.trainingapps.lenscartapp.customerms.exceptions.WrongPasswordException;
import com.trainingapps.lenscartapp.customerms.exceptions.WrongUsernameAndPassword;

@Validated
public interface ICustomerService {

	public Customer addCustomer(@Valid Customer customer) throws CustomerEmailAlreadyExistException;

	public Customer loginCustomer(@Valid LoginRequest login) throws WrongPasswordException, WrongUsernameAndPassword;

	public Customer updateCustomer(@Valid Customer customer);

	public Customer getCustomerById(int customerId) throws CustomerNotFoundException;
	
	public Customer getCustomerByEmail(String email) throws CustomerNotFoundException;

	public List<Customer> deleteCustomer(int customerId) throws CustomerNotFoundException;
	
	public List<Customer> findAll() ;

}