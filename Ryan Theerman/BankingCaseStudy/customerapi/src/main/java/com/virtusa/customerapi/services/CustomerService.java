package com.virtusa.customerapi.services;

import com.virtusa.customerapi.models.Customer;
import com.virtusa.customerapi.models.FullName;
import com.virtusa.customerapi.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    //insert
    public Customer addCustomer(Customer customer) {
        this.customerRepo.save(customer);
        return customer;
    }
//    @Cacheable(value="Customer")
    //list all customers
    public List<Customer> getAllCustomers() {
        return this.customerRepo.findAll();
    }

//    @Cacheable(value="Customer", key="#customerId")
    //list customer by id
    public Customer getCustomerById(long customerId) {
        return this.customerRepo.findById(customerId).orElse(null);
    }

//    @CacheEvict(value="Customer", key="#customerId")
    //delete
    public boolean deleteCustomerById(long customerId) {
        boolean status = false;
        this.customerRepo.deleteById(customerId);
        if(this.getCustomerById(customerId)==null) {
            status = true;
        }
        return status;
    }

//    @CachePut(value="Customer", key="#customerId")
    //update
    public Customer updateCustomer(long customerId, String customerEmail) {

        Customer customer=this.getCustomerById(customerId);
        if(customer!=null) {
            customer.setCustomerEmail(customerEmail);
        }
        return this.customerRepo.save(customer);
    }

//    @CacheEvict(value="Customer", key="#customerId")
    public Boolean deleteCustomer(Long customerId) {
        Customer customer=this.getCustomerById(customerId);
        if(customer!=null) {
            this.customerRepo.deleteById(customerId);
            return true;
        } else {
            return false;
        }
    }

}
