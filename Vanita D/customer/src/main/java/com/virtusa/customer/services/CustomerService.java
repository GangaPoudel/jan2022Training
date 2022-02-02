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
	private CustomerRepo cRepo;
	
	//insert 
	
	public Customer addCustomer(Customer customer) {
		return this.cRepo.save(customer);
	}
	
	//list all the customer
//	@Cacheable(value="Customer")
	public List<Customer> getAllCustomers(){
		return this.cRepo.findAll();
	}
	
	//list customer by Id
//	@Cacheable(value="Customer", key="#customerId")
	public Customer getCustomerById(long customerId) {
		return this.cRepo.findById(customerId).orElse(null);
	}
	
	//delete
//	@CacheEvict(value="Customer", key="#customerId")
	public boolean deleteCustomerById(long customerId) {
		boolean status=false;
		this.cRepo.deleteById(customerId);
		if(this.getCustomerById(customerId)==null)
			status=true;
		return status;
	}
	
	//update
//	@CachePut(value="Customer", key="#customerId")
	public Customer updateCustomer(Long customerId, String phonenumber) {
		Customer customer=this.getCustomerById(customerId);
		if(customer!=null) {
			customer.setPhoneNumber(phonenumber);
		}
		
		return this.cRepo.save(customer);
	}
}
