package com.virtusa.customerapi.mutations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import com.virtusa.customerapi.models.Customer;
import com.virtusa.customerapi.models.CustomerInput;

import com.virtusa.customerapi.services.CustomerService;

@Component
public class CustomerMutationResolver implements GraphQLMutationResolver{
	@Autowired
	private CustomerService customerService;
	
	public Customer createCustomer(CustomerInput customerInput) {
		return this.customerService.addCustomer(new Customer(0,customerInput.getName(),customerInput.getEmail(),customerInput.getDob(),customerInput.getAddress()));
	}
	
	public Customer updateCustomer(long customerId,String address) {
		return this.customerService.updateCustomer(customerId, address);
	}
    public boolean deleteCustomerbyId(long customerId) {
    	return this.customerService.deleteCustomerById(customerId);
    }
}
