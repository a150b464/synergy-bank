package com.synergy.bank.customer.web.controller;

import javax.servlet.http.HttpSession;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.synergy.bank.customer.service.BankPayeeService;
import com.synergy.bank.customer.web.constant.NavigationConstant;
/*import com.synergy.bank.customer.web.controller.form.CustomerTransactionForm;*/
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
		return NavigationConstant.CUSTOMER_PAGE
				+ NavigationConstant.ADD_PAYEE_PAGE;
	}

	@RequestMapping(value = "addpayee.do", method = RequestMethod.POST)
	public String addpayee(
			@ModelAttribute("addPayeeCommand") PayeeDetailsForm payeeDetailsForm,
			Model model) {

		String userId = "admin";
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
			return NavigationConstant.CUSTOMER_PAGE
					+ NavigationConstant.CONFIRM_PAYEE_PAGE;
		}

	}

	@RequestMapping(value = "confirmpayee.do", method = RequestMethod.POST)
	public String confirmpayee(
			@ModelAttribute("confirmPayeeCommand") PayeeDetailsForm payeeDetailsForm) {
		String userId = "admin";
		bankPayeeService.confirmPayee(payeeDetailsForm.getPayeeAccountNo(),
				userId);
		return NavigationConstant.CUSTOMER_PAGE
				+ NavigationConstant.CUSTOMER_HOME_PAGE;
	}

	public String isPayeeExists() {

		if (bankPayeeService.isPayeeExists("admin", "400")) {
			System.out.println("Exists");
		} else {
			System.out.println("Does not exist");
		}

		return "";
	}

}
