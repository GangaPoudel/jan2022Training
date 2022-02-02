package com.example.customer.mutations;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.customer.models.Address;
import com.example.customer.models.Customer;
import com.example.customer.models.CustomerInput;
import com.example.customer.models.FullName;
import com.example.customer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerMutationResolver implements GraphQLMutationResolver {
    @Autowired
    private CustomerService customerService;

    public Customer createCustomer(CustomerInput customerInput){
        FullName fullName= new FullName(customerInput.getFirstName(), customerInput.getLastName(), customerInput.getMiddleName());
        Address address = new Address(customerInput.getStreetAddress(), customerInput.getCity(), customerInput.getState(), customerInput.getCountry(), customerInput.getZip());
        return this.customerService.addCustomer(new Customer(
                0,
                fullName,
                address,
                customerInput.getEmail(),
                customerInput.getPhone(),
                customerInput.getStatus()
        ));
    }

    public Customer updateCustomer(long customerId, CustomerInput customerInput){
        Customer otherCustomer = this.createCustomer(customerInput);
        return this.customerService.updateCustomer(customerId, otherCustomer);
    }

    public Boolean deleteCustomer(long customerId){
        return this.customerService.deleteCustomerById(customerId);
    }
}
