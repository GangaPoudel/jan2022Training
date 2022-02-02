package com.ganga.currencyapi.controllers;

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
import com.ganga.currencyapi.models.Currency;
import com.ganga.currencyapi.services.CurrencyService;



@RestController
@RequestMapping("/curriences")
public class CurrencyController {
	@Autowired
	private CurrencyService currService;
	
	//post
	@PostMapping(value="/",params = "version=1.0")
	public ResponseEntity<?> addBank(@RequestBody Currency currency){
		Currency currencyObj=this.currService.addCurrency(currency);
		if(currencyObj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(currencyObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Currenct Not found");
		
	}
	
	//get
	@GetMapping(value="/",params = "version=1.0")
	public List<Currency> getAllCurrency(){
		return this.currService.getAllCurrency();
	}
	
	//get with id
	
	@GetMapping(value="/{id}",params = "version=1.0")
	public ResponseEntity<?> getCurrencyById(@PathVariable("id") long id){
		Currency currencyObj=this.currService.getCurrencyById(id);
		if(currencyObj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(currencyObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Currency Not Found");
		
	}
	
	
	//put
	
//	@PutMapping(value="/{id}/{address}",params = "version=1.0")
//	public ResponseEntity<?> updateCurrency(@PathVariable("id") long id,@PathVariable("address") String address){
//		Currency currencyObj=this.currService.updateCurrency(id, address);
//		if(currencyObj!=null)
//			return ResponseEntity.status(HttpStatus.ACCEPTED).body(currencyObj);
//		else
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bank Not Created");
//		
//	}
	
	
	//delete
	
	@DeleteMapping(value="/{id}",params = "version=1.0")
	public ResponseEntity<?> deleteCurrencyById(@PathVariable("id") long id){
	
		if(this.currService.deleteCurrencyById(id))
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Bank with "+id+"Deleted");
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bank Not Found");
		
	}
	

}
