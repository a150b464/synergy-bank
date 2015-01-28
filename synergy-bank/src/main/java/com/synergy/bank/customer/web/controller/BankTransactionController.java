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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import com.synergy.bank.common.web.controller.form.LoginForm;
import com.synergy.bank.customer.service.BankPayeeService;
import com.synergy.bank.customer.service.BankTransactionService;
import com.synergy.bank.customer.web.constant.NavigationConstant;
import com.synergy.bank.customer.web.controller.form.CustomerTransactionForm;

@Scope("request")
@Controller
public class BankTransactionController {

	@Autowired
	@Qualifier("BankTransactionServiceImpl")
	private BankTransactionService bankTrasactionService;

	@Autowired
	@Qualifier("BankPayeeServiceImpl")
	private BankPayeeService bankPayeeService;

	// Add makePaymentsr Methods for Ajax Validation
	@RequestMapping(value = "checkTransactionAmount.do", method = RequestMethod.GET)
	public @ResponseBody String checkTransactionAmount(
			@RequestParam("ttransactionAmount") String transactionAmount) {
		String result = bankTrasactionService
				.checkTransactionAmountNumber(transactionAmount);
		return result;
	}

	@RequestMapping(value = "makePayments", method = RequestMethod.GET)
	public String makePayment(Model model,
			@RequestParam("payeeAccountNumber") String payeeAccountNumber) {

		model.addAttribute("payeeAccountNumber", payeeAccountNumber);
		CustomerTransactionForm customerTransactionCommand = new CustomerTransactionForm();
		model.addAttribute("customerTransactionCommand",
				customerTransactionCommand);
		return NavigationConstant.CUSTOMER_PAGE
				+ NavigationConstant.FUND_TRANSFER_PAGE;
	}

	@RequestMapping(value = "makePayments", method = RequestMethod.POST)
	public String showCustomerRegistrationPage(
			@ModelAttribute(value = "customerTransactionCommand") CustomerTransactionForm customerTransactionForm, HttpSession session) {
		LoginForm loginForm=(LoginForm)session.getAttribute(NavigationConstant.USER_SESSION_DATA);
	    String userid=loginForm.getUserId();
		bankTrasactionService.addCustomerTransaction(customerTransactionForm, userid);
		return NavigationConstant.CUSTOMER_PAGE
				+ NavigationConstant.FUND_TRANSFER_PAGE;
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
