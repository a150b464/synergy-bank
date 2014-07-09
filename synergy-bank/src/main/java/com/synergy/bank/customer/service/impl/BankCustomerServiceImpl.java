package com.synergy.bank.customer.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.synergy.bank.customer.dao.BankCustomerDao;
import com.synergy.bank.customer.dao.entity.CustomerEntity;
import com.synergy.bank.customer.service.BankCustomerService;
import com.synergy.bank.customer.web.controller.form.CustomerForm;

@Service("BankCustomerServiceImpl")
@Scope("singleton")
public class BankCustomerServiceImpl implements BankCustomerService {
	
	
	@Autowired
	@Qualifier("BankCustomerDaoImpl")
	private BankCustomerDao bankCustomerDao;

	@Override
	public String addCustomer(CustomerForm customerForm) {
		CustomerEntity customerEntity=new CustomerEntity();
		//attribute and datatype should be match
		BeanUtils.copyProperties(customerForm, customerEntity);
		return bankCustomerDao.addCustomer(customerEntity);
	}

	@Override
	public String updateCustomer(CustomerForm customerForm) {
		return null;
	}

	@Override
	public List<CustomerForm> findCustomers() {
		return null;
	}

	@Override
	public CustomerForm findCustomerByUserId(String userid) {
		return null;
	}

	

}
