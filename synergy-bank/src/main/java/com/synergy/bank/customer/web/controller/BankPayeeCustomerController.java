package com.synergy.bank.customer.web.controller;
import java.sql.Date;
import java.util.List;

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
	public String addpayee(@ModelAttribute("addPayeeCommand")PayeeDetailsForm payeeDetailsForm,Model model) {
		System.out.println("in post");
		String id = "6056701129";
		String stst = "pending";
		payeeDetailsForm.setDoe(new java.util.Date());
		payeeDetailsForm.setUserid(id);
		payeeDetailsForm.setStatus(stst);
		//first check wheather account exist or not
		//second check weather payee is already addded or not
		bankPayeeService.addPayee(payeeDetailsForm);
		
		//PayeeDetailsForm dpayeeDetailsForm = bankPayeeService.findPayeeByUserId(id);
		payeeDetailsForm.setDoe(new java.util.Date());
		model.addAttribute("payeeDetailsForm", payeeDetailsForm);
		return NavigationConstant.CUSTOMER_PAGE+NavigationConstant.CONFIRM_PAYEE_PAGE;
		//return NavigationConstant.CUSTOMER_PAGE+NavigationConstant.c;
	}
	
/*	// Confirm Payee Methods
	@RequestMapping(value = "confirmpayee.do", method = RequestMethod.GET)
	public String confirmpayee(Model model) {
		//PayeeDetailsForm payeeDetailsForm = new PayeeDetailsForm();
		String userid ="6056701129";
		System.out.println("Entering Confirm UserId fetch");
		PayeeDetailsForm payeeDetailsForm = bankPayeeService.findPayeeByUserId(userid);
		payeeDetailsForm.setDoe(new java.util.Date());
		model.addAttribute("showPayeeList", payeeDetailsForm);
		System.out.println("in controller of confirm");
		System.out.println(payeeDetailsForm);
		return NavigationConstant.CUSTOMER_PAGE+NavigationConstant.CONFIRM_PAYEE_PAGE;
	}	*/
	
	
	@RequestMapping(value = "confirmpayee.do", method = RequestMethod.POST)
	public String confirmpayee(@ModelAttribute("payeeDetailsForm")PayeeDetailsForm payeeDetailsForm) {
		bankPayeeService.confirmPayee(payeeDetailsForm);
		return NavigationConstant.CUSTOMER_PAGE+NavigationConstant.CUSTOMER_HOME_PAGE;
	}	
}
