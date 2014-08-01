package com.synergy.bank.loan.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.synergy.bank.loan.service.CarLoanService;
import com.synergy.bank.loan.web.action.form.CarForm;


@Component("CarLoanAction")
@Scope("request")
public class CarLoanAction extends ActionSupport implements ModelDriven<CarForm> {
	
	@Autowired
	@Qualifier("CarLoanServiceImpl")
	private CarLoanService carLoanService;
	
	private CarForm carForm=new CarForm(); 

	@Override
	public CarForm getModel() {
		return carForm;
	}
	
	/**
	 * 
	 */
	public String execute() {
		carLoanService.applyforCarLoan(carForm);
		System.out.println("______carForm____"+carForm); 
		return "carLoan";
	}

}
