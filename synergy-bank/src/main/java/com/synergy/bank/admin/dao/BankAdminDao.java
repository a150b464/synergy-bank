package com.synergy.bank.admin.dao;

import java.util.List;

import com.synergy.bank.admin.dao.entity.ApprovedCustomerEntity;
import com.synergy.bank.customer.dao.entity.CustomerAccountEntity;
import com.synergy.bank.customer.dao.entity.CustomerEntity;
import com.synergy.bank.customer.web.controller.form.CustomerAccountForm;

public interface BankAdminDao {
	
	public List<CustomerEntity> findPendingCustomerList();
	public List<CustomerAccountEntity> approvePendingCustomers(String[] cusomerUserNames);
	public List<ApprovedCustomerEntity> findApprovedCustomerList();
	public boolean blockCustomer(String[] cusomerUserNames);
}
