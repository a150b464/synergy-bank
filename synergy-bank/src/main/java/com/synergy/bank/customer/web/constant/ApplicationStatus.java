package com.synergy.bank.customer.web.constant;

public enum ApplicationStatus {
	
	PENDING("pending"),APPROVED("approved");
	
	private String value;
	
	private ApplicationStatus(String value){
		this.value=value;
	}
	
	
	public String value(){
		return value;
	}
}
