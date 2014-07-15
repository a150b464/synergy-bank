package com.synergy.bank.common.service;

import com.synergy.bank.common.web.controller.form.LoginForm;
import com.synergy.bank.customer.web.controller.form.CustomerForm;

public interface BankAuthService {

	 public LoginForm authUser(String userid,String password);
	 public String addCustomerDetails(CustomerForm customerForm);

}
