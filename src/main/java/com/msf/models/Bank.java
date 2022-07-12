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
@Table(name = "BANK")
public class Bank {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "BANK_NAME", nullable=false)
	private String bankName;
	
	@Column(name = "IFSC_Code", nullable=false)
	private String ifscCode;
	
	@Column(name = "BRANCH_NAME", nullable=false)
	private String branchName;
	
	@Column(name = "TYPE_OF_THE_BANK", nullable=false)
	private String typeOfTheBank;
	
}
