/**
 * 
 */
package com.dineshonjava.webapplication.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Dinesh.Rajput
 *
 */
@ControllerAdvice
public class WebAdviceController {
	
	 @ExceptionHandler(AccountNotFoundException.class)
	 @RequestMapping("/account/${accountId}")
	 String getAccount(@PathVariable Integer accountId) {
		 throw new IllegalArgumentException("Getting account problem.");
	 }
	 
	 @ExceptionHandler(CustomerNotFoundException.class)
	 @RequestMapping("/customer/${customerId}")
	 String getCustomer(@PathVariable Integer customerId) {
		 throw new IllegalArgumentException("Getting customer problem.");
	 }
}
