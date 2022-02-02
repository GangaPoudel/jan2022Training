package com.example.customer.services;

import com.example.customer.models.Bank;
import com.example.customer.repositories.BankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService {
    @Autowired
    private BankRepo bankRepo;

    //insert
    public Bank addBank(Bank bank){
        return this.bankRepo.save(bank);
    }

    //update
    public Bank updateBank(long bankId, Bank bank){
        Bank bankObj = this.getBankById(bankId);
        if (bankObj!=null){

        }
        return this.bankRepo.save(bank);
    }

    //list all
    public List<Bank> getAllBanks(){
        return this.bankRepo.findAll();
    }

    //find by Id
    public Bank getBankById(long bankId){
        return this.bankRepo.findById(bankId).orElse(null);
    }

    //delete
    public boolean deleteById(long bankId){
        this.bankRepo.deleteById(bankId);
        if (this.getBankById(bankId) ==null)
            return true;
        else return false;
    }

}
