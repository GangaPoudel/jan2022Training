package com.virtusa.customer.models;







import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerInput {
	
	private FullNameInput name;
	private AddressInput address;
	private String phoneNumber;
	private String email;
	private String dob;
}
