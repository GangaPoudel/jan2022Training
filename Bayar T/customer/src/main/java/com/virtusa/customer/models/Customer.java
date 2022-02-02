package com.virtusa.customer.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Customer")
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(hidden = true)
	@Column(name = "Customer_Id")
	private long customerId;
	
	@Column(name = "Balance")
	private long balance;
	
	@Column(name = "Name",length = 50,nullable = false)
	private String name;
	
	@Column(name = "Email")
	private String email;
	
	//@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name = "Dob")
	private String dob;

}
