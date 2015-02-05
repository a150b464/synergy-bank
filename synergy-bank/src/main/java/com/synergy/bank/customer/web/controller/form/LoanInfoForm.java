package com.synergy.bank.customer.web.controller.form;

public class LoanInfoForm {

	private Integer checkAmount;
	private Integer repaymentTerm;
	private String trading;
	private String userid;
	public Integer getCheckAmount() {
		return checkAmount;
	}
	public void setCheckAmount(Integer checkAmount) {
		this.checkAmount = checkAmount;
	}
	public Integer getRepaymentTerm() {
		return repaymentTerm;
	}
	public void setRepaymentTerm(Integer repaymentTerm) {
		this.repaymentTerm = repaymentTerm;
	}
	public String getTrading() {
		return trading;
	}
	public void setTrading(String trading) {
		this.trading = trading;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "LoanInfoForm [checkAmount=" + checkAmount + ", repaymentTerm="
				+ repaymentTerm + ", trading=" + trading + ", userid=" + userid
				+ "]";
	}
	
	
}
