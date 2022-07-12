package com.msf.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "PRODUCTS")
public class Product {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "PRODUCT_NAME", nullable=false)
	private String productName;
	
	@Column(name = "PRODUCT_VERSION", nullable=false)
	private String productVersion;
	
	@Column(name = "BANKS", nullable=false)
	private String banks;
	
}
