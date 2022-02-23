package com.currency.currencyapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Currency")
public class Currency {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Currency_code")
	private long currencycode;
	@Column(name = "Country",length=50,nullable=false)
	private String country;
	@Column(name = "Symbol",columnDefinition="mediumblob")
	private byte[]  CurrencyImage;
	@Column(name = "Tradable_Flag",length=10,nullable=false)
	private long tradableflag;
	@Column(name = "Description",length = 50,nullable=false)
	private String description;
	

}
