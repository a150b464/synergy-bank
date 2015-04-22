package com.synergy.bank.rest.web.provider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.synergy.bank.customer.service.BankCustomerService;
import com.synergy.bank.customer.web.controller.form.CustomerForm;
import com.synergy.bank.rest.web.parser.CustomerDetails;

@Controller
@Scope("request")
public class CustomerRestProvider {

	@Autowired
	@Qualifier("BankCustomerServiceImpl")
	private BankCustomerService bankCustomerService;
	
	
	@RequestMapping(value="findCustomerDetail",method=RequestMethod.GET,produces={"application/json","application/xml"})
	public @ResponseBody CustomerDetails findCustomerDetails() {
		List<CustomerForm> customerForms=bankCustomerService.findCustomers();
		
		for(CustomerForm customerForm:customerForms){
			customerForm.setPhoto(null);
		}
		
		CustomerDetails customerDetails=new CustomerDetails();
		customerDetails.setCustomerForms(customerForms);
		return customerDetails;
	}
	

}
