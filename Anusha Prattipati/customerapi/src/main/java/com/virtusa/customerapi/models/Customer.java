package com.virtusa.customerapi.models;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

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
		@Column(name="Customer_Id")
		private long customerId;
	  // @Column(name = "Name",length = 150,nullable = false)
		//value object
	   @Embedded
		private FullName name;
		
		@Column(name="Email")
		private String email;
		@Column(name="DOB")
		private String dob;
		@Column(name="Address",length = 150,nullable = false)
		private String address;
		

	}


