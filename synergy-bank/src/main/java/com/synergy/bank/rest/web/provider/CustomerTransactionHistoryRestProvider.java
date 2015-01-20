package com.synergy.bank.rest.web.provider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.synergy.bank.customer.service.BankTransactionService;
import com.synergy.bank.customer.web.controller.form.CustomerTransactionsForm;
import com.synergy.bank.rest.web.provider.wrapper.CustomerTransactionsWrapper;

@Controller
@Scope("request")
public class CustomerTransactionHistoryRestProvider {

	@Autowired
	@Qualifier("BankTransactionServiceImpl")
	private BankTransactionService bankTransactionService;

	//http://localhost:8090/synergy-bank/rest/ministatement
	//method = GET
	 //produces = application/xml
	@RequestMapping(value = "ministatement", method = RequestMethod.GET,
			produces = "application/xml")
	public @ResponseBody
	CustomerTransactionsWrapper viewMiniStatementXML(
			@RequestParam("accountNumber") String accountNumber) {
		// String accountNumber = "AAA001";
		List<CustomerTransactionsForm> transactionForms = bankTransactionService
				.findCustomerTransactionByAccountNumber(accountNumber);
		CustomerTransactionsWrapper customerTransactionWrapper = new CustomerTransactionsWrapper();
		customerTransactionWrapper.setCustomerTransactions(transactionForms);
		// it will not go to view resolver
		return customerTransactionWrapper;
	}

	@RequestMapping(value = "ministatement", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	CustomerTransactionsWrapper viewMiniStatementJSON(
			@RequestParam("accountNumber") String accountNumber) {
		// String accountNumber = "AAA001";
		List<CustomerTransactionsForm> transactionForms = bankTransactionService
				.findCustomerTransactionByAccountNumber(accountNumber);
		CustomerTransactionsWrapper customerTransactionWrapper = new CustomerTransactionsWrapper();
		customerTransactionWrapper.setCustomerTransactions(transactionForms);
		// it will not go to view resolver
		return customerTransactionWrapper;
	}

}
