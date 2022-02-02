package com.ganga.customerapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganga.customerapi.models.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
	
}
