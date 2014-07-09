package com.synergy.bank.customer.service;

import java.util.List;

import com.synergy.bank.customer.web.controller.form.CustomerForm;

/**
 * @author this nagendra.yadav
 * @since 9th July 1014
 * This is contract for customer for the bank.
 */
public interface BankCustomerService {

	public String addCustomer(CustomerForm customerForm);
	public String updateCustomer(CustomerForm customerForm);
	public List<CustomerForm> findCustomers();
	public CustomerForm findCustomerByUserId(String userid);
	
}
