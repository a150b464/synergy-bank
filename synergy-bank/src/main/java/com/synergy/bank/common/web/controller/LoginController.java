package com.synergy.bank.common.web.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.synergy.bank.common.service.BankAuthService;
import com.synergy.bank.common.web.controller.form.LoginForm;
import com.synergy.bank.customer.web.constant.NavigationConstant;
import com.synergy.bank.customer.web.controller.form.CustomerForm;

@Controller
public class LoginController {
	
	/*
    * Initiate Logger for this class
    */
   private static final Log logger = LogFactory.getLog(LoginController.class);
	
	@Autowired
	@Qualifier("BankAuthServiceImpl")
	private BankAuthService bankAuthService;
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session,Model model) {
		session.invalidate();
		model.addAttribute("applicationMessage", "You have successfully logout from the application.");
		if(logger.isDebugEnabled()){
			logger.debug("You have successfully logout from the application.");
		}
		return NavigationConstant.COMMON_PAGE + NavigationConstant.LOGIN_PAGE;
	}

	@RequestMapping(value = "/auth", method = RequestMethod.GET)
	public String auth(Model model) {
		return NavigationConstant.COMMON_PAGE + NavigationConstant.LOGIN_PAGE;
	}

	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public String auth(@RequestParam("login") String login,
			@RequestParam("password") String password,HttpSession session,Model model) {
	
		 if(logger.isDebugEnabled()){
			logger.debug("This is login form and userid entered is = "+login);
		}
		LoginForm loginForm=bankAuthService.authUser(login, password);
		loginForm.setPassword(null);
		if(loginForm.getUserId()!=null){
			session.setAttribute(NavigationConstant.USER_SESSION_DATA, loginForm);
			if("customer".equals(loginForm.getRole())){
				return NavigationConstant.CUSTOMER_PAGE+NavigationConstant.CUSTOMER_HOME_PAGE;
			}else if("admin".equals(loginForm.getRole())){
				return NavigationConstant.ADMIN_PAGE+NavigationConstant.ADMIN_HOME_PAGE;
			}
			
		}else{
			
			if(logger.isWarnEnabled()){
				logger.warn("applicationMessage, User id and password are not valid.");
			}
			
			model.addAttribute("applicationMessage", "User id and password are not valid.");
			return NavigationConstant.COMMON_PAGE + NavigationConstant.LOGIN_PAGE;
		}
		return NavigationConstant.CUSTOMER_PAGE+NavigationConstant.CUSTOMER_HOME_PAGE;
	}
	
	//@RequestMapping(value="/customerLogin",method=RequestMethod.POST) 
	public String showCustomerRegistrationSubmit(@ModelAttribute(value="customerForm") CustomerForm customerForm) {
		bankAuthService.addCustomerDetails(customerForm);
		//here we are making this call asynchronous so we are creating  
		return NavigationConstant.CUSTOMER_PAGE+NavigationConstant.CUSTOMER_REGISTRATION_PAGE;
	}
	

}
