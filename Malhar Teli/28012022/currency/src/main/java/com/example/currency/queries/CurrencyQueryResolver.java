package com.example.currency.queries;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.currency.models.Currency;
import com.example.currency.services.CurrencyService;
import com.example.currency.utilities.BlobHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CurrencyQueryResolver implements GraphQLQueryResolver {
    @Autowired
    private CurrencyService currencyService;
    BlobHandler blobHandler = new BlobHandler();



    public List<Currency> getAllCurrency(){
        List<Currency> currencyList=  this.currencyService.getAllCurrency();
        return currencyList;
    }

    public Currency getCurrencyById(long currencyId){
        return this.currencyService.getCurrencyById(currencyId);
    }
}
