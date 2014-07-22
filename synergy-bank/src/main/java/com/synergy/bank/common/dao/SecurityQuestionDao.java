package com.synergy.bank.common.dao;

import java.util.List;

import com.synergy.bank.common.dao.entity.SecurityQuestionEntity;

public interface SecurityQuestionDao {
	
	public String saveSecurityQuestions(List<SecurityQuestionEntity> securityQuestionEntities);

}
