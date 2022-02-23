package com.customerApi.customer.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name = "Customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Customer_Id")
	private long customerid;
	@Column(name="Customer_Name",length=50,nullable=false)
	private String customername;
	@Column(name="Address",length=50,nullable=false)
	private String address;
	@Column(name="Country",length=50,nullable=false)
	private String country;
	@Column(name="Bank_Details",length=100,nullable=false)
	private String bankdeatils;

}
