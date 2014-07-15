package com.synergy.bank.customer.web.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import com.synergy.bank.common.service.BankEmailService;
import com.synergy.bank.common.service.impl.EmailSenderThread;
import com.synergy.bank.customer.service.BankCustomerService;
import com.synergy.bank.customer.web.constant.NavigationConstant;
import com.synergy.bank.customer.web.controller.form.CustomerForm;
import com.synergy.bank.customer.web.controller.form.PayeeDetailsForm;


@Controller
public class BankCustomerController {
	
	@Autowired
	@Qualifier("BankCustomerServiceImpl")
	private BankCustomerService bankCustomerService;
	
	@Autowired
	@Qualifier("BankEmailServiceImpl")
	private BankEmailService bankEmailService;
	
	
	@RequestMapping(value="customerRegistration",method=RequestMethod.GET) 
	public String showCustomerRegistrationPage(Model model) {
		CustomerForm customerForm=new CustomerForm();
		
		model.addAttribute("customerForm",customerForm);
		 UUID idOne = UUID.randomUUID();
		 System.out.println("Random Id: " +idOne);
		return NavigationConstant.CUSTOMER_PAGE+NavigationConstant.CUSTOMER_REGISTRATION_PAGE;
	}
	
	
	@RequestMapping(value="/customerRegistration",method=RequestMethod.POST) 
	public String showCustomerRegistrationSubmit(@ModelAttribute(value="customerForm") CustomerForm customerForm) {
		bankCustomerService.addCustomer(customerForm);
		//here we are making this call asynchronous so we are creating  
		EmailSenderThread emailSenderThread=new EmailSenderThread(bankEmailService, customerForm.getEmail(), "Hello Dear! Ahahahah", "Regarding Registration");
		emailSenderThread.start();
		return NavigationConstant.CUSTOMER_PAGE+NavigationConstant.CUSTOMER_REGISTRATION_PAGE;
	}
		
	
	@RequestMapping(value="showPayeeList",method=RequestMethod.GET) 
	public String showPayeeList(Model model) {
		
		String userId = "1";
		List<PayeeDetailsForm> payeeList = bankCustomerService.showPayeeListByUserId(userId);
		model.addAttribute("payeeDetailsList",payeeList);
		System.out.println(payeeList);
		//return "customer/payeeList";
		return NavigationConstant.CUSTOMER_PAGE+NavigationConstant.CUSTOMER_PAYEE_LIST_PAGE;
	}

	@RequestMapping(value = "/editRegistration", method = RequestMethod.GET)
	public String editRegistration(@RequestParam("userId") String userId,Model model) {
		CustomerForm customerForm = bankCustomerService.findCustomerByUserId(userId);
		model.addAttribute("customerForm", customerForm);
		return NavigationConstant.CUSTOMER_PAGE+NavigationConstant.CUSTOMER_REGISTRATION_PAGE;
	}
	
	
	@RequestMapping(value = "/editRegistration", method = RequestMethod.POST)
	public String editRegistrationSubmit(@ModelAttribute("customerForm") CustomerForm customerForm) {
		System.out.println("Inside edit registration post");
		bankCustomerService.updateCustomer(customerForm);
		return "redirect:bank/customerInformation";
	}

	@RequestMapping(value = "/findPhotoById", method = RequestMethod.GET)
	public void findPhotoById(@RequestParam("userId") String userId,HttpServletResponse response) throws IOException{
	
		response.setContentType("image/jpg");
		byte[] photo=bankCustomerService.findPhotoById(userId);
		System.out.println("Inside find photo by id");
		if(photo!=null){
			System.out.println("found photo");
			ServletOutputStream outputStream=response.getOutputStream();
			outputStream.write(photo);
			outputStream.flush();
		}
	}
	
	@RequestMapping(value="customerInformation",method=RequestMethod.GET) 
	public String showCustomerInformation(Model model) {
		
		List<CustomerForm> customerDetailList=bankCustomerService.findCustomers();
		System.out.println(customerDetailList);
		model.addAttribute("customerList",customerDetailList);
		return NavigationConstant.CUSTOMER_PAGE+NavigationConstant.CUSTOMER_INFORMATION;
	}
	
	@RequestMapping(value="deleteCustomer",method=RequestMethod.GET) 
	public String deleteCustomerbyId(@RequestParam("userId") String UserId)
	{
		bankCustomerService.deleteCustomerById(UserId);
		return "bank/customerInformation";
	}
	
	@RequestMapping(value="searchCustomerInformation",method=RequestMethod.GET) 
	public String searchCustomerbyAttributeAndValue(@RequestParam("searchAttr")  String attribute,
			                                        @RequestParam("searchValue") String value,    
			                                        Model model){
		
		List<CustomerForm> customerDetailList = bankCustomerService.findCustomersByAttributeAndValue(attribute, value);
		model.addAttribute("customerList",customerDetailList);
		return NavigationConstant.CUSTOMER_PAGE+NavigationConstant.CUSTOMER_INFORMATION;
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
