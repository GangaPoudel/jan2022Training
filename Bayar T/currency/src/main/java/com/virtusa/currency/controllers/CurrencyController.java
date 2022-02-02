package com.virtusa.currency.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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

import com.virtusa.currency.models.Currency;
import com.virtusa.currency.services.CurrencyService;
import com.virtusa.currency.controllers.CurrencyController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/currency")
@RefreshScope
@Slf4j
public class CurrencyController {
	@Autowired
	private CurrencyService currencyService;
	@Value("${newmessage}")
	private String message;

	@PostMapping(value="/",params = "version=1.0")
	public ResponseEntity<?> addCurrency(@RequestBody Currency currency) {
		Currency currencyObj = this.currencyService.addCurrency(currency);
		if(currencyObj != null) 
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(currencyObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Currency Not Created");
	}
	
	@GetMapping(value="/",params = "version=1.0")
	public List<Currency> getAllCurrency() {
		log.info("Message"+message);
		return this.currencyService.getAllCurrency();
	}
	
	@GetMapping(value="/{currencyCode}", params = "version=1.0")
	public ResponseEntity<?> getCurrencyById(@PathVariable("currencyCode") long currencyCode) {
		Currency currencyObj = this.currencyService.getCurrencyById(currencyCode);
		if(currencyObj != null)
			return  ResponseEntity.status(HttpStatus.ACCEPTED).body(currencyObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Currency does not exist");
	}
	
	@PutMapping(value="/{currencyCode}/{country}",params = "version=1.0")
	public ResponseEntity<?> updateCurrency(@PathVariable("currencyCode") long currencyCode, @PathVariable("country") String country){
		Currency currencyObj=this.currencyService.updateCurrency(currencyCode, country);
		if(currencyObj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(currencyObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Currency Not Created");
		
	}
	
	@DeleteMapping(value="/{currencyCode}",params = "version=1.0")
	public ResponseEntity<?> deleteCurrencyById(@PathVariable("currencyCode") long currencyCode){
		if(this.currencyService.deleteCurrencyById(currencyCode))
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Currency with "+currencyCode+"Deleted");
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Currency Not Found");
		
	}
}
