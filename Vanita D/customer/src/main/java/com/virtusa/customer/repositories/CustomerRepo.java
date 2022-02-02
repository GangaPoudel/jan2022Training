package com.virtusa.customer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.customer.models.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long>{

}
