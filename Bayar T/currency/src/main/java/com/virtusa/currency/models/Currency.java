package com.virtusa.currency.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Currency")
@AllArgsConstructor
@NoArgsConstructor
public class Currency {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(hidden = true)
	@Column(name="Currency_Code")
	private long currencyCode;
	
	@Column(name = "Country")
	private String country;
	
	@Column(name = "Tradeable_Flag")
	private Boolean tradeableFlag;
	
	@Column(name = "Description")
	private String description;

	//@Lob
	@Column(name = "Image")
	private String image;
}
