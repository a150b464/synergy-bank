package com.synergy.bank.common.dao.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="securityQuestions")
public class SecurityQuestionsList {
	private List<SecurityQuestionEntity> securityQuestionEntity;

	public List<SecurityQuestionEntity> getCustomer() {
		return securityQuestionEntity;
	}

	public void setCustomer(List<SecurityQuestionEntity> securityQuestionEntity) {
		this.securityQuestionEntity = securityQuestionEntity;
	}
}
