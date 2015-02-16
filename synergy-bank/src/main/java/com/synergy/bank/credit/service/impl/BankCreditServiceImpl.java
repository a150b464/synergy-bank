package com.synergy.bank.credit.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.synergy.bank.credit.dao.BankCreditDao;
import com.synergy.bank.credit.service.BankCreditService;
import com.synergy.bank.customer.dao.entity.CreditEntity;
import com.synergy.bank.customer.web.controller.CreditForm;


@Service("BankCreditServiceImpl")
@Scope("singleton")
public class BankCreditServiceImpl implements BankCreditService{
 
	@Autowired
	@Qualifier("BankCreditDaoImpl")
	
	private BankCreditDao bankCreditDao;
	@Override
	public String addCreditForm(CreditForm creditForm) {
		CreditEntity creditEntity = new CreditEntity();
		BeanUtils.copyProperties(creditForm, creditEntity);
		creditEntity.setApprove("no");
		String result= bankCreditDao.addCreditForm(creditEntity);
		return result;
	}

}
