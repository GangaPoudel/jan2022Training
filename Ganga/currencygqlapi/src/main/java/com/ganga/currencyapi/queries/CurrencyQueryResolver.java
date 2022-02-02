package com.ganga.currencyapi.queries;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.ganga.currencyapi.models.Currency;
import com.ganga.currencyapi.services.CurrencyService;

@Component
public class CurrencyQueryResolver implements GraphQLQueryResolver {
	@Autowired
	private CurrencyService currService;

	public List<Currency> findAllCurrency() {
		return this.currService.getAllCurrency();
	}

	public Currency findCurrency(long id) {

		return this.currService.getCurrencyById(id);
	}

}
