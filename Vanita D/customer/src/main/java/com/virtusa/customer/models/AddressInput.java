package com.virtusa.customer.models;






import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressInput {
	
	
	private String roadName;
	
	
	private String city;
	
	
	private String country;
	
	
	private String zipCode;
	
}
