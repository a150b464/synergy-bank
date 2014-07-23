package com.synergy.bank.customer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.synergy.bank.customer.dao.BankPayeeDao;
import com.synergy.bank.customer.dao.BankTransactionDao;
import com.synergy.bank.customer.dao.entity.CustomerTransactionEntity;
import com.synergy.bank.customer.service.BankTransactionService;
import com.synergy.bank.customer.web.controller.form.CustomerTransactionForm;

@Service("BankTransactionServiceImpl")
@Scope("singleton")
public class BankTransactionServiceImpl implements BankTransactionService {

	@Autowired
	@Qualifier("BankPayeeDaoImpl")
	private BankPayeeDao bankPayeeDao;
	
	@Autowired
	@Qualifier("BankTransactionDaoImpl")
	private BankTransactionDao bankTransactionDao;

	@Autowired
	@Qualifier("BankTransactionHibernateDaoImpl")
	private BankTransactionDao bankTransactionHibernetDao;

	@Override
	public String addCustomerTransaction(CustomerTransactionForm transactionForm) {

		CustomerTransactionEntity entity = new CustomerTransactionEntity();
		BeanUtils.copyProperties(transactionForm, entity);
		System.out.println("Entity at beanUtils" + entity);
		bankTransactionDao.addCustomerTransaction(entity);
		return "success";
	}

	@Override
	public List<CustomerTransactionForm> findCustomerTransactionByAccountNumber(
			String accountNumber) {
		List<CustomerTransactionEntity> customerTransactionEntityList = bankTransactionDao
				.findCustomerTransactionByAccountNumber(accountNumber);
		List<CustomerTransactionForm> customerTransactionFormList = new ArrayList<CustomerTransactionForm>(
				customerTransactionEntityList.size());
		for (int i = 0; i < customerTransactionEntityList.size(); i++) {
			CustomerTransactionForm customerTransactionForm = new CustomerTransactionForm();
			BeanUtils.copyProperties(customerTransactionEntityList.get(i),
					customerTransactionForm);
			customerTransactionFormList.add(customerTransactionForm);
		}
		return customerTransactionFormList;
	}

	@Override
	public List<CustomerTransactionForm> findCustomerTransactionByAccountNumber(
			String customerAccountNumber, String accountNumber) {
		List<CustomerTransactionEntity> customerTransactionEntities = bankTransactionHibernetDao
				.findCustomerTransactionByAccountNumber(customerAccountNumber,
						accountNumber);
		List<CustomerTransactionForm> customerTransactionForms = new ArrayList<CustomerTransactionForm>(
				customerTransactionEntities.size());
		for (int i = 0; i < customerTransactionEntities.size(); i++) {
			CustomerTransactionForm customerTransactionForm = new CustomerTransactionForm();
			BeanUtils.copyProperties(customerTransactionEntities.get(i),
					customerTransactionForm);
			customerTransactionForms.add(customerTransactionForm);
		}
		return customerTransactionForms;
	}

	@Override
	public String checkTransactionAmountNumber(String transactionAmount) {

			return bankPayeeDao.checkTransactionAmountNumber(transactionAmount);
			
	
	}

}
