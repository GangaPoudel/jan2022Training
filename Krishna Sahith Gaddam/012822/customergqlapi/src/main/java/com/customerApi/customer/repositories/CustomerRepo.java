package com.customerApi.customer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customerApi.customer.models.Customer;
@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {

}
