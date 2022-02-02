package com.virtusa.currency.queries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.virtusa.currency.models.Currency;
import com.virtusa.currency.services.CurrencyService;

@Component
public class CurrencyQueryResolver implements GraphQLQueryResolver{
	@Autowired
	private CurrencyService currencyService;
	
	public List<Currency> findAllCurrencies() {
		return this.currencyService.getAllCurrency();
	}
	
	public Currency findCurrency(long currencyCode) {
		return this.currencyService.getCurrencyById(currencyCode);
	}
}
