package com.synergy.bank.customer.web.controller.form;

import java.util.Date;

public class PayeeDetailsForm {
	
	private int sno;
	private String userid;
	private String payeeAccountNo;
	private String payeeName;
	private String payeeNickName;
	private String mobile;
	private Date doe;
	private String email;
	private String status;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPayeeAccountNo() {
		return payeeAccountNo;
	}
	public void setPayeeAccountNo(String payeeAccountNo) {
		this.payeeAccountNo = payeeAccountNo;
	}
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public String getPayeeNickName() {
		return payeeNickName;
	}
	public void setPayeeNickName(String payeeNickName) {
		this.payeeNickName = payeeNickName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Date getDoe() {
		return doe;
	}
	public void setDoe(Date doe) {
		this.doe = doe;
	}
	@Override
	public String toString() {
		return "PayeeDetailsForm [sno=" + sno + ", userid=" + userid
				+ ", payeeAccountNo=" + payeeAccountNo + ", payeeName="
				+ payeeName + ", payeeNickName=" + payeeNickName + ", mobile="
				+ mobile + ", doe=" + doe + ", email=" + email + ", status="
				+ status + "]";
	}
	
}
