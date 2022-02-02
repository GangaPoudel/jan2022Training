package com.virtusa.customer.queries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.virtusa.customer.models.Customer;
import com.virtusa.customer.services.CustomerService;


@Component
public class CustomerQueryResolver implements GraphQLQueryResolver{
	@Autowired
	private CustomerService customerService;
	
	public List<Customer> findAllCustomers(){
		return this.customerService.getAllCustomers();
	}
	
	public Customer findCustomer(long customerId) {
	
		return this.customerService.getCustomerById(customerId);
	}
}
