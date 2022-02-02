package com.virtusa.creationdesignpattern.builder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//I dont want to set all parameter
//I should know the sequence of parameter when creating a new customer
//In builder we are setting the value, and getting the same instance back
//while creating customer this way, sequence of parameter is not important
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	private String name;
	private String address;
	private String age;
	private String email;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setAge(String age) {
		this.age = age;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void printDetails() {
		System.out.println("Name: " + this.name  + ", Age " +this.age +  ", Email " + this.email + ", Address " + this.address);
		
	}
	
}
