package com.synergy.bank.common.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
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
		
		List<SecurityQuestionEntity> questionListInDB = super.findAll();
		
		Collection<SecurityQuestionEntity> questionSetInDB = new HashSet<SecurityQuestionEntity>(questionListInDB);
		Collection<SecurityQuestionEntity> newQuestionSet = new HashSet<SecurityQuestionEntity>();
		
		newQuestionSet.addAll(securityQuestionEntities);
		//newQuestionList.addAll(questionListInDB);
		//similar.retainAll(currQuestionList);
		newQuestionSet.removeAll(questionSetInDB);
		List<SecurityQuestionEntity> newQuestionList = new ArrayList<SecurityQuestionEntity>(newQuestionSet);
		/*
		 * Save new questions from excel file that are not in database.
		 */
		for (SecurityQuestionEntity securityQuestionEntity : newQuestionList) {
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
