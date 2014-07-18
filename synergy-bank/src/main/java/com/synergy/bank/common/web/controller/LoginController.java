package com.synergy.bank.common.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.synergy.bank.common.service.BankAuthService;
import com.synergy.bank.common.service.BankEmailService;
import com.synergy.bank.common.web.controller.form.LoginForm;
import com.synergy.bank.customer.service.BankCustomerService;
import com.synergy.bank.customer.service.CustomerAccountService;
import com.synergy.bank.customer.web.constant.NavigationConstant;
import com.synergy.bank.customer.web.controller.form.CustomerForm;
import com.synergy.bank.customer.dao.BankCustomerDao;
import com.synergy.bank.customer.dao.entity.CustomerLoginDetailEntity;;

@Controller
public class LoginController {
	
	@Autowired
	@Qualifier("BankCustomerHibernateDaoImpl")
	private BankCustomerDao bankCustomerDao;
	
	@Autowired
	@Qualifier("BankCustomerServiceImpl")
	private BankCustomerService bankCustomerService;

	@Autowired
	@Qualifier("CustomerAccountServiceImpl")
	private CustomerAccountService customerAccountService;
	@Autowired
	@Qualifier("BankEmailServiceImpl")
	private BankEmailService bankEmailService;

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
			@RequestParam("password") String password,HttpSession session,Model model) {
		LoginForm loginForm=bankAuthService.authUser(login, password);
		CustomerLoginDetailEntity customerLoginDetailEntity = new CustomerLoginDetailEntity();
		
		loginForm.setPassword(null);
		
		if(loginForm.getUserId()!=null){
			
			if("no".equals(loginForm.getActive())){
			
				model.addAttribute("applicationMessage", "You are blocked, please contact bank authority.");
				return NavigationConstant.COMMON_PAGE + NavigationConstant.LOGIN_PAGE;
			}
			
			if("no".equals(loginForm.getApprove())){
				
				model.addAttribute("applicationMessage", "You are not approved, please contact bank authority.");
				return NavigationConstant.COMMON_PAGE + NavigationConstant.LOGIN_PAGE;
			}
			
			session.setAttribute(NavigationConstant.USER_SESSION_DATA, loginForm);//Storing session information
			
			
			//write the login count logic here
			if("customer".equals(loginForm.getRole())){
				if(customerLoginDetailEntity.getLoginCount()==0)
				{
					return NavigationConstant.CUSTOMER_PAGE+NavigationConstant.CHANGE_PASSWORD_PAGE;//fw it to new jsp for changing password
				}
				else 
					return NavigationConstant.CUSTOMER_PAGE+NavigationConstant.CUSTOMER_HOME_PAGE;
			}else if("admin".equals(loginForm.getRole())){
				return NavigationConstant.ADMIN_PAGE+NavigationConstant.ADMIN_HOME_PAGE;
			}
			
		}else{
			model.addAttribute("applicationMessage", "User id and password are not valid.");
			return NavigationConstant.COMMON_PAGE + NavigationConstant.LOGIN_PAGE;
		}
		return NavigationConstant.CUSTOMER_PAGE+NavigationConstant.CUSTOMER_HOME_PAGE;
	}
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.GET)
	public String changePassword(@RequestParam("nPassword") String nPassword,HttpSession session,Model model) {
		System.out.println("inside change password");
		LoginForm loginForm=(LoginForm)session.getAttribute(NavigationConstant.USER_SESSION_DATA);
		CustomerForm customerForm = bankCustomerService.findCustomerByUserId(loginForm.getUserId());
		
		customerForm.setPassword(nPassword);
		System.out.println(customerForm);
		
		bankCustomerService.updateCustomer(customerForm);
		return NavigationConstant.CUSTOMER_PAGE+NavigationConstant.CUSTOMER_HOME_PAGE;
	}
	
	//@RequestMapping(value="/customerLogin",method=RequestMethod.POST) 
	public String showCustomerRegistrationSubmit(@ModelAttribute(value="customerForm") CustomerForm customerForm) {
		bankAuthService.addCustomerDetails(customerForm);
		//here we are making this call asynchronous so we are creating  
		return NavigationConstant.CUSTOMER_PAGE+NavigationConstant.CUSTOMER_REGISTRATION_PAGE;
	}
	

}
