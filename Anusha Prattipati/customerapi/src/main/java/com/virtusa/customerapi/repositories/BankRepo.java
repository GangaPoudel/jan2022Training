package com.virtusa.customerapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.customerapi.models.Bank;

public interface BankRepo extends JpaRepository<Bank,Long>{

}
