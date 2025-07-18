package com.jaladhi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jaladhi.entity.Customer;

@Service
public interface CustomerService {

	public List<Customer> getAllCustomers();

	public Customer getCustomer(int id);

	public Customer addCustomer(Customer customer);

	public Customer updateCustomer(Customer customer);
 
	public void deleteCustomer(int id);
	
}
