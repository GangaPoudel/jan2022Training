package com.example.currency.repositories;

import com.example.currency.models.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CurrencyRepo extends JpaRepository<Currency, Long> {

}
