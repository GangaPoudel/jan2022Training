package com.currency.currencyapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.currency.currencyapi.models.Currency;
import com.currency.currencyapi.service.CurrencyService;




@RestController
@RequestMapping("/currencies")
public class CurrencyController {
	
	@Autowired
	private CurrencyService currencyservice;
	
	//post
	@PostMapping(value="/",params = "version=1.0")
	public ResponseEntity<?> addCurrency(@RequestBody Currency currency){
		Currency currencyObj=this.currencyservice.addcurrency(currency);
		if(currencyObj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(currencyObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Currency Not Created");
		
	}
	//get
	@GetMapping(value="/",params = "version=1.0")
	public List<Currency> getAllCurrencies(){
		return this.currencyservice.getAllCurrencies();
	}
	
	//get with id
	
	@GetMapping(value="/{countrycode}",params = "version=1.0")
	public ResponseEntity<?> getCurrencyById(@PathVariable("Currencycode") long currencycode){
		Currency currencyObj=this.currencyservice.getCurrencyById(currencycode);
		if(currencyObj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(currencyObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Currency Not Found");
		
	}
	
	
	//put
	
	@PutMapping(value="/{currencycode}/{country}",params = "version=1.0")
	public ResponseEntity<?> updateCurrency(@PathVariable("currencycode") long currencycode,@PathVariable("country") String country){
		Currency currencyObj=this.currencyservice.updateCurrency(currencycode,country);
		if(currencyObj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(currencyObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Currency Not Created");
		
	}
	
	
	//delete
	
	@DeleteMapping(value="/{currencycode}",params = "version=1.0")
	public ResponseEntity<?> deleteCurrencyById(@PathVariable("currencycode") long currencycode){
	
		if(this.currencyservice.deleteCrrencyById(currencycode))
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Currency with "+currencycode+"Deleted");
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("currency Not Found");
		
	}
	

}
