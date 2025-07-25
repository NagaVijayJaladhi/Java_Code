package com.jaladhi.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jaladhi.dao.CustomerDao;
import com.jaladhi.entity.Customer;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
 
	@Autowired
	CustomerDao customerDao;
 
	@Transactional
	public List<Customer> getAllCustomers() {
		return customerDao.getAllCustomers();
	}
 
	@Transactional
	public Customer getCustomer(int id) {
		return customerDao.getCustomer(id);
	}
 
	@Transactional
	public Customer addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
		return customer;
	}
 
	@Transactional
	public Customer updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
		return customer;
	}
 
	@Transactional
	public void deleteCustomer(int id) {
		customerDao.deleteCustomer(id);
	}
}
