package com.example.currency.services;

import com.example.currency.models.Currency;
import com.example.currency.repositories.CurrencyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {
    @Autowired
    private CurrencyRepo currencyRepo;

    //insert
    public Currency addCurrency(Currency currency){
        return this.currencyRepo.save(currency);
    }
    //update
    public Currency updateCurrency(long currencyId, Currency currency){
        Currency currencyObj = this.getCurrencyById(currencyId);
        if (currencyObj!=null){

        }
        return this.currencyRepo.save(currency);
    }

    //List all
    public List<Currency> getAllCurrency(){
        return this.currencyRepo.findAll();
    }

    public Currency getCurrencyById(long currencyId){
        return this.currencyRepo.findById(currencyId).orElse(null);
    }

    public boolean deleteCurrencyById(long currencyId){
        this.currencyRepo.deleteById(currencyId);
        return (this.getCurrencyById(currencyId)==null);
    }
}
