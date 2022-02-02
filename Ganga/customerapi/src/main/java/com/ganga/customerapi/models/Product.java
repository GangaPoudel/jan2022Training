package com.ganga.customerapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name ="Product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProductId", length = 50, nullable = false)
	private long productId;
	@Column(name = "ProductName", length = 50, nullable = false)
	private String name;
	@Column(name = "ProductPrice", length = 50, nullable = false)
	private double price;

}
