package com.virtusa.customer.models;




import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Customer")
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(hidden=true)
	@Column(name="Customer_Id")
	private long customerId;
	
	@Embedded
	private FullName name;
	@Embedded
	private Address address;
	
	@Column(name="Phone_Number", length = 50,nullable = false)
	private String phoneNumber;
	
	@Column(name="Email", length = 50,nullable = false)
	private String email;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name="DOB")
	private LocalDate dob;
	

}
