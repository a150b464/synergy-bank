package com.synergy.bank.rest.web.provider.wrapper;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.synergy.bank.customer.web.controller.form.CustomerTransactionsForm;

/**
 * 
 * @author nagendra.yadav
 *
 */
@XmlRootElement
public class CustomerTransactionsWrapper {

	private List<CustomerTransactionsForm> customerTransactions;

	public List<CustomerTransactionsForm> getCustomerTransactions() {
		return customerTransactions;
	}

	public void setCustomerTransactions(
			List<CustomerTransactionsForm> customerTransactions) {
		this.customerTransactions = customerTransactions;
	}

	@Override
	public String toString() {
		return "CustomerTransactionsWrapper [customerTransactions="
				+ customerTransactions + "]";
	}

}
