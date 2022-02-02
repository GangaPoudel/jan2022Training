package com.virtusa.customerapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.virtusa.customerapi.models.Customer;
import com.virtusa.customerapi.services.CustomerService;



@RestController
@RequestMapping("/customer")
public class CustomerController {
	
@Autowired
private CustomerService customerService;
	//post
	@PostMapping(value="/",params = "version=1.0")
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
		Customer customerObj=this.customerService.addCustomer(customer);
		if(customerObj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer Not Created");
	}
	
	//get
	
	@GetMapping(value="/",params = "version=1.0")
	public List<Customer> getAllCustomers(){
		return this.customerService.getAllCustomers();
	}
	
	//get by id
	
	@GetMapping(value="/{customerId}",params = "version=1.0")
	public ResponseEntity<?> getCustomerById(@PathVariable("customerId") long customerId){
		Customer customerObj=this.customerService.getCustomerById(customerId);
		if(customerObj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("customer Not Found");
		
	}
	
	
	//put
	
	@PutMapping(value="/{customerId}/{address}",params = "version=1.0")
	public ResponseEntity<?> updateCustomer(@PathVariable("customerId") long customerId,@PathVariable("address") String address){
		Customer customerObj=this.customerService.updateCustomer(customerId,address);
		if(customerObj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer Not Created");
		
	}
	
	//delete
	
	@DeleteMapping(value="/{customerId}",params = "version=1.0")
	public ResponseEntity<?> deleteCustomerById(@PathVariable("customerId") long customerId){
	
		if(this.customerService.deleteCustomerById(customerId))
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Customer with "+customerId+"Deleted");
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer Not Found");
	}
}
