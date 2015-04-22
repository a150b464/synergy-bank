package com.synergy.bank.customer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.synergy.bank.customer.dao.BankCustomerDao;
import com.synergy.bank.customer.dao.CustomerRegistrationQuestionsDao;
import com.synergy.bank.customer.dao.entity.CustomerRegistrationQuestionsEntity;
import com.synergy.bank.customer.service.CustomerRegistrationQuestionsService;
import com.synergy.bank.customer.web.controller.form.CustomerRegistrationQuestionsForm;

@Service("CustomerRegistrationQuestionsServiceImpl")
@Scope("singleton")
public class CustomerRegistrationQuestionsServiceImpl implements
		CustomerRegistrationQuestionsService {

	@Autowired
	@Qualifier("CustomerRegistrationQuestionsDaoImpl")
	private CustomerRegistrationQuestionsDao customerRegistrationQuestionsDao;

	@Autowired
	@Qualifier("BankCustomerDaoImpl")
	private BankCustomerDao bankCustomerDao;

	public void setCustomerRegistrationQuestionsDao(
			CustomerRegistrationQuestionsDao customerRegistrationQuestionsDao) {
		this.customerRegistrationQuestionsDao = customerRegistrationQuestionsDao;
	}

	public void setBankCustomerDao(BankCustomerDao bankCustomerDao) {
		this.bankCustomerDao = bankCustomerDao;
	}

	@Override
	public String addCustomerQuestionsAndAnswerByCustomerId(
			CustomerRegistrationQuestionsForm questionForm) {

		CustomerRegistrationQuestionsEntity entity = new CustomerRegistrationQuestionsEntity();
		BeanUtils.copyProperties(questionForm, entity);
		customerRegistrationQuestionsDao
				.addCustomerQuestionsAndAnswerByCustomerId(entity);

		return "success";
	}

	@Override
	public List<CustomerRegistrationQuestionsForm> findCustomerQuestionsAndAnswerByCustomerId(
			String customerId) {
		List<CustomerRegistrationQuestionsEntity> customerRegistrationQuestionsEntityList = 
				customerRegistrationQuestionsDao
				.findCustomerQuestionsAndAnswerByCustomerId(customerId);
		List<CustomerRegistrationQuestionsForm> customerRegistrationQuestionsFormList =
				new ArrayList<CustomerRegistrationQuestionsForm>(
				customerRegistrationQuestionsEntityList.size());

		for (int i = 0; i < customerRegistrationQuestionsEntityList.size(); i++) {
			CustomerRegistrationQuestionsForm customerRegistrationQuestionsForm = 
					new CustomerRegistrationQuestionsForm();
			BeanUtils.copyProperties(
					customerRegistrationQuestionsEntityList.get(i),
					customerRegistrationQuestionsForm);
			customerRegistrationQuestionsFormList
					.add(customerRegistrationQuestionsForm);
		}
		
		return customerRegistrationQuestionsFormList;
	}
}
