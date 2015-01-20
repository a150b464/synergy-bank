package com.synergy.bank.customer.dao.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_transactions_tbl")
public class CustomerTransactionsEntity {
	
	private long id;
	private String accountID;
	private int ammount;
	private String creditDr;
	private String description;
	private Date transactionDate;
	private long transactionId;

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	@Column(length=40)
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

	@Column(length=30)
	public String getCreditDr() {
		return creditDr;
	}

	public void setCreditDr(String creditDr) {
		this.creditDr = creditDr;
	}

	@Column(length=100)
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
		return "CustomerTransactionsEntity [id=" + id + ", accountID="
				+ accountID + ", ammount=" + ammount + ", creditDr=" + creditDr
				+ ", description=" + description + ", transactionDate="
				+ transactionDate + ", transactionId=" + transactionId + "]";
	}

}
