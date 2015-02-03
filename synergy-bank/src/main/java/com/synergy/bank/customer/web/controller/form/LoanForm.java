package com.synergy.bank.customer.web.controller.form;

public class LoanForm {

	private int id;
	private int zipCode;
	private String purpose;
	private String purchase;
	private String jointCredit;
	private String permission;
	private String relation;
	private int preApprovedNo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
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
	public int getPreApprovedNo() {
		return preApprovedNo;
	}
	public void setPreApprovedNo(int preApprovedNo) {
		this.preApprovedNo = preApprovedNo;
	}
	@Override
	public String toString() {
		return "LoanForm [zipCode=" + zipCode + ", purpose=" + purpose
				+ ", purchase=" + purchase + ", jointCredit=" + jointCredit
				+ ", permission=" + permission + ", relation=" + relation
				+ ", preApprovedNo=" + preApprovedNo + "]";
	}
	
	
}
