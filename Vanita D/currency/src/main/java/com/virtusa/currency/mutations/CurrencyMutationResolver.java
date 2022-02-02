package com.virtusa.currency.mutations;

import java.nio.charset.Charset;

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
		String inputString = currencyInput.getSymbol();
	    Charset charset = Charset.forName("ASCII");
				
		return this.currencyService.addCurrency(new Currency(0,
				currencyInput.getCountry(),
				currencyInput.getDescription(),
				Long.parseLong(currencyInput.getTradeable_flag()),
				inputString.getBytes(charset)));
	}
//	type Mutation {
//		   
//	    
//	    deleteCurrency(CurrencyId:Long):Boolean
//	}

//	public Boolean deleteCurrency(Long CurrencyId) {
//		return this.CurrencyService.deleteCurrencyById(CurrencyId);
//	}
}
	


