package com.synergy.bank.customer.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.synergy.bank.customer.dao.BankTransactionDao;
import com.synergy.bank.customer.dao.entity.CustomerTransactionEntity;
import com.synergy.bank.customer.service.BankTransactionService;
import com.synergy.bank.customer.web.controller.form.CustomerTransactionForm;

@Service("BankTransactionServiceImpl")
@Scope("singleton")
public class BankTransactionServiceImpl implements BankTransactionService{

	@Autowired
	@Qualifier("BankTransactionHibernateDaoImpl")
	private BankTransactionDao bankTransactionDao;


	@Override
	public String addCustomerTransaction(CustomerTransactionForm transactionForm) {
		
		CustomerTransactionEntity entity = new CustomerTransactionEntity();
		BeanUtils.copyProperties(transactionForm, entity);
		System.out.println("Entity at beanUtils"+entity);
		bankTransactionDao.addCustomerTransaction(entity);
		return "success";
	}

}
