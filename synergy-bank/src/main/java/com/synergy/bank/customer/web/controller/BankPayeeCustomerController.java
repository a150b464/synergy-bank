package com.synergy.bank.customer.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.synergy.bank.customer.service.BankPayeeService;
import com.synergy.bank.customer.web.constant.NavigationConstant;
import com.synergy.bank.customer.web.controller.form.PayeeDetailsForm;

@Controller
public class BankPayeeCustomerController {

	@Autowired
	@Qualifier("BankPayeeServiceImpl")
	private BankPayeeService bankPayeeService;
	
	
	// Add Payee Methods
	@RequestMapping(value = "addpayee.do", method = RequestMethod.GET)
	public String addpayee(Model model) {
		PayeeDetailsForm payeeDetailsForm = new PayeeDetailsForm();
		model.addAttribute("addPayeeCommand", payeeDetailsForm);
		System.out.println("in controller");
		return NavigationConstant.CUSTOMER_PAGE+NavigationConstant.ADD_PAYEE_PAGE;
	}
		
	
	@RequestMapping(value = "addpayee.do", method = RequestMethod.POST)
	public String addpayee(@ModelAttribute("addPayeeCommand")PayeeDetailsForm payeeDetailsForm) {
		System.out.println("in post");
		String id = "11";
		String stst = "pending";
		payeeDetailsForm.setDoe(new Date());
		payeeDetailsForm.setUserid(id);
		payeeDetailsForm.setStatus(stst);
		bankPayeeService.addPayee(payeeDetailsForm);
		return NavigationConstant.CUSTOMER_PAGE+NavigationConstant.CONFIRM_PAYEE_PAGE;
	}
	
	// Confirm Payee Methods
	@RequestMapping(value = "confirmpayee.do", method = RequestMethod.GET)
	public String confirmpayee(Model model) {
		PayeeDetailsForm payeeDetailsForm = new PayeeDetailsForm();
		model.addAttribute("addPayeeCommand", payeeDetailsForm);
		System.out.println("in controller");
		return NavigationConstant.CUSTOMER_PAGE+NavigationConstant.CONFIRM_PAYEE_PAGE;
	}
	
	@RequestMapping(value = "confirmpayee.do", method = RequestMethod.POST)
	public String confirmpayee(@ModelAttribute("addPayeeCommand")PayeeDetailsForm payeeDetailsForm) {
		System.out.println("in post");
		bankPayeeService.addPayee(payeeDetailsForm);
		return NavigationConstant.CUSTOMER_PAGE+NavigationConstant.ADD_PAYEE_PAGE;
	}
}
