package com.customerApi.customer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customerApi.customer.models.Customer;
import com.customerApi.customer.repositories.CustomerRepo;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepo customerrepo;
	
	//insert 
	
	public Customer addCustomer(Customer customer) {
		return this.customerrepo.save(customer);
	}
	
	//list all the banks
	
	public List<Customer> getAllCustomers(){
		return this.customerrepo.findAll();
	}
	
	//list bank by Id
	
	public Customer getCustomerById(long customerId) {
		return this.customerrepo.findById(customerId).orElse(null);
	}
	
	//delete

		public boolean deleteCustomerById(long customerId) {
			boolean status=false;
			this.customerrepo.deleteById(customerId);
			if(this.getCustomerById(customerId)==null)
				status=true;
			return status;
		}
		
		//update
		
		public Customer updateCustomer(long customerId,String address) {
			
			Customer customer=this.getCustomerById(customerId);
			if(customer!=null) {
				customer.setAddress(address);
			}
			
			return this.customerrepo.save(customer);
		}
	


}
