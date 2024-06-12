package com.kartik.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.kartik.exception.CustomerNotFoundException;
import com.kartik.payload.response.ErrorMesage;

@RestControllerAdvice
public class CustomExceptionHandler {

	/**
	 * If CustomerNotFoundException is thrown from any RestController
	 * then below method is executed and Returns Error Message with 500 Status code.
	 * It is like a Reusable Catch block code.
	 */
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorMesage> handleCustomerNotFoundException(
			CustomerNotFoundException cnfe)
	{
		return ResponseEntity.internalServerError().body(
				new ErrorMesage(
						new Date().toString(), 
						cnfe.getMessage(), 
						HttpStatus.INTERNAL_SERVER_ERROR.value(), 
						HttpStatus.INTERNAL_SERVER_ERROR.name()
						)
				
				);
	}
}
