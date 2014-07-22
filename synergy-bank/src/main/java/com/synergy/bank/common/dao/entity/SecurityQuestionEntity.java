package com.synergy.bank.common.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="security_questions_tbl")
public class SecurityQuestionEntity {
	
	@Id
	private String id;
	private String description;
		
	public SecurityQuestionEntity() {
	
	}
	public SecurityQuestionEntity(String id, String description) {
		
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
