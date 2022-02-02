package com.virtusa.currency.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.currency.models.Currency;

@Repository
public interface CurrencyRepo extends JpaRepository<Currency,Long>{

}
