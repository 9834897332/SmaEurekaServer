package com.kartik.service;

import java.util.List;

import com.kartik.entity.Customer;

public interface ICustomerService {

	Long saveCustomer(Customer cust);
	Customer getOneCustomer(Long id);
	Customer getOneCustomerByEmail(String email);
	Customer getOneCustomerByPanCard(String panCard);
	Customer getOneCustomerByMobile(String mobile);
	Customer getOneCustomerByAadhar(String aadhar);
	
	List<Customer> getAllCustomers();
}

