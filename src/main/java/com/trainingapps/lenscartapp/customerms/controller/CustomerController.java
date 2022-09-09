package com.trainingapps.lenscartapp.customerms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trainingapps.lenscartapp.customerms.dto.AddCustomerRequest;
import com.trainingapps.lenscartapp.customerms.dto.LoginRequest;
import com.trainingapps.lenscartapp.customerms.entity.Customer;
import com.trainingapps.lenscartapp.customerms.exceptions.CustomerEmailAlreadyExistException;
import com.trainingapps.lenscartapp.customerms.exceptions.CustomerNotFoundException;
import com.trainingapps.lenscartapp.customerms.exceptions.WrongPasswordException;
import com.trainingapps.lenscartapp.customerms.exceptions.WrongUsernameAndPassword;
import com.trainingapps.lenscartapp.customerms.service.ICustomerService;


@RestController
@RequestMapping("/lenscart")
public class CustomerController {
	@Autowired
	private ICustomerService customerService;



	@PostMapping("/addCustomer")
	public Customer addCustomer(@Valid @RequestBody Customer customer)
			throws CustomerEmailAlreadyExistException {
		return customerService.addCustomer(customer);
		
	}



	@GetMapping("/byCustomerEmail/{email}")
	public Customer getCustomerByEmail(@PathVariable("email") String email)
			throws CustomerNotFoundException {
		return customerService.getCustomerByEmail(email);
	}



	@PostMapping("/customer/login")
	public Customer customerLogin(@RequestBody LoginRequest login)
			throws WrongPasswordException, WrongUsernameAndPassword
	{
		Customer customer1 = customerService.loginCustomer(login);
	    return customer1;
	}


	@GetMapping("/customer/logout")
	public ResponseEntity<String> logout(HttpSession session) {
		if (session.getAttribute("customer") != null) {
			session.invalidate();
			return new ResponseEntity<>("Logout Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("You are not logged in", HttpStatus.BAD_REQUEST);
		}
	}

	
	@PutMapping("/updateCustomer")
	public Customer updateCustomer(@Valid @RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
	}

	

	@DeleteMapping("/deleteCustomer/{customerId}")
	public List<Customer> deleteCustomer(@PathVariable("customerId") int customerId)
			throws CustomerNotFoundException {
		List<Customer> customerList = customerService.deleteCustomer(customerId);
		return customerList;
	}

	@GetMapping("/getCustomerById/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") int customerId)
			throws CustomerNotFoundException {
		return new ResponseEntity<Customer>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}

}