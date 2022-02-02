package com.virtusa.currencyapi.controllers;

import com.virtusa.currencyapi.models.Currency;
import com.virtusa.currencyapi.services.CurrencyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currencies")
@RefreshScope
@Slf4j
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @Value(("${newmessage}"))
    private String message;

    //get
    @GetMapping(value="/",params="version=1.0")
    public List<Currency> getAllCurrencies() {
        log.info("Message: " + message);
        return this.currencyService.getAllCurrencies();
    }

    @GetMapping(value="/{currencyId}",params="version=1.0")
    public ResponseEntity<?> getCurrencyById(@PathVariable("currencyId") long currencyId) {
        Currency currencyObj=this.currencyService.getCurrencyById(currencyId);
        if(currencyObj!=null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(currencyObj);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Currency Not Found");
        }
    }

    //post
    @PostMapping(value = "/",params="version=1.0")
    public ResponseEntity<?> addCurrency(@RequestBody Currency currency) {
        Currency currencyObj=this.currencyService.addCurrency(currency);
        if(currencyObj!=null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(currencyObj);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Currency Not Created");
        }
    }

    //put
    @PutMapping(value="/{currencyId}/{tradableFlag}",params = "version=1.0")
    public ResponseEntity<?> updateCurrency(@PathVariable("currencyId") long currencyId, @PathVariable("tradableFlag") int tradableFlag){
        Currency currencyObj=this.currencyService.updateCurrency(currencyId, tradableFlag);
        if(currencyObj!=null)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(currencyObj);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Currency Not Created");
    }

    //delete
    @DeleteMapping(value="/{currencyId}",params="version=1.0")
    public ResponseEntity<?> deleteCurrencyById(@PathVariable("currencyId") long currencyId) {
        if(this.currencyService.deleteCurrencyById(currencyId)) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Currency with id "+currencyId+" deleted");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Currency Not Found");
        }
    }
}
