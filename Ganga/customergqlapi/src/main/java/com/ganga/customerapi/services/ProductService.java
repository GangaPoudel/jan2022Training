package com.ganga.customerapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ganga.customerapi.models.Product;
import com.ganga.customerapi.repositories.ProductRepo;

public class ProductService {
	@Autowired
	private ProductRepo productRepo;
	
	//insert 
	
	public Product addProductt(Product product) {
		return this.productRepo.save(product);
	}
	
	//list all the departments
	
	public List<Product> getAllProductt(){
		return this.productRepo.findAll();
	}
	
	//list bank by Id
	
	public Product getProductById(long id) {
		return this.productRepo.findById(id).orElse(null);
	}
	
	//delete

	public boolean deleteProductById(long id) {
		boolean status=false;
		this.productRepo.deleteById(id);
		if(this.getProductById(id)==null)
			status=true;
		return status;
	}
	
	//update
	
	public Product updateProduct(Product product) {
		return this.productRepo.save(product);
	}

}
