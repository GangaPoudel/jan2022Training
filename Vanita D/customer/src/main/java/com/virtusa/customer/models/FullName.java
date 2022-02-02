package com.virtusa.customer.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class FullName {
	
	@Column(name="First_Name",length = 50,nullable = false)
	private String firstName;
	
	@Column(name="last_Name",length = 50,nullable = false)
	private String lastName;
	
	@Column(name="Middle_Name",length = 50,nullable = true)
	private String middleName;
}