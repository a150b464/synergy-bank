package com.synergy.bank.soap.web.provider.wrapper;

import java.util.List;

import com.synergy.bank.customer.web.controller.form.CustomerForm;

/**
 * 
 * @author this pc
 * 
 */
public class CustomerDetails {

	private List<CustomerForm> bankCustomers;

	public List<CustomerForm> getBankCustomers() {
		return bankCustomers;
	}

	public void setBankCustomers(List<CustomerForm> bankCustomers) {
		this.bankCustomers = bankCustomers;
	}

	@Override
	public String toString() {
		return "CustomerDetails [bankCustomers=" + bankCustomers + "]";
	}
	
}
