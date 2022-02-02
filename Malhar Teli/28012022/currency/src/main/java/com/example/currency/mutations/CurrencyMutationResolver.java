package com.example.currency.mutations;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.currency.models.Currency;
import com.example.currency.models.CurrencyInput;
import com.example.currency.queries.CurrencyQueryResolver;
import com.example.currency.services.CurrencyService;
import com.example.currency.utilities.BlobHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CurrencyMutationResolver implements GraphQLMutationResolver {
    @Autowired
    private CurrencyService currencyService;
            private CurrencyQueryResolver queryResolver;
BlobHandler blobHandler = new BlobHandler();

    public Currency createCurrency(CurrencyInput currencyInput){
        byte[] byteObj = blobHandler.stringToBlob(currencyInput.getSymbol());
        Currency currencyObj = new Currency(0, currencyInput.getCurrencyCode(), currencyInput.getCountry(), byteObj, currencyInput.getTradableFlag().longValue(), currencyInput.getDescription());
        return this.currencyService.addCurrency(currencyObj);
    }
    public Currency updateCurrency(long currencyId, CurrencyInput currencyInput){
        byte[] byteObj = blobHandler.stringToBlob(currencyInput.getSymbol());
        Currency oldObj = this.currencyService.getCurrencyById(currencyId);
        Currency currencyObj = new Currency(currencyId, currencyInput.getCurrencyCode(), currencyInput.getCountry(), byteObj, currencyInput.getTradableFlag().longValue(), currencyInput.getDescription());
        if (oldObj!=null){
            return this.currencyService.updateCurrency(currencyId, currencyObj);

        }

        return null;
    }

    public boolean deleteCurrency(long currencyId){
        return this.currencyService.deleteCurrencyById(currencyId);
    }

}
