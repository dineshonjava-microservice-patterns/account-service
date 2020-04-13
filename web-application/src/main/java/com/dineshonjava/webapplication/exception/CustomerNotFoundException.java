/**
 * 
 */
package com.dineshonjava.webapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Dinesh.Rajput
 *
 */
@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String customerNumber;

	public CustomerNotFoundException(String customerNumber) {
		super();
		this.customerNumber = customerNumber;
	}
	
}
