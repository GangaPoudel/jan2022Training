package com.virtusa.customerapi.controllers;

import com.virtusa.customerapi.models.Customer;
import com.virtusa.customerapi.services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.bohnman.squiggly.Squiggly;
import com.github.bohnman.squiggly.util.SquigglyUtils;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RefreshScope
@Slf4j
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Value(("${newmessage}"))
    private String message;

    //get
    @GetMapping(value="/",params="version=1.0")
    public List<Customer> getAllCustomers() {
        log.info("Message: " + message);
        return this.customerService.getAllCustomers();
    }

    @GetMapping(value="/{customerId}",params = "version=1.0")
    public ResponseEntity<?> getCusomterById(@PathVariable("customerId") long customerId){
        Customer customerObj=this.customerService.getCustomerById(customerId);
        if(customerObj!=null)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerObj);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer Not Found");
    }

    //post
    @PostMapping(value = "/",params="version=1.0")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
        Customer customerObj=this.customerService.addCustomer(customer);
        if(customerObj!=null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerObj);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer Not Created");
        }
    }

    //put
    @PutMapping(value="/{customerId}/{customerEmail}",params = "version=1.0")
    public ResponseEntity<?> updateCustomer(@PathVariable("customerId") long customerId, @PathVariable("customerEmail") String customerEmail){
        Customer customerObj=this.customerService.updateCustomer(customerId, customerEmail);
        if(customerObj!=null)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerObj);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer Not Created");
    }

    //delete
    @DeleteMapping(value="{customerId}",params="version=1.0")
    public ResponseEntity<?> deleteCustomerById(@PathVariable("customerId") long customerId) {
        if(this.customerService.deleteCustomerById(customerId)) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Customer with id "+customerId+" deleted");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer Not Found");
        }
    }



}