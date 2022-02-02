package com.ganga.currencyapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganga.currencyapi.models.Currency;
import com.ganga.currencyapi.repositories.CurrencyRepo;



@Service
public class CurrencyService {
	@Autowired
    private CurrencyRepo currencyRepo;

    //insert currency
    public Currency addCurrency(Currency currency){
        return this.currencyRepo.save(currency);
    }
    //update currency
    public Currency updateCurrency(Currency currency){
        return this.currencyRepo.save(currency);
    }
    //delete
    public boolean deleteCurrencyById(long Id){
        boolean status = false;
        this.currencyRepo.deleteById(Id);
        if(this.getCurrencyById(Id)==null){
            status=true;
        }
        return status;
    }

    //delete all
    public boolean deleteAllCurrency(){
        this.currencyRepo.deleteAll();
        if(this.currencyRepo.findAll().isEmpty()){
            return true;
        }
        return false;
    }

    //list all currencies
    public List<Currency> getAllCurrency(){
        return this.currencyRepo.findAll();
    }

    //fetch currency by id
    public Currency getCurrencyById(long Id){
        return this.currencyRepo.findById(Id).orElse(null);
    }

}