package com.virtusa.customer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.virtusa.customer.models.Customer;
import com.virtusa.customer.repositories.CustomerRepo;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	public Customer addCustomer(Customer customer) {
		return this.customerRepo.save(customer);
	}
	//@Cacheable(value="Customer")
	public List<Customer> getAllCustomers() {
		return this.customerRepo.findAll();
	}
	
	//@Cacheable(value="Customer", key="#customerId")
	public Customer getCustomerById(long customerId) {
		return this.customerRepo.findById(customerId).orElse(null);
	}
	
	//@CacheEvict(value="Customer", key="#customerId")
	public boolean deleteCustomerById(long customerId) {
		boolean status = false;
		this.customerRepo.deleteById(customerId);
		if(this.getCustomerById(customerId) == null)
			status = true;
		return status;
	}
	
	//@CachePut(value="Customer", key="#customerId")
	public Customer updateCustomer(long customerId, String customerName) {
		Customer customer = this.getCustomerById(customerId);
		if(customer != null) {
			customer.setName(customerName);
		}
		return this.customerRepo.save(customer);

	}

}
