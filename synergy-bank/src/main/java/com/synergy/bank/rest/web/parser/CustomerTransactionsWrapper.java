package com.synergy.bank.rest.web.parser;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.synergy.bank.rest.web.parser.CustomerTransactionsForm;

/**
 * 
 * @author nagendra.yadav
 *
 */
@XmlRootElement(name = "customerTransactionsWrapper")
public class CustomerTransactionsWrapper {

	private List<CustomerTransactionsForm> customerTransactions;

	public List<CustomerTransactionsForm> getCustomerTransactions() {
		return customerTransactions;
	}

	public void setCustomerTransactions(
			List<CustomerTransactionsForm> customerTransactions) {
		this.customerTransactions = customerTransactions;
	}

	
}
