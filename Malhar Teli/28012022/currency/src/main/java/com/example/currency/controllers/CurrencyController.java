package com.example.currency.controllers;

import com.example.currency.models.Currency;
import com.example.currency.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    @Autowired
    private CurrencyService currencyService;

    //Post
    @PostMapping(value = "/", params = "version=1.0")
    public ResponseEntity<?> addCurrency(@RequestBody Currency currency){
        Currency currencyObj = this.currencyService.addCurrency(currency);
        if (currencyObj!=null)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(currencyObj);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Currency not created");
    }

    //Get
    @GetMapping(value = "/", params = "version=1.0")
    public List<Currency> getAllCurrencies(){
        return this.currencyService.getAllCurrency();
    }

    //Get with Id
    @GetMapping(value = "/{currencyId}", params = "version=1.0")
    public ResponseEntity<?> getCurrencyById(@PathVariable("currencyId") long currencyId){
        Currency currencyObj = this.currencyService.getCurrencyById(currencyId);
        if (currencyObj!=null)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(currencyObj);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Currency not found");
    }

    //Put
    @PutMapping(value = "/{currencyId}", params = "version=1.0")
    public ResponseEntity<?> updateCurrency(@RequestParam("currencyId") long currencyId, @RequestBody Currency currency){
        Currency currencyObj = this.currencyService.updateCurrency(currencyId, currency);
        if (currencyObj != null)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(currencyObj);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Currency not found");

    }
    //Delete
    @DeleteMapping(value = "/{currencyId}", params = "version=1.0")
    public ResponseEntity<?> deleteCurrency(@PathVariable("currencyId") long currencyId){
        boolean result = this.currencyService.deleteCurrencyById(currencyId);
        if (result) return ResponseEntity.ok("Successfully Deleted");
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Currency not deleted/Not Found");
    }
}
