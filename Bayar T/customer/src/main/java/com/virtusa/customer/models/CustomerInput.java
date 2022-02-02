package com.virtusa.customer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerInput {
	private long balance;
	private String name;
	private String email;
	private String dob;

}
