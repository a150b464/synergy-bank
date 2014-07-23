package com.synergy.bank.common.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.synergy.bank.base.dao.AbstractDaoImpl;
import com.synergy.bank.common.dao.SecurityQuestionDao;
import com.synergy.bank.common.dao.entity.SecurityQuestionEntity;
import com.synergy.bank.customer.dao.entity.CustomerEntity;

@Repository("SecurityQuestionDaoImpl")
@Transactional(propagation=Propagation.REQUIRED,value="transactionManager")
public class SecurityQuestionDaoImpl extends AbstractDaoImpl<SecurityQuestionEntity,String> implements SecurityQuestionDao{

	protected SecurityQuestionDaoImpl() {
        super(SecurityQuestionEntity.class);
    }
	
	@Override
	public String saveSecurityQuestions(
			List<SecurityQuestionEntity> securityQuestionEntities) {
		
		for (SecurityQuestionEntity securityQuestionEntity : securityQuestionEntities) {
			super.saveOrUpdate(securityQuestionEntity);
		}
		
		return "success";
	}

	@Override
	public List<CustomerEntity> getCustomerListForRowNumbers(
			int initialRowNumber, int maximumRowNumbers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SecurityQuestionEntity> getRandomSecurityQuestions(int count) {
		return super.findTopNRandomRows(count);
	}
	

}
