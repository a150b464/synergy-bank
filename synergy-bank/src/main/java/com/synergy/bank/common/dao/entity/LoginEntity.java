package com.synergy.bank.common.dao.entity;

/**
 * 
 * @author nagendra
 *
 */
public class LoginEntity {

	private String userId;
	private String password;
	private String role;
	private String description;
	private String active;
	private String approve;

	public String getApprove() {
		return approve;
	}

	public void setApprove(String approve) {
		this.approve = approve;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
		return "LoginEntity [userId=" + userId + ", password=" + password
				+ ", role=" + role + ", description=" + description
				+ ", active=" + active + ", approve=" + approve + "]";
	}

	

}
