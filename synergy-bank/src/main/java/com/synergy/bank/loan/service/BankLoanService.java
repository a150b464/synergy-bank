package com.synergy.bank.loan.service;

import com.synergy.bank.customer.web.controller.form.LoanForm;
import com.synergy.bank.customer.web.controller.form.LoanInfoForm;



public interface BankLoanService {

	public String addLoanForm(LoanForm loanForm);
	public String addLoanInfoForm(LoanInfoForm loanInfoForm);
}
