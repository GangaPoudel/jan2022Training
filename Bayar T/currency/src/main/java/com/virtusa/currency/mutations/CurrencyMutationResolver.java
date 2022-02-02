package com.virtusa.currency.mutations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.virtusa.currency.models.Currency;
import com.virtusa.currency.models.CurrencyInput;
import com.virtusa.currency.services.CurrencyService;

@Component
public class CurrencyMutationResolver implements GraphQLMutationResolver{
	@Autowired
	private CurrencyService currencyService;
	
	public Currency createCurrency(CurrencyInput currencyInput) {
		return this.currencyService.addCurrency(new Currency(0, 
				currencyInput.getCountry(), 
				currencyInput.getTradeableFlag(), 
				currencyInput.getDescription(), 
				currencyInput.getImage()));
	}
	
	public Currency updateCurrency(long currencyCode, String country) {
		return this.currencyService.updateCurrency(currencyCode, country);
	}
}
