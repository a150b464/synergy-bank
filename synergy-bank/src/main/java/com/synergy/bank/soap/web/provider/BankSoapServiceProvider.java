package com.synergy.bank.soap.web.provider;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.synergy.bank.common.service.BankAuthService;
import com.synergy.bank.common.web.controller.form.LoginForm;


/**
 * 
 * @author this class is exposed as a web service
 * for login validation from client
 *
 */
@WebService
@Component("BankSoap") //what is BankSoap? is id for this instance 
public class BankSoapServiceProvider {
	

	@Autowired
	@Qualifier("BankAuthServiceImpl")
	private BankAuthService bankAuthService;
	
	public String validateLogin(String login,String password){
		System.out.println("________________________________________");
		LoginForm loginForm=bankAuthService.authUser(login, password);
		if(loginForm.getUserId()!=null){
			return "valid";
		}
		/*if("swapnil".equals(login) && "test".equals(password)){
				
		}*/
		System.out.println("login = and password = "+loginForm);
		System.out.println("________________________________________");
		return "invalid";
		
	}
}
