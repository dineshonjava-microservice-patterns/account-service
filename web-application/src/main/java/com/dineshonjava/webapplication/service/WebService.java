/**
 * 
 */
package com.dineshonjava.webapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dineshonjava.webapplication.domain.Account;
import com.dineshonjava.webapplication.domain.Customer;
import com.dineshonjava.webapplication.exception.AccountNotFoundException;
import com.dineshonjava.webapplication.exception.CustomerNotFoundException;

/**
 * @author Dinesh.Rajput
 *
 */
@Service
public class WebService {
	
	@Autowired
    @LoadBalanced
    protected RestTemplate restTemplate;
	
	protected String serviceUrlAccount = "http://ACCOUNT-SERVICE"; 
	
	protected String serviceUrlCustomer = "http://CUSTOMER-SERVICE"; 
	
    public Account getByNumber(String accountNumber) {
        Account account = restTemplate.getForObject(serviceUrlAccount
                + "/account/{accountId}", Account.class, accountNumber);
        if (account == null)
            throw new AccountNotFoundException(accountNumber);
        else
            return account;
    }
    
    public List<Account> getAllAccounts(){
    	return restTemplate.getForObject(serviceUrlAccount+ "/account", List.class);
    }
    
    public Customer getByCustomerNumber(String customerNumber) {
    	Customer customer = restTemplate.getForObject(serviceUrlCustomer
                + "/customer/{customerId}", Customer.class, customerNumber);
        if (customer == null)
            throw new CustomerNotFoundException(customerNumber);
        else
            return customer;
    }
    
    public List<Customer> getAllCustomers(){
    	return restTemplate.getForObject(serviceUrlCustomer+ "/customer", List.class);
    }
}
