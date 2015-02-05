package com.synergy.bank.customer.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.synergy.bank.common.web.controller.form.LoginForm;
import com.synergy.bank.customer.web.constant.NavigationConstant;
import com.synergy.bank.customer.web.controller.form.LoanForm;
import com.synergy.bank.customer.web.controller.form.LoanInfoForm;
import com.synergy.bank.loan.service.BankLoanService;


@Controller
@Scope("request")
public class BankLoanController {

	@Autowired
	@Qualifier("BankLoanServiceImpl")
	private BankLoanService bankLoanService;
	
	@RequestMapping(value = "loanForm.do", method = RequestMethod.GET)
	public String showLoanForm(Model model){
		return NavigationConstant.CUSTOMER_PAGE + NavigationConstant.CUSTOMER_LOAN_INFO;
	}
	
	@RequestMapping(value = "checkList.do", method = RequestMethod.GET)
	public String showApplicationCheckList(Model model){
		return NavigationConstant.CUSTOMER_PAGE + NavigationConstant.CUSTOMER_LOAN_CHECKLIST;
	}
	
	@RequestMapping(value = "apply.do", method = RequestMethod.GET)
	public String applyAutoLoan(Model model){
		LoanForm loanForm = new LoanForm();
		model.addAttribute("addLoanForm", loanForm);
		return NavigationConstant.CUSTOMER_PAGE + NavigationConstant.CUSTOMER_LOAN_FORM;
	}
	
	@RequestMapping(value = "loanInfo.do", method = RequestMethod.GET)
	public String loanInfo(Model model){
		LoanInfoForm loanInfoForm = new LoanInfoForm();
		model.addAttribute("loanInfoForm", loanInfoForm);
		return NavigationConstant.CUSTOMER_PAGE + NavigationConstant.CUSTOMER_ABOUT_YOUR_LOAN;
	}
	
	@RequestMapping(value = "addLoanInfoForm.do", method = RequestMethod.POST)
	public String addLoanInfoForm(@ModelAttribute(value ="loanInfoForm") LoanInfoForm loanInfoForm, Model model, HttpSession session){
		LoginForm loginForm=(LoginForm)session.getAttribute(NavigationConstant.USER_SESSION_DATA);
	    String userid=loginForm.getUserId();
	    loanInfoForm.setUserid(userid);
	    bankLoanService.addLoanInfoForm(loanInfoForm);
	    if(loanInfoForm.getTrading().equalsIgnoreCase("no"))
	    	return NavigationConstant.CUSTOMER_PAGE + NavigationConstant.CUSTOMER_LOAN_APPLICANT_INFORMATION;
		return NavigationConstant.CUSTOMER_PAGE + NavigationConstant.CUSTOMER_ABOUT_YOUR_LOAN;
	}
	
	@RequestMapping(value = "purchaseYes.do", method = RequestMethod.GET)
	public String purchaseYes(Model model){
		return NavigationConstant.CUSTOMER_PAGE + NavigationConstant.CUSTOMER_LOAN_PURCHASE_YES;
	}
	
	@RequestMapping(value = "purchaseNo.do", method = RequestMethod.GET)
	public String purchaseNo(Model model){
		return NavigationConstant.CUSTOMER_PAGE + NavigationConstant.CUSTOMER_LOAN_PURCHASE_NO;
	}
	
	@RequestMapping(value = "addForm.do", method = RequestMethod.POST)
	public String addLoanForm(@ModelAttribute(value ="addLoanForm") LoanForm loanForm, Model model, HttpSession session){
		LoginForm loginForm=(LoginForm)session.getAttribute(NavigationConstant.USER_SESSION_DATA);
	    String userid=loginForm.getUserId();
	    loanForm.setUserid(userid);
		bankLoanService.addLoanForm(loanForm);
		if(loanForm.getPurchase().equalsIgnoreCase("yes"))
			return "redirect:/loan/purchaseYes.do";
		else if(loanForm.getPurchase().equalsIgnoreCase("no"))
			return "redirect:/loan/purchaseNo.do";
		return "redirect:/";
	}
}
