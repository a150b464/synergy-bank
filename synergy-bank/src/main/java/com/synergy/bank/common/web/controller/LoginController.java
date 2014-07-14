package com.synergy.bank.common.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.synergy.bank.common.service.BankAuthService;
import com.synergy.bank.common.web.controller.form.LoginForm;
import com.synergy.bank.customer.web.constant.NavigationConstant;

@Controller
public class LoginController {
	
	@Autowired
	@Qualifier("BankAuthServiceImpl")
	private BankAuthService bankAuthService;
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session,Model model) {
		session.invalidate();
		model.addAttribute("applicationMessage", "You have successfully logout from the application.");
		return NavigationConstant.COMMON_PAGE + NavigationConstant.LOGIN_PAGE;
	}

	@RequestMapping(value = "/auth", method = RequestMethod.GET)
	public String auth(Model model) {
		return NavigationConstant.COMMON_PAGE + NavigationConstant.LOGIN_PAGE;
	}

	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public String auth(@RequestParam("login") String login,
			@RequestParam("password") String password,Model model) {
		LoginForm loginForm=bankAuthService.authUser(login, password);
		if(loginForm.getUserid()!=null){
			if("customer".equals(loginForm.getRole())){
				return NavigationConstant.CUSTOMER_PAGE+NavigationConstant.CUSTOMER_HOME_PAGE;
			}
		}else{
			model.addAttribute("applicationMessage", "User id and password are not valid.");
			return NavigationConstant.COMMON_PAGE + NavigationConstant.LOGIN_PAGE;
		}
		return NavigationConstant.CUSTOMER_PAGE+NavigationConstant.CUSTOMER_HOME_PAGE;
	}

}
