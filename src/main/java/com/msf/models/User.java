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
@Table(name = "USER")
public class User {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name = "EMAIL_ID",unique = true, nullable=false)
	private String emailId;
	
	@Column(name = "USERNAME", unique = true, nullable=false)
	private String userName;
	
	@Column(name = "PASSWORD", nullable=false)
	private String password;
	
}
