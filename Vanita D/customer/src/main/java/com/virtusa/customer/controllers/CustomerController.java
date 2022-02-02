package com.virtusa.customer.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.bohnman.squiggly.Squiggly;
import com.github.bohnman.squiggly.util.SquigglyUtils;
import com.virtusa.customer.models.Customer;
import com.virtusa.customer.services.CustomerService;



@RestController
@RequestMapping("/customers")
@RefreshScope
public class CustomerController {
	@Autowired
	private CustomerService cService;
	
	//post
	@PostMapping(value = "/", params = "version=1.0")
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
		Customer customerObj = this.cService.addCustomer(customer);
		if(customerObj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("customer Not Created");
	}
	//get//why are we not returning responseentity?
	@GetMapping(value="/",params = "version=1.0")
	public List<Customer> getAllCustomer(){
		return this.cService.getAllCustomers();
	}
	
	//get with id
	
	@GetMapping(value="/{customerId}",params = "version=1.0")
	public ResponseEntity<?> getCustomerById(@PathVariable("customerId") long customerId){
		Customer customerObj=this.cService.getCustomerById(customerId);
		if(customerObj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("customer Not Found");
		
	}
	@PutMapping(value="/{customerId}/{phonenumber}",params = "version=1.0")
	public ResponseEntity<?> updateCustomer(@PathVariable("customerId") long customerId,@PathVariable("phonenumber") String phonenumber){
		Customer customerObj = this.cService.updateCustomer(customerId, phonenumber);
		if(customerObj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer not updated");
		
	}
	
	
	//delete
	
	@DeleteMapping(value="/{customerId}",params = "version=1.0")
	public ResponseEntity<?> deleteCustomerById(@PathVariable("customerId") long customerId){
	
		if(this.cService.deleteCustomerById(customerId))
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Bank with "+customerId+" Deleted");
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer Not Found");
		
	}
	
	@GetMapping(value ="/filters/{customerId}", params="version=1.0")
	public ResponseEntity<?> getCustomerByFields(@PathVariable("customerId") Long customerId, @RequestParam(name = "fields" , required = false) String fields){
		Map<Object, Object> model = new HashMap<>();
		Customer customer = this.cService.getCustomerById(customerId);
		if ( customer != null ) {
			ObjectMapper mapper = Squiggly.init(new ObjectMapper(), fields);
			return ResponseEntity.ok(SquigglyUtils.stringify(mapper, customer));
		} else {
			return ResponseEntity.ok(model.put("Message", "customer  not found"));
		}
	}
		
}
