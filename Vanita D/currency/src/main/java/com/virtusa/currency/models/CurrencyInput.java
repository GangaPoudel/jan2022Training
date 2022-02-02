package com.virtusa.currency.models;



import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyInput implements Serializable {
	
	private String country;
	
	
	private String description;
	
	
	private String tradeable_flag;
	
	//https://www.pixeltrice.com/image-gallery-spring-boot-application-using-mysql-and-thymeleaf/
	//@Lob annotation is used for storing large objects to the database such as byte array or large string. In our case, we are storing the image in the form of a byte array.
//	@Lob it should return type byte[] , for now I am returning string
    
    private String symbol;
}
