package com.virtusa.currencyapi.queries;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.virtusa.currencyapi.models.Currency;
import com.virtusa.currencyapi.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CurrencyQueryResolver implements GraphQLQueryResolver {

    @Autowired
    private CurrencyService currencyService;

    public List<Currency> findAllCurrencies() {
        return this.currencyService.getAllCurrencies();
    }

    public Currency findCurrencyById(long currencyId) {
        return this.currencyService.getCurrencyById(currencyId);
    }
}
