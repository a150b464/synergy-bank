package com.synergy.bank.customer.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.synergy.bank.base.dao.AbstractDaoImpl;
import com.synergy.bank.customer.dao.CustomerRegistrationQuestionsDao;
import com.synergy.bank.customer.dao.entity.CustomerEntity;
import com.synergy.bank.customer.dao.entity.CustomerRegistrationQuestionsEntity;


@Repository("CustomerRegistrationQuestionsDaoImpl")
@Transactional(propagation=Propagation.REQUIRED,value="transactionManager")
public class CustomerRegistrationQuestionsDaoImpl extends AbstractDaoImpl<CustomerRegistrationQuestionsEntity,String> implements CustomerRegistrationQuestionsDao {

	
	protected CustomerRegistrationQuestionsDaoImpl() {
        super(CustomerRegistrationQuestionsEntity.class);
    }
	
	@Override
	public String addCustomerQuestionsAndAnswerByCustomerId(CustomerRegistrationQuestionsEntity questionEntity) {
		if(TransactionSynchronizationManager.isActualTransactionActive())
		{
			super.saveOrUpdate(questionEntity);
			return "success";
		}
		return "failed";
	}

	@Override
	public List<CustomerRegistrationQuestionsEntity> findCustomerQuestionsAndAnswerByCustomerId(
			String customerId) {
		List<CustomerRegistrationQuestionsEntity> customerRegistrationQuestionsEntities = super.findByAttributeAndValue("customerId", customerId);
		return customerRegistrationQuestionsEntities;
	}
	@Override
	public List<CustomerEntity> getCustomerListForRowNumbers(
			int initialRowNumber, int maximumRowNumbers) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
