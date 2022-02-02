package com.ganga.currencyapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyInput {
	private String currencyName;
	private String currencySymbol;
	private String countryName;

}
