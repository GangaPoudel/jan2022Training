package com.virtusa.currency.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyInput {
	private String country;
	private Boolean tradeableFlag;
	private String description;
	private String image;
}
