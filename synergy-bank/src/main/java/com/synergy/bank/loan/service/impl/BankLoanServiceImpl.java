package com.synergy.bank.loan.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.synergy.bank.customer.dao.entity.LoanApplicationInfoEntity;
import com.synergy.bank.customer.dao.entity.LoanEntity;
import com.synergy.bank.customer.dao.entity.LoanInfoEntity;
import com.synergy.bank.customer.web.controller.form.LoanApplicationInfoForm;
import com.synergy.bank.customer.web.controller.form.LoanForm;
import com.synergy.bank.customer.web.controller.form.LoanInfoForm;
import com.synergy.bank.loan.dao.BankLoanDao;
import com.synergy.bank.loan.service.BankLoanService;

@Service("BankLoanServiceImpl")
@Scope("singleton")
public class BankLoanServiceImpl implements BankLoanService{

	@Autowired
	@Qualifier("BankLoanDaoImpl")
	private BankLoanDao bankLoanDao;
	
	@Override
	public String addLoanForm(LoanForm loanForm) {
		LoanEntity loanEntity = new LoanEntity();
		BeanUtils.copyProperties(loanForm, loanEntity);
		bankLoanDao.addLoanForm(loanEntity);
		return "success";
	}

	@Override
	public String addLoanInfoForm(LoanInfoForm loanInfoForm) {
		LoanInfoEntity loanInfoEntity = new LoanInfoEntity();
		BeanUtils.copyProperties(loanInfoForm, loanInfoEntity);
		bankLoanDao.addLoanInfoForm(loanInfoEntity);
		return "success";
	}

	@Override
	public String addApplicationInfoForm(LoanApplicationInfoForm loanApplicationInfoForm) {
		LoanApplicationInfoEntity loanApplicationInfoEntity = new LoanApplicationInfoEntity();
		BeanUtils.copyProperties(loanApplicationInfoForm, loanApplicationInfoEntity);
		bankLoanDao.addApplicationInfoForm(loanApplicationInfoEntity);
		return "success";
	}

	
}
