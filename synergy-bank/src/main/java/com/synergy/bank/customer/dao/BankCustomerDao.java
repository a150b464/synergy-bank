package com.synergy.bank.customer.dao;

import java.util.List;

import com.synergy.bank.customer.dao.entity.CustomerEntity;

/**
 * @author this nagendra.yadav
 * @since 9th July 1014
 * This is contract for customer for the bank.
 */
public interface BankCustomerDao {

	public String addCustomer(CustomerEntity entity);
	public String updateCustomer(CustomerEntity entity);
	public List<CustomerEntity> findCustomers();
	public CustomerEntity findCustomerByUserId(String userid);
	
}
