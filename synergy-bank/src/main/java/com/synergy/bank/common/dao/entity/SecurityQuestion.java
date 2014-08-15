package com.synergy.bank.common.dao.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SecurityQuestion {
	private String id;
	private String description;
		
	public SecurityQuestion() {
	
	}
	public SecurityQuestion(String id, String description) {
		
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
		return "SecurityQuestionEntity [id=" + id + ", description="
				+ description + "]";
	}

}
