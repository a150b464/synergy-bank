package com.synergy.bank.common.dao;

import java.util.List;

import com.synergy.bank.customer.dao.entity.CustomerEntity;

/**
 * 
 * @author Swapnil
 *
 */
public interface BankJdbcDao {
	public String nextUserID();
	public String nextTransactionId();
	public char[] generatePassword();
	public List<CustomerEntity> findCustomersByBirthDay();
}
