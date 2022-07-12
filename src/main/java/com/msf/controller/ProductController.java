package com.msf.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.msf.datatransferobject.ProductDto;
import com.msf.models.Product;
import com.msf.responses.APIResponse;
import com.msf.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping(value="/create")
	 public ResponseEntity<APIResponse> createProduct(@RequestBody ProductDto prdtDto) {
        
        productService.createProduct(prdtDto);
         return new ResponseEntity<>(new APIResponse(true, "product has been added"), HttpStatus.CREATED);
   }
	
	@GetMapping(value="/banks",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> findBanksByProductName(@RequestParam Product product)/* @PathVariable("productName") String productName */
	{
		Product prdtBanks = productService.findByBanks(product.getProductName());

		if(prdtBanks!=null)
			
		
			return ResponseEntity.of(Optional.of(prdtBanks.getBanks()));
			//return new ResponseEntity<>(prdtBanks.getBanks(), HttpStatus.OK);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			
			//return new ResponseEntity<>("failure", HttpStatus.BAD_REQUEST);
	}
	
}
