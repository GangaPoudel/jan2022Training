package com.currency.currencyapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.currency.currencyapi.models.Currency;
import com.currency.currencyapi.repositories.CurrencyRepo;


@Service
public class CurrencyService {
	@Autowired
	private CurrencyRepo currencyrepo;
	
	//post or insert
	public Currency addcurrency(Currency currency) {
		return this.currencyrepo.save(currency);
	}
	
	//get or list all
	public List<Currency> getAllCurrencies(){
		return this.currencyrepo.findAll();
	}
	
	//get by id
	
	public Currency getCurrencyById(long currencycode) {
		return this.currencyrepo.findById(currencycode).orElse(null);
	}
	
	
	//delete
	public boolean deleteCrrencyById(long currencycode) {
		boolean status=false;
		this.currencyrepo.deleteById(currencycode);
		if(this.getCurrencyById(currencycode)==null)
			status=true;
		return status;
	}
	
	//update or post
	public Currency updateCurrency(long currencycode,String country) {
		
		Currency currency=this.getCurrencyById(currencycode);
		if(currency!=null) {
			currency.setCountry(country);
		}
		
		return this.currencyrepo.save(currency);
	}
	
	

}
