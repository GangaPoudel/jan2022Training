package com.currency.currencyapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.currency.currencyapi.models.Currency;


@Repository
public interface CurrencyRepo extends JpaRepository<Currency,Long> {

}


