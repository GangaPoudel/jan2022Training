package com.virtusa.currency.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.currency.models.Currency;
import com.virtusa.currency.repositories.CurrencyRepo;


@Service
public class CurrencyService {
	
	@Autowired
	private CurrencyRepo currencyRepo;
	
	public Currency addCurrency(Currency currency) {
		return this.currencyRepo.save(currency);
	}
	
	public List<Currency> getAllCurrency() {
		return this.currencyRepo.findAll();
	}
	
	public Currency getCurrencyById(long currencyId) {
		return this.currencyRepo.findById(currencyId).orElse(null);
	}
	
	public boolean deleteCurrencyById(long currencyId) {
		boolean status = false;
		this.currencyRepo.deleteById(currencyId);
		if(this.getCurrencyById(currencyId) == null) {
			status = true;
		}
		return status;
	}
	
	public Currency updateCurrency(long currencyId, String country) {
		Currency currency = this.getCurrencyById(currencyId);
		if(currency != null) {
			currency.setCountry(country);
		}
		return this.currencyRepo.save(currency);
	}
	

}
