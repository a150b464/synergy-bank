package com.synergy.bank.soap.web.provider;

import javax.jws.WebService;


/**
 * 
 * @author this class is exposed as a web service
 * for login validation from client
 *
 */
@WebService
public class BankSoapServiceProvider {
	public String validateLogin(String login,String password){
		System.out.println("________________________________________");
		if("swapnil".equals(login) && "test".equals(password)){
			return "valid";	
		}
		System.out.println("login = "+login+" and password = "+password);
		System.out.println("________________________________________");
		return "invalid";
	}
}
