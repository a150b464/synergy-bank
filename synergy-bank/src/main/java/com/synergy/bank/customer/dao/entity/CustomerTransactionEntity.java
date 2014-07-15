package com.synergy.bank.customer.dao.entity;

/**
 * 
 * @author Ashish
 * 
 * */

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer_transaction_tbl")
public class CustomerTransactionEntity {
	
	private int transactionId;
	private String customerAccountNumber;
	private String payeeAccountNumber;
	private String customerAccountType;
	private String transactionAmount;
	private String transactionRemark;
	private Date transactionDate;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public String getCustomerAccountNumber() {
		return customerAccountNumber;
	}
	public void setCustomerAccountNumber(String customerAccountNumber) {
		this.customerAccountNumber = customerAccountNumber;
	}
	public String getPayeeAccountNumber() {
		return payeeAccountNumber;
	}
	public void setPayeeAccountNumber(String payeeAccountNumber) {
		this.payeeAccountNumber = payeeAccountNumber;
	}
	public String getCustomerAccountType() {
		return customerAccountType;
	}
	public void setCustomerAccountType(String customerAccountType) {
		this.customerAccountType = customerAccountType;
	}
	public String getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(String transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getTransactionRemark() {
		return transactionRemark;
	}
	public void setTransactionRemark(String transactionRemark) {
		this.transactionRemark = transactionRemark;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	@Override
	public String toString() {
		return "CustomerTransactionEntity [transactionId=" + transactionId
				+ ", customerAccountNumber=" + customerAccountNumber
				+ ", payeeAccountNumber=" + payeeAccountNumber
				+ ", customerAccountType=" + customerAccountType
				+ ", transactionAmount=" + transactionAmount
				+ ", transactionRemark=" + transactionRemark
				+ ", transactionDate=" + transactionDate + "]";
	}
	
	
}
