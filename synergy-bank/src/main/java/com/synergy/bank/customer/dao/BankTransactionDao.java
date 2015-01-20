package com.synergy.bank.customer.dao;

import java.util.List;

import com.synergy.bank.customer.dao.entity.CustomerTransactionEntity;
import com.synergy.bank.customer.dao.entity.CustomerTransactionsEntity;

class AA {
   private final String nk;
   AA() {
	 nk="100";  
   }
}

public abstract interface BankTransactionDao {
	
	public static final String TEN_RUPEE="10";
	
	public abstract String addCustomerTransaction(
			CustomerTransactionsEntity entity);

	 abstract String updateCustomerTransaction(
			 CustomerTransactionsEntity entity);

	public abstract List<CustomerTransactionsEntity> findCustomerTransactions();

	public abstract List<CustomerTransactionsEntity> findCustomerTransactionByColumnNameAndValue(
			String columnName, String value);

	public abstract List<CustomerTransactionsEntity> findCustomerTransactionByUserId(
			String userid);

	public abstract List<CustomerTransactionsEntity> findCustomerTransactionByAccountNumber(
			String accountNumber);

}
