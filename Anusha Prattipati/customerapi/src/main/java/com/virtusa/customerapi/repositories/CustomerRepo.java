package com.virtusa.customerapi.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.customerapi.models.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long>{

}
