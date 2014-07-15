package com.synergy.bank.customer.service;

import com.synergy.bank.customer.dao.entity.CustomerTransactionEntity;
import com.synergy.bank.customer.web.controller.form.CustomerTransactionForm;

public interface BankTransactionService {
	
	String addCustomerTransaction(CustomerTransactionForm transactionForm);


}
