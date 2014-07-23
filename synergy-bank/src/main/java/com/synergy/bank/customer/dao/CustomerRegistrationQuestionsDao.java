package com.synergy.bank.customer.dao;

import java.util.List;

import com.synergy.bank.customer.dao.entity.CustomerRegistrationQuestionsEntity;

public interface CustomerRegistrationQuestionsDao {
	public abstract String addCustomerQuestionsAndAnswerByCustomerId(
			CustomerRegistrationQuestionsEntity questionEntity);

	public abstract List<CustomerRegistrationQuestionsEntity> findCustomerQuestionsAndAnswerByCustomerId(
			String customerId);
}
