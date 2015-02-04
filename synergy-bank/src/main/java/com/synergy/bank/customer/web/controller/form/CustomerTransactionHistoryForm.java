package com.synergy.bank.customer.web.controller.form;

import java.util.Date;

public class CustomerTransactionHistoryForm {

	private int id;
	private String customerAccountNumber;
	private String creditDr;
	private String description;
	private long transactionId;

	@Override
	public String toString() {
		return "CustomerTransactionHistoryForm [id=" + id
				+ ", customerAccountNumber=" + customerAccountNumber
				+ ", creditDr=" + creditDr + ", description=" + description
				+ ", transactionId=" + transactionId + ", transactionDate="
				+ transactionDate + "]";
	}

	private Date transactionDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerAccountNumber() {
		return customerAccountNumber;
	}

	public void setCustomerAccountNumber(String customerAccountNumber) {
		this.customerAccountNumber = customerAccountNumber;
	}

	public String getCreditDr() {
		return creditDr;
	}

	public void setCreditDr(String creditDr) {
		this.creditDr = creditDr;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
}
