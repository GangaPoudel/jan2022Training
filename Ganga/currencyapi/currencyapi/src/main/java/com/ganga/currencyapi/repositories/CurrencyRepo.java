package com.ganga.currencyapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ganga.currencyapi.models.Currency;

@Repository
public interface CurrencyRepo extends JpaRepository<Currency, Long> {
}
