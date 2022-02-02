package com.virtusa.currencyapi.services;

import com.virtusa.currencyapi.models.Currency;
import com.virtusa.currencyapi.repositories.CurrencyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CurrencyService {
    @Autowired
    private CurrencyRepo currencyRepo;


    //insert
    public Currency addCurrency(Currency currency) {
        return this.currencyRepo.save(currency);
    }

//    @Cacheable(value="Currency")
    //list all the currencies
    public List<Currency> getAllCurrencies() {
        return this.currencyRepo.findAll();
    }

//    @Cacheable(value="Currency", key="#currencyId")
    //list currency by id
    public Currency getCurrencyById(long currencyId) {
        return this.currencyRepo.findById(currencyId).orElse(null);
    }

//    @CacheEvict(value="Currency", key="#currencyId")
    //delete
    public boolean deleteCurrencyById(long currencyId) {
        boolean status = false;
        this.currencyRepo.deleteById(currencyId);
        if(this.getCurrencyById(currencyId)==null) {
            status = true;
        }
        return status;
    }

//    @CachePut(value="Currency", key="#currencyId")
    //update
    public Currency updateCurrency(long currencyId, int tradableFlag) {
        Currency currency=this.getCurrencyById(currencyId);
        if(currency!=null) {
            currency.setTradableFlag(tradableFlag);
        }
        return this.currencyRepo.save(currency);
    }


}
