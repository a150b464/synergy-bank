package com.synergy.bank.customer.web.controller;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.synergy.bank.common.service.BankEmailService;
import com.synergy.bank.common.service.impl.EmailSenderThread;
import com.synergy.bank.customer.service.BankPayeeService;
import com.synergy.bank.customer.web.constant.NavigationConstant;
import com.synergy.bank.customer.web.controller.form.CustomerTransactionForm;
import com.synergy.bank.customer.web.controller.form.PayeeDetailsForm;

@Controller
public class BankPayeeCustomerController {

	@Autowired
	@Qualifier("BankPayeeServiceImpl")
	private BankPayeeService bankPayeeService;
	
	@Autowired
	@Qualifier("BankEmailServiceImpl")
	private BankEmailService bankEmailService;

	// Add Payee Methods
	@RequestMapping(value = "addpayee.do", method = RequestMethod.GET)
	public String addpayee(Model model) {
		PayeeDetailsForm payeeDetailsForm = new PayeeDetailsForm();
		model.addAttribute("addPayeeCommand", payeeDetailsForm);
		System.out.println("in controller");
		return NavigationConstant.CUSTOMER_PAGE
				+ NavigationConstant.ADD_PAYEE_PAGE;
	}


	
	@RequestMapping(value = "addpayee.do", method = RequestMethod.POST)
	public String addpayee(
			@ModelAttribute("addPayeeCommand") PayeeDetailsForm payeeDetailsForm,
			Model model, HttpSession session) {

		String userId = "customer";
		if (bankPayeeService.isPayeeExists(userId,
				payeeDetailsForm.getPayeeAccountNo())) {
			String message = "This payee already exists.";
			model.addAttribute("message", message);
			return NavigationConstant.CUSTOMER_PAGE
					+ NavigationConstant.ADD_PAYEE_PAGE;
		} else {
			String stst = "pending";
			payeeDetailsForm.setDoe(new Date());
			payeeDetailsForm.setUserid(userId);
			payeeDetailsForm.setStatus(stst);
			bankPayeeService.addPayee(payeeDetailsForm);
			model.addAttribute("payeeDetailsForm", payeeDetailsForm);
			// Random Number Generator
			Random generator = new Random();
			int genPin = generator.nextInt(999999);	
			session.setAttribute("verificationPin", genPin);
			EmailSenderThread emailSenderThread = new EmailSenderThread(
					bankEmailService, payeeDetailsForm.getEmail(),
					"Hello "+ payeeDetailsForm.getPayeeName() +"! Your Registration Verification Pin is:   " + genPin, "Verification Pin Number");
			emailSenderThread.start();
			return NavigationConstant.CUSTOMER_PAGE
					+ NavigationConstant.CONFIRM_PAYEE_PAGE;
		}

	}

	@RequestMapping(value = "confirmpayee.do", method = RequestMethod.POST)
	public String confirmpayee(
			@ModelAttribute("confirmPayeeCommand") PayeeDetailsForm payeeDetailsForm, HttpServletRequest request, HttpSession sess, Model model) {
		 int genPin = Integer.parseInt(request.getParameter("verificationCode"));
		String userId = "admin";
		int enteredPin = (Integer)sess.getAttribute("verificationPin");
			if(genPin == enteredPin){
		bankPayeeService.confirmPayee(payeeDetailsForm.getPayeeAccountNo(),
				userId);
		sess.removeAttribute("verificationPin");
		return NavigationConstant.CUSTOMER_PAGE
				+ NavigationConstant.CUSTOMER_HOME_PAGE;
			}
			String errorMessage= "Verification Pin Not Valid. Please Contact the Customer Service to generate a new Verification Pin!!!";
			model.addAttribute("errormessage", errorMessage);
			return NavigationConstant.CUSTOMER_PAGE
					+ NavigationConstant.CONFIRM_PAYEE_PAGE;
			//return NavigationConstant.CUSTOMER_PAGE
				//	+ NavigationConstant.VERIFICATION_PIN_NOT_VALID;
			
	}

	public String isPayeeExists() {

		if (bankPayeeService.isPayeeExists("admin", "400")) {
			System.out.println("Exists");
		} else {
			System.out.println("Does not exist");
		}

		return "";
	}
	
	@RequestMapping(value="selectPayee",method=RequestMethod.GET) 
	public String selectPayee(/*@RequestParam("userId") String userId,*/Model model) {
		
		CustomerTransactionForm customerTransactionCommand = new CustomerTransactionForm();
		model.addAttribute("customerTransactionCommand",customerTransactionCommand);
		return NavigationConstant.CUSTOMER_PAGE+NavigationConstant.FUND_TRANSFER_PAGE;
	}
	
}
