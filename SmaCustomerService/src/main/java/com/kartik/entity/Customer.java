package com.kartik.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="cust_tab")
public class Customer {

	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE) //for oracle
	@GeneratedValue(strategy = GenerationType.IDENTITY) //for mysql
	@Column(name="cust_id_col")
	private Long id;
	
	@Column(name="cust_name_col")
	private String name;
	
	@Column(name="cust_email_col")
	private String email;
	
	@Column(name="cust_gender_col")
	private String gender;
	
	@Column(name="cust_img_col")
	private String imagePath;
	
	@Column(name="cust_mob_col")
	private String mobile;
	
	@Column(name="cust_addr_col")
	private String address;
	
	@Column(name="cust_pan_col")
	private String panCardId;
	
	@Column(name="cust_aadhar_col")
	private String aadharId;
	
}

