package com.synergy.bank.customer.web.controller.form;

public class LoanForm {

	private int id;
	private Integer zipCode;
	private String purpose;
	private String purchase;
	private String jointCredit;
	private String permission;
	private String relation;
	private Integer preApprovedNo;
	private String userid;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public Integer getZipCode() {
		return zipCode;
	}
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getPurchase() {
		return purchase;
	}
	public void setPurchase(String purchase) {
		this.purchase = purchase;
	}
	public String getJointCredit() {
		return jointCredit;
	}
	public void setJointCredit(String jointCredit) {
		this.jointCredit = jointCredit;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	
	public Integer getPreApprovedNo() {
		return preApprovedNo;
	}
	public void setPreApprovedNo(Integer preApprovedNo) {
		this.preApprovedNo = preApprovedNo;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "LoanForm [id=" + id + ", zipCode=" + zipCode + ", purpose="
				+ purpose + ", purchase=" + purchase + ", jointCredit="
				+ jointCredit + ", permission=" + permission + ", relation="
				+ relation + ", preApprovedNo=" + preApprovedNo + ", userid="
				+ userid + "]";
	}
	
	
	
}
