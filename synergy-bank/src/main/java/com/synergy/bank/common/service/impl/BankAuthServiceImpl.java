package com.synergy.bank.common.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.synergy.bank.common.dao.BankAuthDao;
import com.synergy.bank.common.dao.entity.LoginEntity;
import com.synergy.bank.common.service.BankAuthService;
import com.synergy.bank.common.web.controller.form.LoginForm;

@Service("BankAuthServiceImpl")
public class BankAuthServiceImpl implements BankAuthService{
	
	@Autowired
	@Qualifier("BankAuthDaoImpl")
	private BankAuthDao bankAuthDao;

	@Override
	public LoginForm authUser(String userid, String password) {
		LoginEntity loginEntity=bankAuthDao.authUser(userid, password);
		LoginForm loginForm=new LoginForm();
		BeanUtils.copyProperties(loginEntity, loginForm);
		return loginForm;
	}
	
}
