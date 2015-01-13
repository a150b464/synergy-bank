package com.synergy.bank.soap.web.provider.model;

import java.util.List;
import com.synergy.bank.customer.web.controller.form.PayeeDetailsForm;



public class PayeeList {
	
	private List<PayeeDetailsForm> payeeList;

	public List<PayeeDetailsForm> getPayeeList() {
		return payeeList;
	}

	public void setPayeeList(List<PayeeDetailsForm> payeeList) {
		this.payeeList = payeeList;
	}

	@Override
	public String toString() {
		return "PayeeList [payeeList=" + payeeList + "]";
	}
	
	
}
