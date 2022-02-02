package com.example.customer.controllers;

import com.example.customer.models.Bank;
import com.example.customer.services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banks")
public class BankController {
    @Autowired
    private BankService bankService;

    //Post
    @PostMapping(value="/", params = "version=1.0")
    public ResponseEntity<?> addBank(@RequestBody Bank bank){
        Bank bankObj = this.bankService.addBank(bank);
        if (bankObj!=null)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(bankObj);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bank not Created");
    }
    //Get
    @GetMapping(value = "/", params = "version=1.0")
    public List<Bank> getAllBanks() {
        return this.bankService.getAllBanks();
    }
    //Get with Id
    @GetMapping(value = "/{bankId}", params = "version=1.0")
    public ResponseEntity<?> getBankById(@PathVariable("bankId") long bankId){
        Bank bankObj = this.bankService.getBankById(bankId);
        if (bankObj!=null)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(bankObj);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bank not found");
    }
    //Put
    @PutMapping(value = "/{bankId}/", params = "version=1.0")
    public ResponseEntity<?> updateBank(@RequestBody Bank bank){
        Bank bankObj = this.bankService.updateBank(bank.getBankId(), bank);

        if (bankObj!=null)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(bankObj);
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bank no found");
    }

    //Delete
    @DeleteMapping(value = "/{bankId}", params = "version=1.0")
    public ResponseEntity<?> deleteBank(@PathVariable("bankId") long bankId){
        boolean result = this.bankService.deleteById(bankId);
        if (result) return ResponseEntity.ok("Successfully Deleted");
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bank not deleted/Not Found");
    }



}
