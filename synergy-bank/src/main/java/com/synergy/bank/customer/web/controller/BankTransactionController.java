package com.synergy.bank.customer.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.synergy.bank.customer.service.BankPayeeService;
import com.synergy.bank.customer.service.BankTransactionService;
import com.synergy.bank.customer.web.constant.NavigationConstant;
import com.synergy.bank.customer.web.controller.form.CustomerTransactionForm;
import com.synergy.bank.customer.web.controller.form.PayeeDetailsForm;

@Controller
public class BankTransactionController {
	@Autowired
	@Qualifier("BankTransactionServiceImpl")
	private BankTransactionService bankTrasactionService;

	@Autowired
	@Qualifier("BankPayeeServiceImpl")
	private BankPayeeService bankPayeeService;

	
	@RequestMapping(value="makePayments",method=RequestMethod.GET) 
	public String makePayment(Model model) {
		/*  Adding payee list to the model*/
		List<PayeeDetailsForm>payeeDetailsFormList = bankPayeeService.getPayeeListForUserId("1");
		System.out.println(payeeDetailsFormList);
		
	
		model.addAttribute("payeeDetailsFormList",payeeDetailsFormList);
		/* adding blank transaction spring form to auto bind attributes*/		
		CustomerTransactionForm customerTransactionCommand = new CustomerTransactionForm();
/*		UUID transactionId = UUID.randomUUID();
		form.setTransactionId(transactionId.toString());
*/		model.addAttribute("customerTransactionCommand",customerTransactionCommand);
		return NavigationConstant.CUSTOMER_PAGE+NavigationConstant.MAKE_PAYMENT_PAGE;
	}

	@RequestMapping(value="makePayments",method=RequestMethod.POST) 
	public String showCustomerRegistrationPage(@ModelAttribute(value="customerTransactionCommand") CustomerTransactionForm customerTransactionForm) {
		bankTrasactionService.addCustomerTransaction(customerTransactionForm);
		return NavigationConstant.CUSTOMER_PAGE+NavigationConstant.MAKE_PAYMENT_PAGE;
	}
	
}
