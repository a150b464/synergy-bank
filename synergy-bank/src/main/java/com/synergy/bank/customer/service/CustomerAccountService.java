package com.synergy.bank.customer.service;

import java.util.List;

import com.synergy.bank.customer.web.controller.form.CustomerAccountForm;

public interface CustomerAccountService {

	public List<CustomerAccountForm> findCustomerAccountByUserId(String userId);
}
