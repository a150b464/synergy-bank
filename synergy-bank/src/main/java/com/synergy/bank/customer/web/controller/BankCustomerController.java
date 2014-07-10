package com.synergy.bank.customer.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.synergy.bank.customer.service.BankCustomerService;
import com.synergy.bank.customer.web.constant.NavigationConstant;
import com.synergy.bank.customer.web.controller.form.CustomerForm;


@Controller
public class BankCustomerController {
	
	@Autowired
	@Qualifier("BankCustomerServiceImpl")
	private BankCustomerService bankCustomerService;
	
	@RequestMapping(value="customerRegistration",method=RequestMethod.GET) 
	public String showCustomerRegistrationPage(Model model) {
		CustomerForm customerForm=new CustomerForm();
		model.addAttribute("customerCommand",customerForm);
		System.out.println("entred...!!!!!!!!!");
		return NavigationConstant.CUSTOMER_PAGE+NavigationConstant.CUSTOMER_REGISTRATION_PAGE;
	}
	
	
	@RequestMapping(value="customerRegistration",method=RequestMethod.POST) 
	public String showCustomerRegistrationSubmit(@ModelAttribute("customerCommand") CustomerForm customerForm) {
		//
		bankCustomerService.addCustomer(customerForm);
		return NavigationConstant.CUSTOMER_PAGE+NavigationConstant.CUSTOMER_REGISTRATION_PAGE;
	}
		
	@RequestMapping(value="customerInformation",method=RequestMethod.GET) 
	public String showCustomerInformation(Model model) {
		
		List<CustomerForm> customerDetailList=bankCustomerService.findCustomers();
		System.out.println(customerDetailList);
		model.addAttribute("customerList",customerDetailList);
		return "customer/customerDetailsTableView";
	}
	
}
