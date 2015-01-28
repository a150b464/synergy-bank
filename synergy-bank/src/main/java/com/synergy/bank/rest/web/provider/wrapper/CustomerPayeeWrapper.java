package com.synergy.bank.rest.web.provider.wrapper;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.synergy.bank.customer.web.controller.form.PayeeDetailsForm;

@XmlRootElement
public class CustomerPayeeWrapper {

	private List<PayeeDetailsForm> payeeList;

	public List<PayeeDetailsForm> getPayeeList() {
		return payeeList;
	}

	public void setPayeeList(List<PayeeDetailsForm> payeeList) {
		this.payeeList = payeeList;
	}

	@Override
	public String toString() {
		return "CustomerPayeeWrapper [payeeList=" + payeeList + "]";
	}
	
	
}
