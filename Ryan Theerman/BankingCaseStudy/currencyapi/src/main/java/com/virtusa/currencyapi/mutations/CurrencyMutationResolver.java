package com.virtusa.currencyapi.mutations;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.virtusa.currencyapi.models.Currency;
import com.virtusa.currencyapi.models.CurrencyInput;
import com.virtusa.currencyapi.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CurrencyMutationResolver implements GraphQLMutationResolver{
	@Autowired
	private CurrencyService currencyService;
	
	public Currency createCurrency(CurrencyInput currencyInput) {
		return this.currencyService.addCurrency(new Currency(
				currencyInput.getCountry(),
				currencyInput.getCurrencySymbol(),
				currencyInput.getTradableFlag(),
				currencyInput.getDescription()));
	}

	public Currency updateCurrency(long currencyId, int tradableFlag) {
		return this.currencyService.updateCurrency(currencyId, tradableFlag);
	}

	public Boolean deleteCurrency(Long currencyId) {
		return this.currencyService.deleteCurrencyById(currencyId);
	}

}
