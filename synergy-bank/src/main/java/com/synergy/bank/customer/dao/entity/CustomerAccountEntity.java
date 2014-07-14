package com.synergy.bank.customer.dao.entity;

import java.util.Date;

public class CustomerAccountEntity {
	
	private int id;
	private String userid;
	private String customerName;
	private String customerAccountNo;
	private String accountType;
	private Double availBalance;
	private Double totalAvailBalance;
	private String currency;
	private Date doe;
	private Date dom;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAccountNo() {
		return customerAccountNo;
	}
	public void setCustomerAccountNo(String customerAccountNo) {
		this.customerAccountNo = customerAccountNo;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Double getAvailBalance() {
		return availBalance;
	}
	public void setAvailBalance(Double availBalance) {
		this.availBalance = availBalance;
	}
	public Double getTotalAvailBalance() {
		return totalAvailBalance;
	}
	public void setTotalAvailBalance(Double totalAvailBalance) {
		this.totalAvailBalance = totalAvailBalance;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Date getDoe() {
		return doe;
	}
	public void setDoe(Date doe) {
		this.doe = doe;
	}
	public Date getDom() {
		return dom;
	}
	public void setDom(Date dom) {
		this.dom = dom;
	}
	@Override
	public String toString() {
		return "CustomerAccountEntity [id=" + id + ", userid=" + userid
				+ ", customerName=" + customerName + ", customerAccountNo="
				+ customerAccountNo + ", accountType=" + accountType
				+ ", availBalance=" + availBalance + ", totalAvailBalance="
				+ totalAvailBalance + ", currency=" + currency + ", doe=" + doe
				+ ", dom=" + dom + "]";
	}
	
}
