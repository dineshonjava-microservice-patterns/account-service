/**
 * 
 */
package com.dineshonjava.webapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.dineshonjava.webapplication.service.WebService;

/**
 * @author Dinesh.Rajput
 *
 */
@Controller
public class WebController {
	
	@Autowired
	WebService webService;
	
	@GetMapping("/")
	String home(){
		return "home";
	}
	
	@GetMapping("/accounts")
	String allAccounts(ModelMap model){
		model.put("accounts", webService.getAllAccounts());
		return "accounts";
	}
	
	@GetMapping("/customers")
	String allCustomers(ModelMap model){
		model.put("customers", webService.getAllCustomers());
		return "customers";
	}
}
