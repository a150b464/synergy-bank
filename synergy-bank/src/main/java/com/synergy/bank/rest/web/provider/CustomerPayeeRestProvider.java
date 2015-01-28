package com.synergy.bank.rest.web.provider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.synergy.bank.customer.service.BankPayeeService;
import com.synergy.bank.customer.web.controller.form.PayeeDetailsForm;
import com.synergy.bank.rest.web.provider.wrapper.CustomerPayeeWrapper;

@Controller
@Scope("request")
public class CustomerPayeeRestProvider {

	@Autowired
	@Qualifier("BankPayeeServiceImpl")
	private BankPayeeService bankPayeeService;
	
	@RequestMapping(value = "payeeList", method = RequestMethod.GET, produces = "application/xml")
	public @ResponseBody CustomerPayeeWrapper viewPayeeListXML(@RequestParam("email") String email){
		List<PayeeDetailsForm> payee = bankPayeeService.findPayeesByEmail(email);
		CustomerPayeeWrapper customerPayeeWrapper = new CustomerPayeeWrapper();
		customerPayeeWrapper.setPayeeList(payee);
		
		return customerPayeeWrapper;
		
	}
	
	@RequestMapping(value = "payeeList", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody CustomerPayeeWrapper viewPayeeListJSON(@RequestParam("email") String email){
		List<PayeeDetailsForm> payee = bankPayeeService.findPayeesByEmail(email);
		CustomerPayeeWrapper customerPayeeWrapper = new CustomerPayeeWrapper();
		customerPayeeWrapper.setPayeeList(payee);
		
		return customerPayeeWrapper;
		
	}
}
