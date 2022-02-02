package com.virtusa.customerapi.queries;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.virtusa.customerapi.models.Customer;
import com.virtusa.customerapi.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerQueryResolver implements GraphQLQueryResolver {

    @Autowired
    private CustomerService customerService;

    public List<Customer> findAllCustomers() {
        return this.customerService.getAllCustomers();
    }

    public Customer findCustomerById(long customerId) {
        return this.customerService.getCustomerById(customerId);
    }
}
