package com.synergy.bank.admin.dao.entity;

public class ApprovedCustomerEntity {
	
	private String userId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String customerAccountNo;
	private String accountType;
	private String totalAvailBalance;
	private String currency;

	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getTotalAvailBalance() {
		return totalAvailBalance;
	}
	public void setTotalAvailBalance(String totalAvailBalance) {
		this.totalAvailBalance = totalAvailBalance;
	}
	@Override
	public String toString() {
		return "ApprovedCustomerEntity [userId=" + userId + ", firstName="
				+ firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", email=" + email + ", customerAccountNo="
				+ customerAccountNo + ", accountType=" + accountType
				+ ", totalAvailBalance=" + totalAvailBalance + ", currency="
				+ currency + "]";
	}

	
	
}
