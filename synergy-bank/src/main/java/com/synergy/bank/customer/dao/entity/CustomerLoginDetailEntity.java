package com.synergy.bank.customer.dao.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_login_tbl")
public class CustomerLoginDetailEntity {

	private String userId;
	private String active;
	private String approve;
	private Date createdDate;
	private int loginCount;
	private String loginId;
	private Date modifiedDate;
	private int numberOfAttempt;
	private String oldPassword;
	private String password;
	private String role;
	private String description;

	@Id
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getApprove() {
		return approve;
	}

	public void setApprove(String approve) {
		this.approve = approve;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(int loginCount) {
		this.loginCount = loginCount;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getNumberOfAttempt() {
		return numberOfAttempt;
	}

	public void setNumberOfAttempt(int numberOfAttempt) {
		this.numberOfAttempt = numberOfAttempt;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "CustomerLoginDetailEntity [userId=" + userId + ", active="
				+ active + ", approve=" + approve + ", createdDate="
				+ createdDate + ", loginCount=" + loginCount + ", loginId="
				+ loginId + ", modifiedDate=" + modifiedDate
				+ ", numberOfAttempt=" + numberOfAttempt + ", oldPassword="
				+ oldPassword + ", password=" + password + ", role=" + role
				+ ", description=" + description + "]";
	}

}
