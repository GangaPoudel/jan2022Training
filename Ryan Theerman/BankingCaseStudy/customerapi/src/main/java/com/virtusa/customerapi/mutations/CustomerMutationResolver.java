package com.virtusa.customerapi.mutations;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.virtusa.customerapi.models.Customer;
import com.virtusa.customerapi.models.CustomerInput;
import com.virtusa.customerapi.models.FullName;
import com.virtusa.customerapi.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerMutationResolver implements GraphQLMutationResolver{
	@Autowired
	private CustomerService customerService;
	
	public Customer createCustomer(CustomerInput customerInput) {
		return this.customerService.addCustomer(new Customer(
				customerInput.getCustomerName(),
				customerInput.getCustomerAddress(),
				customerInput.getCustomerCountry(),
				customerInput.getCustomerZip(),
				customerInput.getCustomerState(),
				customerInput.getCustomerPhone(),
				customerInput.getCustomerEmail(),
				customerInput.getDob()));
	}

	public Customer updateCustomer(long customerId, String customerEmail) {
		return this.customerService.updateCustomer(customerId, customerEmail);
	}

	public Boolean deleteCustomer(Long customerId) {
		return this.customerService.deleteCustomerById(customerId);
	}

}
