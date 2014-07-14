package com.synergy.bank.common.dao.entity;

/**
 * 
 * @author nagendra
 *
 */
public class LoginEntity {

	private String userid;
	private String password;
	private String role;
	private String description;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
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
		return "LoginEntity [userid=" + userid + ", password=" + password
				+ ", role=" + role + ", description=" + description + "]";
	}

}
