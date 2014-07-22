package com.synergy.bank.common.web.controller.form;

public class SecurityQuestionForm {
	
	private String id;
	private String description;
		
	public SecurityQuestionForm() {
	
	}
	public SecurityQuestionForm(String id, String description) {
		
		this.id = id;
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "SecurityQuestionForm [id=" + id + ", description="
				+ description + "]";
	}


}
