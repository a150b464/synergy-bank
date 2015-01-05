package com.synergy.bank.common.service;

import java.util.List;

import com.synergy.bank.common.web.controller.form.LoginForm;
import com.synergy.bank.customer.web.controller.form.CustomerForm;

public interface BankAuthService {

	 public LoginForm authUser(String userid,String password);
	 
	 public LoginForm findLoginDetailByUserName(String userid);
	 
	 public String addCustomerDetails(CustomerForm customerForm);
	// public String checkPassword(String pwd);
	 
	 public List<String> imageAdminSliderList();

}
