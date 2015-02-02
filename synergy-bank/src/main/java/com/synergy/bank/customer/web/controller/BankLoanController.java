package com.synergy.bank.customer.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.synergy.bank.customer.web.constant.NavigationConstant;
import com.synergy.bank.loan.service.BankLoanService;


@Controller
@Scope("request")
public class BankLoanController {

	/*@Autowired
	@Qualifier("BankLoanServiceImpl")
	private BankLoanService bankLoanService;*/
	
	@RequestMapping(value = "loanForm.do", method = RequestMethod.GET)
	public String showLoanForm(Model model){
		return NavigationConstant.CUSTOMER_PAGE + NavigationConstant.CUSTOMER_LOAN_INFO;
	}
}
