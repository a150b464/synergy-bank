package com.synergy.bank.loan.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.synergy.bank.loan.service.CarLoanService;
import com.synergy.bank.loan.web.action.form.CarForm;

@Service("CarLoanServiceImpl")
@Scope("singleton")
public class CarLoanServiceImpl implements CarLoanService {

	@Override
	public String applyforCarLoan(CarForm carForm) {
		//here we are going to call JMS Service 
		return "done";
	}
	
}
