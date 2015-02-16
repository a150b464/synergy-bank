package com.synergy.bank.customer.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import com.synergy.bank.common.web.controller.form.LoginForm;
import com.synergy.bank.credit.service.BankCreditService;
import com.synergy.bank.customer.web.constant.NavigationConstant;
import com.synergy.bank.customer.web.controller.form.LoanForm;
import com.synergy.bank.loan.service.BankLoanService;


@Controller
@Scope("request")
public class BankCreditCardController {
	
	@Autowired
	@Qualifier("BankCreditServiceImpl")
	private BankCreditService bankCreditService;
	
	
	@RequestMapping(value = "creditcard", method = RequestMethod.GET)
	public String showLoanForm(Model model){
		return NavigationConstant.CUSTOMER_PAGE + NavigationConstant.CREDITCARD;
	}
	

	@RequestMapping(value = "applycreditcard", method = RequestMethod.GET)
	public String apply(Model model){
		
		CreditForm creditForm = new CreditForm();
		model.addAttribute("applycredit", creditForm);
		return NavigationConstant.CUSTOMER_PAGE + NavigationConstant.APPLYCREDITCARD;
	}


	@RequestMapping(value = "apply", method = RequestMethod.POST)
	
		public String applyforcredit(@ModelAttribute(value ="applycredit") CreditForm creditForm, Model model, HttpSession session){
			LoginForm loginForm=(LoginForm)session.getAttribute(NavigationConstant.USER_SESSION_DATA);
		    String userid=loginForm.getUserId();
		    creditForm.setUserId(userid);
			bankCreditService.addCreditForm(creditForm);
//			if(loanForm.getPurchase().equalsIgnoreCase("yes"))
//				return "redirect:/loan/purchaseYes.do";
//			else if(loanForm.getPurchase().equalsIgnoreCase("no"))
//				return "redirect:/loan/purchaseNo.do";
//			return NavigationConstant.CUSTOMER_PAGE + NavigationConstant.CUSTOMER_LOAN_FORM;
//		}
	return NavigationConstant.CUSTOMER_PAGE + NavigationConstant.CREDITCARD;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// to actually be able to convert Multipart instance to byte[]
		// we have to register a custom editor
		binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
       // now Spring knows how to handle multipart object and convert them
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
       // Create a new CustomDateEditor
       CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
       // Register it as custom editor for the Date type
       binder.registerCustomEditor(Date.class, editor);
	}
}	
	

//	for (SecurityQuestionForm securityQuestion : securityQuestionList) {
//		CustomerRegistrationQuestionsEntity customerRegistrationEntity = new CustomerRegistrationQuestionsEntity();
//		customerRegistrationEntity.setQuestionId(securityQuestion.getId());
//		customerRegistrationEntity.setDescription(securityQuestion
//				.getDescription());
//		customerRegistrationEntity.setCustomerId(customerForm.getUserId());
//		questionList.add(customerRegistrationEntity);
//	}
//
//	/*System.out.println("woah iside question list" + questionList);*/
//
//	customerForm.setQuestionList(questionList);
//
//	model.addAttribute("customerForm", customerForm);
//	UUID idOne = UUID.randomUUID();
//	/*System.out.println("Random Id: " + idOne);*/
//	return NavigationConstant.CUSTOMER_PAGE
//			+ NavigationConstant.CUSTOMER_REGISTRATION_PAGE;
//}
//
//@RequestMapping(value = "/customerRegistration", method = RequestMethod.POST)
//public String showCustomerRegistrationSubmit(
//		@ModelAttribute(value = "customerForm") CustomerForm customerForm,Model model) {
//	String userIdAndPassword=bankCustomerService.addCustomer(customerForm);
//	// here we are making this call asynchronous so we are creating
//	EmailSenderThread emailSenderThread = new EmailSenderThread(
//			bankEmailService, customerForm.getEmail(),
//			"Dear Sir! Welcome to Synergy Bank. You have successfully registered into out application!<br/>"+userIdAndPassword, "Regarding Registration");
//	emailSenderThread.start();
//	model.addAttribute("applicationMessage","Thanks , You have successfully registered into out application!");
//	return NavigationConstant.COMMON_PAGE
//			+ NavigationConstant.LOGIN_PAGE;
//	

