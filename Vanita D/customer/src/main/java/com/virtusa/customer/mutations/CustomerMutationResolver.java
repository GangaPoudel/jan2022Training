package com.virtusa.customer.mutations;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.virtusa.customer.models.Address;
import com.virtusa.customer.models.Customer;
import com.virtusa.customer.models.CustomerInput;
import com.virtusa.customer.models.FullName;
import com.virtusa.customer.services.CustomerService;


@Component
public class CustomerMutationResolver implements GraphQLMutationResolver{
	@Autowired
	private CustomerService customerService;
	


	public Customer createCustomer(CustomerInput customerInput) {
//		return this.customerService.addCustomer(new Customer(0,
//				new FullName(customerInput.getName().getFirstName(),customerInput.getName().getLastName(),customerInput.getName().getMiddleName()),
//				new Address(customerInput.getAddress().getRoadName(),customerInput.getAddress().getCity(),customerInput.getAddress().getCountry(),customerInput.getAddress().getZipCode()),
//				customerInput.getPhoneNumber(),
//				customerInput.getEmail(),
//				LocalDate.parse(customerInput.getDob())));
//		 createCustomer(customerInput:CustomerInput):Customer
				
		return this.customerService.addCustomer(new Customer(0,
				new FullName(customerInput.getName().getFirstName(),customerInput.getName().getLastName(),customerInput.getName().getMiddleName()),
				new Address(customerInput.getAddress().getRoadName(),customerInput.getAddress().getCity(),customerInput.getAddress().getCountry(),customerInput.getAddress().getZipCode()),
				customerInput.getPhoneNumber(),
				customerInput.getEmail(),
				LocalDate.parse(customerInput.getDob())));
	}
//	type Mutation {
//		   
//	    
//	    deleteCustomer(customerId:Long):Boolean
//	}

	public Boolean deleteCustomer(Long customerId) {
		return this.customerService.deleteCustomerById(customerId);
	}
}
	


