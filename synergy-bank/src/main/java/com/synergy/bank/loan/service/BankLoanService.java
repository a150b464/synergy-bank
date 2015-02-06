package com.synergy.bank.loan.service;

import com.synergy.bank.customer.web.controller.form.LoanApplicationInfoForm;
import com.synergy.bank.customer.web.controller.form.LoanForm;
import com.synergy.bank.customer.web.controller.form.LoanInfoForm;



public interface BankLoanService {

	public String addLoanForm(LoanForm loanForm);
	public String addLoanInfoForm(LoanInfoForm loanInfoForm);
	public String addApplicationInfoForm(LoanApplicationInfoForm loanApplicationInfoForm);
}
