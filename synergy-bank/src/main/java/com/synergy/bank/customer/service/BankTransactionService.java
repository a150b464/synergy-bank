package com.synergy.bank.customer.service;

import java.util.List;

import com.synergy.bank.customer.web.controller.form.CustomerTransactionForm;

public interface BankTransactionService {

	String addCustomerTransaction(CustomerTransactionForm transactionForm);

	public List<CustomerTransactionForm> findCustomerTransactionByAccountNumber(
			String accountNumber);

	public List<CustomerTransactionForm> findCustomerTransactionByAccountNumber(
			String customerAccountNumber, String accountNumber);
}
