package com.synergy.bank.customer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.synergy.bank.customer.dao.BankCustomerDao;
import com.synergy.bank.customer.dao.entity.CustomerEntity;
import com.synergy.bank.customer.dao.entity.PayeeDetailsEntity;
import com.synergy.bank.customer.service.BankCustomerService;
import com.synergy.bank.customer.web.controller.form.CustomerForm;
import com.synergy.bank.customer.web.controller.form.PayeeDetailsForm;

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
		List<CustomerEntity> customerEntityList =bankCustomerDao.findCustomers();
		List<CustomerForm> customerFormList= new ArrayList<CustomerForm>(customerEntityList.size());

		for(int i=0;i<customerEntityList.size();i++)
		{
			CustomerForm customerForm = new CustomerForm();	
			BeanUtils.copyProperties(customerEntityList.get(i),customerForm);
			customerFormList.add(customerForm);
		}
		
		return customerFormList;
	}

	@Override
	public CustomerForm findCustomerByUserId(String userid) {
		return null;
	}

	@Override
	public List<PayeeDetailsForm> showPayeeListByUserId(String userId) {				
		
		List<PayeeDetailsEntity> payeeList = bankCustomerDao.showPayeeListByUserId(userId);		
		System.out.println(payeeList);
		List<PayeeDetailsForm> payeeListForms = new ArrayList<PayeeDetailsForm>();
		
		for (PayeeDetailsEntity pde : payeeList) {
			PayeeDetailsForm pdf = new PayeeDetailsForm();
			BeanUtils.copyProperties(pde, pdf);
			payeeListForms.add(pdf);
		}
		
		return payeeListForms;
	}

}
