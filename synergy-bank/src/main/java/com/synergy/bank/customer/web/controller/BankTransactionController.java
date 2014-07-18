package com.synergy.bank.customer.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.synergy.bank.customer.service.BankPayeeService;
import com.synergy.bank.customer.service.BankTransactionService;
import com.synergy.bank.customer.web.constant.NavigationConstant;
import com.synergy.bank.customer.web.controller.form.CustomerTransactionForm;

@Controller
public class BankTransactionController {
	@Autowired
	@Qualifier("BankTransactionServiceImpl")
	private BankTransactionService bankTrasactionService;

	@Autowired
	@Qualifier("BankPayeeServiceImpl")
	private BankPayeeService bankPayeeService;

	
	@RequestMapping(value="makePayments",method=RequestMethod.GET) 
	public String makePayment(Model model,
							  @RequestParam("payeeAccountNumber") String  payeeAccountNumber ) {
				
		System.out.println("payeeAcntNumber =" + payeeAccountNumber);
		model.addAttribute("payeeAccountNumber",payeeAccountNumber);
		CustomerTransactionForm customerTransactionCommand = new CustomerTransactionForm();
		model.addAttribute("customerTransactionCommand",customerTransactionCommand);
		return NavigationConstant.CUSTOMER_PAGE+NavigationConstant.FUND_TRANSFER_PAGE;
	}

	@RequestMapping(value="makePayments",method=RequestMethod.POST) 
	public String showCustomerRegistrationPage(@ModelAttribute(value="customerTransactionCommand") CustomerTransactionForm customerTransactionForm) {
		bankTrasactionService.addCustomerTransaction(customerTransactionForm);
		return NavigationConstant.CUSTOMER_PAGE+NavigationConstant.FUND_TRANSFER_PAGE;
	}
	
}
