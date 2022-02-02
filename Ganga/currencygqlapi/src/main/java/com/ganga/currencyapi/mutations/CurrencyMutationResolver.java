package com.ganga.currencyapi.mutations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.ganga.currencyapi.models.Currency;
import com.ganga.currencyapi.models.CurrencyInput;
import com.ganga.currencyapi.services.CurrencyService;

@Component
public class CurrencyMutationResolver implements GraphQLMutationResolver{
	@Autowired
	private CurrencyService currService;
	
	public Currency createCurrency(CurrencyInput currInput) {
		return this.currService.addCurrency(new Currency(currInput.getCountryName(),currInput.getCurrencyName(),currInput.getCurrencySymbol()));
	}
	
	public Currency updateCurrency(Currency currency) {
		return this.currService.updateCurrency(currency);
	}

}
