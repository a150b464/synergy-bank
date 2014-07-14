package com.synergy.bank.common.service;

import com.synergy.bank.common.web.controller.form.LoginForm;

public interface BankAuthService {

	 public LoginForm authUser(String userid,String password);

}
