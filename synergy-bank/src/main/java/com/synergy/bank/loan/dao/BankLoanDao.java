package com.synergy.bank.loan.dao;

import com.synergy.bank.customer.dao.entity.LoanApplicationInfoEntity;
import com.synergy.bank.customer.dao.entity.LoanEntity;
import com.synergy.bank.customer.dao.entity.LoanInfoEntity;



public interface BankLoanDao {

	public String addLoanForm(LoanEntity loanEntity);
	public String addLoanInfoForm(LoanInfoEntity loanInfoEntity);
	public String addApplicationInfoForm(LoanApplicationInfoEntity loanApplicationInfoEntity);
}
