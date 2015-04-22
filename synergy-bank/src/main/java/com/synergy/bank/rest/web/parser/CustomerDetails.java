package com.synergy.bank.rest.web.parser;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.synergy.bank.customer.web.controller.form.CustomerForm;

@XmlRootElement
public class CustomerDetails {

	private List<CustomerForm> customerForms;

	public List<CustomerForm> getCustomerForms() {
		return customerForms;
	}

	public void setCustomerForms(List<CustomerForm> customerForms) {
		this.customerForms = customerForms;
	}

	@Override
	public String toString() {
		return "CustomerDetails [customerForms=" + customerForms + "]";
	}

}
