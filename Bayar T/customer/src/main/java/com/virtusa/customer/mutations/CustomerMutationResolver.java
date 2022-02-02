package com.virtusa.customer.mutations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.virtusa.customer.models.Customer;
import com.virtusa.customer.models.CustomerInput;
import com.virtusa.customer.services.CustomerService;

@Component
public class CustomerMutationResolver implements GraphQLMutationResolver{
	@Autowired
	private CustomerService customerService;
	
	public Customer createCustomer(CustomerInput customerInput) {
		return this.customerService.addCustomer(new Customer(0, 
				customerInput.getBalance(), 
				customerInput.getName(), 
				customerInput.getEmail(), 
				customerInput.getDob()));
	}
	
	public Customer updateCustomer(long customerId, String name) {
		return this.customerService.updateCustomer(customerId, name);
	}

}
