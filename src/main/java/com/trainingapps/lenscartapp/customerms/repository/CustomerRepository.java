package com.trainingapps.lenscartapp.customerms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trainingapps.lenscartapp.customerms.entity.Customer;



@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	public Customer findByCustomerName(String customerName);

	public Customer findByEmail(String email);

}
