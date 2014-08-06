package com.synergy.bank.rest.web.provider.wrapper;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.synergy.bank.customer.web.controller.form.CustomerTransactionForm;

/**
 * 
 * @author nagendra.yadav
 *
 */
@XmlRootElement
public class CustomerTransactionWrapper {

	private List<CustomerTransactionForm> customerTransactions;

	public List<CustomerTransactionForm> getCustomerTransactions() {
		return customerTransactions;
	}

	public void setCustomerTransactions(
			List<CustomerTransactionForm> customerTransactions) {
		this.customerTransactions = customerTransactions;
	}

	@Override
	public String toString() {
		return "CustomerTransactionWrapper [customerTransactions="
				+ customerTransactions + "]";
	}

}
