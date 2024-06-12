package com.kartik.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kartik.entity.Customer;
import com.kartik.exception.CustomerNotFoundException;
import com.kartik.service.ICustomerService;



@RestController
@RequestMapping("/customer")
public class CustomerRestController {

	@Autowired
	private ICustomerService service;
	
	//1. save customer
	@PostMapping("/create")
	public ResponseEntity<String> createCustomer(
			@RequestBody Customer customer
			)
	{
		ResponseEntity<String> response = null;
		
		Long id = service.saveCustomer(customer);
		response = ResponseEntity.ok("Customer '"+id+"' Created!");
		
		return response;
	}
	
	//2. fetch all customers
	@GetMapping("/all")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		ResponseEntity<List<Customer>> response  = null;
		List<Customer> list = service.getAllCustomers();
		response = ResponseEntity.ok(list);
		return response;
	}
	
	
	//3. fetch one customer by email
	@GetMapping("/find/{mail}")
	public ResponseEntity<Customer> getOneCustomerByEmail(
			@PathVariable String mail
			) 
	{
		ResponseEntity<Customer> response = null;
		try {
			Customer cust = service.getOneCustomerByEmail(mail);
			response = new ResponseEntity<Customer>(cust,HttpStatus.OK);
		} catch (CustomerNotFoundException cnfe) {
			cnfe.printStackTrace();
			throw cnfe;
		}
		return response;
	}
	
	 //4. fetch one customer by PAN card
    @GetMapping("/find/pan/{panCard}")
    public ResponseEntity<Customer> getOneCustomerByPanCard(@PathVariable String panCard) {
        ResponseEntity<Customer> response = null;
        try {
            Customer cust = service.getOneCustomerByPanCard(panCard);
            response = new ResponseEntity<>(cust, HttpStatus.OK);
        } catch (CustomerNotFoundException cnfe) {
            cnfe.printStackTrace();
            throw cnfe;
        }
        return response;
    }

    //5. fetch one customer by  AadharID
    @GetMapping("/find/aadhar/{aadharId}")
    public ResponseEntity<Customer> getOneCustomerByAadharId(@PathVariable String aadharId) {
        ResponseEntity<Customer> response = null;
        try {
            Customer cust = service.getOneCustomerByAadhar(aadharId);
            response = new ResponseEntity<>(cust, HttpStatus.OK);
        } catch (CustomerNotFoundException cnfe) {
            cnfe.printStackTrace();
            throw cnfe;
        }
        return response;
    }

    //6. fetch one customer by mobile number
    @GetMapping("/find/mobile/{mobile}")
    public ResponseEntity<Customer> getOneCustomerByMobile(@PathVariable String mobile) {
        ResponseEntity<Customer> response = null;
        try {
            Customer cust = service.getOneCustomerByMobile(mobile);
            response = new ResponseEntity<>(cust, HttpStatus.OK);
        } catch (CustomerNotFoundException cnfe) {
            cnfe.printStackTrace();
            throw cnfe;
        }
        return response;
    }
	
}

