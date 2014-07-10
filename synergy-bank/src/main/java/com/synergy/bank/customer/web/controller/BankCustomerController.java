package com.synergy.bank.customer.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

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
		model.addAttribute("customerForm",customerForm);
		System.out.println("entred...!!!!!!!!!");
		return NavigationConstant.CUSTOMER_PAGE+NavigationConstant.CUSTOMER_REGISTRATION_PAGE;
	}
	
	
	@RequestMapping(value="customerRegistration",method=RequestMethod.POST) 
	public String showCustomerRegistrationSubmit(@ModelAttribute(value="customerForm") CustomerForm customerForm) {
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
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// to actually be able to convert Multipart instance to byte[]
		// we have to register a custom editor
		binder.registerCustomEditor(byte[].class,
				new ByteArrayMultipartFileEditor());
		// now Spring knows how to handle multipart object and convert them
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //Create a new CustomDateEditor
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        //Register it as custom editor for the Date type
		binder.registerCustomEditor(Date.class, editor);
	}
	
}
