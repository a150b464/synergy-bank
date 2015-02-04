package com.synergy.bank.customer.dao.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_transactions_tbl")
public class CustomerTransactionsHistoryEntity {

	private int id;
	private String customerAccountNumber;
	private String creditDr;
	private String description;
	private long transactionId;
	private Date transactionDate;

	@Override
	public String toString() {
		return "CustomerTransactionsHistoryEntity [id=" + id
				+ ", customerAccountNumber=" + customerAccountNumber
				+ ", creditDr=" + creditDr + ", description=" + description
				+ ", transactionId=" + transactionId + ", transactionDate="
				+ transactionDate + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
