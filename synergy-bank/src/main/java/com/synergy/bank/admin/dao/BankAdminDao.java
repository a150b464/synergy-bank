package com.synergy.bank.admin.dao;

import java.util.List;

import com.synergy.bank.customer.dao.entity.CustomerEntity;

public interface BankAdminDao {
	
	public List<CustomerEntity> findPendingCustomerList();

}
