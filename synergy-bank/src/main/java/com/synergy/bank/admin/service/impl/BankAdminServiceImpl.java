package com.synergy.bank.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.synergy.bank.admin.dao.BankAdminDao;
import com.synergy.bank.admin.dao.entity.ApprovedCustomerEntity;
import com.synergy.bank.admin.service.BankAdminService;
import com.synergy.bank.admin.web.controller.form.ApprovedCustomerForm;
import com.synergy.bank.customer.dao.entity.CustomerAccountEntity;
import com.synergy.bank.customer.dao.entity.CustomerEntity;
import com.synergy.bank.customer.web.controller.form.CustomerAccountForm;
import com.synergy.bank.customer.web.controller.form.CustomerForm;


@Service("BankAdminServiceImpl")
@Scope("singleton")
public class BankAdminServiceImpl implements BankAdminService{

	@Autowired
	@Qualifier("BankAdminDaoImpl")
	private BankAdminDao bankAdminDao;

	@Override
	public List<CustomerForm> findPendingCustomerList() {
		
		List<CustomerEntity> pendingCustomerEntityList = bankAdminDao.findPendingCustomerList();  
		List<CustomerForm> pendingApprovalCustomerList= new ArrayList<CustomerForm>();
		
		for (CustomerEntity customerEntity : pendingCustomerEntityList) {
			CustomerForm cf = new CustomerForm();
			BeanUtils.copyProperties(customerEntity, cf);
			pendingApprovalCustomerList.add(cf);
		}		
		return pendingApprovalCustomerList;
	}

	@Override
	public List<CustomerAccountForm> approvePendingCustomers(String[] cusomerUserNames) {
		
		List<CustomerAccountEntity> customerAccountEntities = bankAdminDao.approvePendingCustomers(cusomerUserNames);
		List<CustomerAccountForm> customerAccountForms = new ArrayList<CustomerAccountForm>();
		
		for (CustomerAccountEntity customerAccountEntity : customerAccountEntities) {
			CustomerAccountForm customerAccountForm = new CustomerAccountForm();
			BeanUtils.copyProperties(customerAccountEntity, customerAccountForm);
			customerAccountForms.add(customerAccountForm);
		}
		
		return customerAccountForms;
	}

	@Override
	public List<ApprovedCustomerForm> findApprovedCustomerList() {
		
		List<ApprovedCustomerForm> approvedCustomerForms = new ArrayList<ApprovedCustomerForm>();
		List<ApprovedCustomerEntity> approvedCustomerEntities = bankAdminDao.findApprovedCustomerList();
		
		for (ApprovedCustomerEntity approvedCustomerEntity : approvedCustomerEntities) {
			ApprovedCustomerForm approvedCustomerForm = new ApprovedCustomerForm();
			BeanUtils.copyProperties(approvedCustomerEntity, approvedCustomerForm);
			approvedCustomerForms.add(approvedCustomerForm);
		}
		return approvedCustomerForms;
	}
	
	@Override
	public boolean blockCustomer(String[] cusomerUserNames) {
		System.out.println("S Impl"+cusomerUserNames);
		return bankAdminDao.blockCustomer(cusomerUserNames);
	}
	
}
