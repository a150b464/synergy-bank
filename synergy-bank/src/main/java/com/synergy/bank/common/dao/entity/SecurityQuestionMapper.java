package com.synergy.bank.common.dao.entity;

public class SecurityQuestionMapper {
	private SecurityQuestion securityQuestion;
	
	public SecurityQuestion getSecurityQuestion()
	{
		return securityQuestion;
	}
	public void setSecurityQuestion(SecurityQuestion securityQuestion)
	{
		this.securityQuestion = securityQuestion;
	}
	@Override
	public String toString() {
		return "SecurityQuestionMapper [securityQuestion=" + securityQuestion
				+ "]";
	}	
}
