package com.synergy.bank.common.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="security_questions_tbl")
public class SecurityQuestionEntity implements Comparable<SecurityQuestionEntity>{
	
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
		
	@Override
	public int hashCode() {
		
		return description.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
	
		SecurityQuestionEntity e = (SecurityQuestionEntity)obj;
		if(this.description.equals(e.description))
			return true;
		else
			return false;
	}
	
	@Override
	public int compareTo(SecurityQuestionEntity o) {
		
		if(o.getDescription().equals(this.getDescription())){
			return 0;
		}
		else{
			return -1;
		}	
	}
}
