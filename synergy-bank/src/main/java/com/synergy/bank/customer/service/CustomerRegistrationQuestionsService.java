package com.synergy.bank.customer.service;

import java.util.List;
import com.synergy.bank.customer.web.controller.form.CustomerRegistrationQuestionsForm;

public interface CustomerRegistrationQuestionsService {
	public abstract String addCustomerQuestionsAndAnswerByCustomerId(CustomerRegistrationQuestionsForm questionForm);
	public abstract List<CustomerRegistrationQuestionsForm> findCustomerQuestionsAndAnswerByCustomerId(String customerId);

}
