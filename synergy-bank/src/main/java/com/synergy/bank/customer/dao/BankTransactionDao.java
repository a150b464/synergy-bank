package com.synergy.bank.customer.dao;

import java.util.List;

import com.synergy.bank.customer.dao.entity.CustomerTransactionEntity;

public interface BankTransactionDao {
	public abstract String addCustomerTransaction(CustomerTransactionEntity entity);
	public abstract String updateCustomerTransaction(CustomerTransactionEntity entity);
	public abstract List<CustomerTransactionEntity> findCustomerTransactions();
	public abstract List<CustomerTransactionEntity> findCustomerTransactionByColumnNameAndValue(String columnName, String value);
	public abstract CustomerTransactionEntity findCustomerTransactionByUserId(String userid);
}
