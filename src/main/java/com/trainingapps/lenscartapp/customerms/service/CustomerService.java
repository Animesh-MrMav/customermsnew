package com.trainingapps.lenscartapp.customerms.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainingapps.lenscartapp.customerms.dto.AddCustomerRequest;
import com.trainingapps.lenscartapp.customerms.dto.LoginRequest;
import com.trainingapps.lenscartapp.customerms.entity.Customer;
import com.trainingapps.lenscartapp.customerms.exceptions.CustomerEmailAlreadyExistException;
import com.trainingapps.lenscartapp.customerms.exceptions.CustomerNotFoundException;
import com.trainingapps.lenscartapp.customerms.exceptions.WrongPasswordException;
import com.trainingapps.lenscartapp.customerms.exceptions.WrongUsernameAndPassword;
import com.trainingapps.lenscartapp.customerms.repository.CustomerRepository;


@Transactional
@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public Customer addCustomer(@Valid Customer customer) throws CustomerEmailAlreadyExistException {

		Customer customer1 = customerRepo.findByEmail(customer.getEmail());
		if (customer1 != null) {
			throw new CustomerEmailAlreadyExistException("CustomerName already exist");
		} else {
			/*Customer c1=new Customer();
			c1.setCustomerName(customer.getCustomerName());
			c1.setEmail(customer.getEmail());
			c1.setNumber(customer.getNumber());
			c1.setPassword(customer.getPassword());
			c1.setAddress(customer.getAddress());
			c1.setRole(customer.getRole());
			c1=customerRepo.save(c1); */
			
			return customerRepo.save(customer);
		}
	}

	@Override
	public Customer getCustomerByEmail(@Email String email) throws CustomerNotFoundException {

		Customer customer = customerRepo.findByEmail(email);
		if (customer != null) {
			return customer;
		} else {
			throw new CustomerNotFoundException("No Such Customer Exist");
		}
	}

	public Customer loginCustomer(@Valid LoginRequest login) throws WrongPasswordException, WrongUsernameAndPassword {
		Customer customer1 = customerRepo.findByEmail(login.getEmail());
		if (customer1 != null) {
			if (login.getPassword().equals(customer1.getPassword())) {
				return customer1;
			} else {
				throw new WrongPasswordException("Wrong Password");
			}
		} else {
			throw new WrongUsernameAndPassword("Wrong USername or Password");
		}
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	@Override
	public Customer getCustomerById(int customerId) throws CustomerNotFoundException {
		try {
			Customer customer = customerRepo.findById(customerId).get();
			return customer;
		} catch (Exception e) {
			throw new CustomerNotFoundException("Id is not present, enter correct Id");
		}
	}

	@Override
	public List<Customer> deleteCustomer(int customerId) throws CustomerNotFoundException {
		try {
			customerRepo.deleteById(customerId);
			return customerRepo.findAll();
		} catch (Exception e) {
			throw new CustomerNotFoundException("Id is not present, enter correct Id");
		}
	}
	
	public List<Customer> findAll()
	{
		return customerRepo.findAll();
	}
	

}