package com.synergy.bank.rest.web.parser;

import java.util.Date;
public class CustomerTransactionsForm {
	
	private long id;
	private String accountID;
	private int ammount;
	private String creditDr;
	private String description;
	private Date transactionDate;
	private long transactionId;
	
	
	public CustomerTransactionsForm(){
		
	}

	public CustomerTransactionsForm(long id, String accountID, int ammount,
			String creditDr, String description, Date transactionDate,
			long transactionId) {
		super();
		this.id = id;
		this.accountID = accountID;
		this.ammount = ammount;
		this.creditDr = creditDr;
		this.description = description;
		this.transactionDate = transactionDate;
		this.transactionId = transactionId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public int getAmmount() {
		return ammount;
	}

	public void setAmmount(int ammount) {
		this.ammount = ammount;
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

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	
	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	@Override
	public String toString() {
		return "CustomerTransactionsForm [id=" + id + ", accountID="
				+ accountID + ", ammount=" + ammount + ", creditDr=" + creditDr
				+ ", description=" + description + ", transactionDate="
				+ transactionDate + ", transactionId=" + transactionId + "]";
	}

}
