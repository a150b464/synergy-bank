
package com.synergy.bank.customer.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.synergy.bank.customer.service.BankCustomerService;
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
		return "customer/customerRegistration";
	}
	
	
	@RequestMapping(value="customerRegistration",method=RequestMethod.POST) 
	public String showCustomerRegistrationSubmit(@ModelAttribute("customerCommand") CustomerForm customerForm) {
		//
		return "customer/customerRegistration";
	}
	
	@RequestMapping(value="test",method=RequestMethod.GET) 
	public String test() {
		CustomerForm customerForm=new CustomerForm();
		customerForm.setUserId("yadna01");
		customerForm.setPassword("test@123");
		customerForm.setEmail("nagend@gmail.com");
		customerForm.setMobile("23243443");
		bankCustomerService.addCustomer(customerForm);
		return "customer/customerRegistration";
	}
	
	
	

}
