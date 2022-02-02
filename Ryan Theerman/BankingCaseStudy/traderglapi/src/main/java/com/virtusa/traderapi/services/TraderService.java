package com.virtusa.traderapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.virtusa.traderapi.models.Bank;
import com.virtusa.traderapi.models.Trader;
import com.virtusa.traderapi.repositories.TraderRepo;

@Service
public class TraderService {
	@Autowired
	private TraderRepo traderRepo;
	@Autowired
	private BankService bankService;
	
	//insert 	
	public Trader addTrader(long bankId,Trader trader) {
	
		 Bank bank=this.bankService.getBankById(bankId);
		 if(bank!=null)
			 trader.setBank(bank);

		 else
			 trader.setBank(null);
		 this.traderRepo.save(trader);
		 return trader;
		}

	//list all the traders
	//@Cacheable(value="Trader")
	public List<Trader> getAllTraders(){
		return this.traderRepo.findAll();
	}
	
	//list trader by Id
	//@Cacheable(value="Trader", key="#traderId")
	public Trader getTraderById(long traderId) {
		return this.traderRepo.findById(traderId).orElse(null);
	}
	
	//delete
	//@CacheEvict(value="Trader", key="#traderId")
	public boolean deleteTraderById(long traderId) {
		boolean status=false;
		if(getTraderById(traderId).getBank()!=null) {
			updateBank(getTraderById(traderId).getBank().getBankId());
		}
		this.traderRepo.deleteById(traderId);
		if(this.getTraderById(traderId)==null)
			status=true;
		return status;
	}
	//@CachePut(value="Trader", key="#traderId")
	//update
	public List<Trader> updateBank(long bankId) {
		Bank bank=this.bankService.getBankById(bankId);
		List<Trader> traderList=this.traderRepo.findByBank(bank);
	    for(Trader trader:traderList) {
	    	trader.setBank(null);
	    	this.traderRepo.save(trader);
	    }
		return traderList;
	}
	//@CachePut(value="Trader", key="#traderId")
	public Trader updateTrader(long traderId, String email) {

		Trader trader=this.getTraderById(traderId);
		if(trader!=null) {
			trader.setEmail(email);
		}
		return this.traderRepo.save(trader);

	}

}
