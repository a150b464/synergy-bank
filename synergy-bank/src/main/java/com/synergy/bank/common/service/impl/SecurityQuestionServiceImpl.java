package com.synergy.bank.common.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.synergy.bank.common.dao.SecurityQuestionDao;
import com.synergy.bank.common.dao.entity.SecurityQuestionEntity;
import com.synergy.bank.common.service.SecurityQuestionService;
import com.synergy.bank.common.web.controller.form.SecurityQuestionForm;

@Service("SecurityQuestionServiceImpl")
@Scope("singleton")
public class SecurityQuestionServiceImpl implements SecurityQuestionService{
	
	@Autowired
	@Qualifier("SecurityQuestionDaoImpl")
	private SecurityQuestionDao securityQuestionDao;
	
	
	@Override
	public String saveSecurityQuestions(
			List<SecurityQuestionForm> securityQuestionForms) {

		List<SecurityQuestionEntity> securityQuestionEntities = new ArrayList<SecurityQuestionEntity>();

		for (SecurityQuestionForm securityQuestionForm : securityQuestionForms) {
			SecurityQuestionEntity securityQuestionEntity = new SecurityQuestionEntity();
			BeanUtils.copyProperties(securityQuestionForm, securityQuestionEntity);
			securityQuestionEntities.add(securityQuestionEntity);
		}
		System.out.println("Servicessssss");
		String result = securityQuestionDao.saveSecurityQuestions(securityQuestionEntities);
		return result;
	}
	
	

}
