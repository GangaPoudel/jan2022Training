package com.virtusa.customer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.customer.models.Customer;
import com.virtusa.customer.services.CustomerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/customers")
@RefreshScope
@Slf4j
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Value("${newmessage}")
	private String message;
	
	@PostMapping(value="/",params = "version=1.0")
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
		Customer customerObj = this.customerService.addCustomer(customer);
		if(customerObj != null) 
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer Not Created");
	}
	
	@GetMapping(value="/",params = "version=1.0")
	public List<Customer> getAllCustomers() {
		log.info("Message"+message);
		return this.customerService.getAllCustomers();
	}
	
	@GetMapping(value="/{customerId}", params = "version=1.0")
	public ResponseEntity<?> getCustomerById(@PathVariable("customerId") long customerId) {
		Customer customerObj = this.customerService.getCustomerById(customerId);
		if(customerObj != null)
			return  ResponseEntity.status(HttpStatus.ACCEPTED).body(customerObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer does not exist");
	}
	
	@PutMapping(value="/{customerId}/{name}",params = "version=1.0")
	public ResponseEntity<?> updateCustomer(@PathVariable("customerId") long customerId, @PathVariable("name") String name){
		Customer customerObj=this.customerService.updateCustomer(customerId, name);
		if(customerObj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer Not Created");
		
	}
	
	@DeleteMapping(value="/{customerId}",params = "version=1.0")
	public ResponseEntity<?> deleteCustomerById(@PathVariable("customerId") long customerId){
		if(this.customerService.deleteCustomerById(customerId))
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Customer with "+customerId+"Deleted");
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer Not Found");
		
	}
}
