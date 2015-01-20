package com.synergy.bank.customer.service;

import java.util.List;

import com.synergy.bank.customer.web.controller.form.CustomerTransactionForm;
import com.synergy.bank.customer.web.controller.form.CustomerTransactionsForm;

public interface BankTransactionService {

	String addCustomerTransaction(CustomerTransactionForm transactionForm);

	public List<CustomerTransactionsForm> findCustomerTransactionByAccountNumber(
			String accountNumber);

	public List<CustomerTransactionForm> findCustomerTransactionByAccountNumber(
			String customerAccountNumber, String accountNumber);
	
	public String checkTransactionAmountNumber(String transactionAmount);
}
