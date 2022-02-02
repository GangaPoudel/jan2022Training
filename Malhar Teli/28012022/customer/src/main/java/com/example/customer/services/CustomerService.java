package com.example.customer.services;

import com.example.customer.models.Customer;
import com.example.customer.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    //insert
    public Customer addCustomer(Customer customer){
        return this.customerRepo.save(customer);
    }
    //update
    public Customer updateCustomer(long customerId, Customer customer){
        Customer customerObj = this.getCustomerById(customerId);
        if (customerObj!=null){

        }
        return this.customerRepo.save(customer);
    }

    //List all
    public List<Customer> getAllCustomers(){
        return this.customerRepo.findAll();
    }

    public Customer getCustomerById(long customerId){
        return this.customerRepo.findById(customerId).orElse(null);
    }

    public boolean deleteCustomerById(long customerId){
        this.customerRepo.deleteById(customerId);
        return (this.getCustomerById(customerId)==null);
    }
}
