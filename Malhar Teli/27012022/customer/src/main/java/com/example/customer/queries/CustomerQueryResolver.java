package com.example.customer.queries;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.customer.models.Customer;
import com.example.customer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class CustomerQueryResolver implements GraphQLQueryResolver {
    @Autowired
    private CustomerService customerService;

    public List<Customer> findAllCustomers(){return this.customerService.getAllCustomers();}

    public Customer findCustomerById(long customerId){
        return this.customerService.getCustomerById(customerId);
    }
}
