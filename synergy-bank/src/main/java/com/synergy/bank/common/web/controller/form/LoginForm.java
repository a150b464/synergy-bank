package com.synergy.bank.common.web.controller.form;

/**
 * 
 * @author nagendra
 *
 */
public class LoginForm {

	private String userId;
	private String password;
	private String role;
	private String description;
	private String active;
	private String approve;
	private int loginCount;
	
	public boolean validateUserId(String userid){
		 if(this.userId.equals(userid)){
			 return true;
		 }else{
			 return false;
		 }
	}

	public int getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(int loginCount) {
		this.loginCount = loginCount;
	}

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
		return "LoginForm [userId=" + userId + ", password=" + password
				+ ", role=" + role + ", description=" + description
				+ ", active=" + active + ", approve=" + approve
				+ ", loginCount=" + loginCount + "]";
	}


}
