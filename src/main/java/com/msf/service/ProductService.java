package com.msf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msf.datatransferobject.ProductDto;
import com.msf.models.Product;
import com.msf.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	//add product
	public void createProduct(ProductDto productDto) {
		Product product = new Product();
		product.setProductName(productDto.getProductName());
		product.setProductVersion(productDto.getProductVersion());
		product.setBanks(productDto.getBanks());
		productRepository.save(product);
	}
	
	public Product findByBanks(String banks) {
		Optional<Product> optional = productRepository.findByProductName(banks);
		if(optional.isPresent())
		{
			return optional.get();
		}
		else
			return null;
		
	}
		
}
