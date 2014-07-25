/**
 * 
 * @author Swapnil
 */

package com.synergy.bank.soap.web.provider;

import java.util.List;

import javax.jws.WebService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.synergy.bank.customer.service.BankCustomerService;
import com.synergy.bank.customer.web.controller.form.CustomerForm;
import com.synergy.bank.soap.web.provider.fault.CustomerNotFoundException;
import com.synergy.bank.soap.web.provider.fault.SoapFaultMessage;
import com.synergy.bank.soap.web.provider.wrapper.CustomerDetails;

//name = is portType
@WebService(name="BankCustomerSoapService",serviceName="BankCustomerSoapServiceImpl",portName="BankCustomerSoapServicePort")
@Component("BankCustomerSoapServiceProvider")
public class BankCustomerSoapServiceProvider  implements BankCustomerSoapService{
	
	/*
	 * Initiate Logger for this class
	 */
	private static final Log logger = LogFactory.getLog(BankCustomerSoapServiceProvider.class);
	
	@Autowired
	@Qualifier("BankCustomerServiceImpl")
	private BankCustomerService bankCustomerService;

	@Override
	public CustomerDetails findBankCustomers() throws CustomerNotFoundException {
		if(logger.isDebugEnabled()){
			logger.debug("___findBankCustomers web service method is invoked_____");
		}
		
		List<CustomerForm> bankCustomers=bankCustomerService.findCustomers();
		if(bankCustomers==null || bankCustomers.size()==0){
			SoapFaultMessage faultMessage=new SoapFaultMessage();
			faultMessage.setFaultCode("E1002");
			faultMessage.setDetailMessage("Customers do not exist into the database, please contant to admin");
			//first parameter = high level  description
			CustomerNotFoundException customerNotFoundException=new CustomerNotFoundException("DB Issue",faultMessage);
			throw customerNotFoundException;
		}
		
		CustomerDetails customerDetails=new CustomerDetails();
		customerDetails.setBankCustomers(bankCustomers);
		return customerDetails;
	}

	@Override
	public CustomerForm findBankCustomerByUserId(String customerUserId) throws CustomerNotFoundException {
		if(logger.isDebugEnabled()){
			logger.debug("___findBankCustomerByUserId web service method is invoked_____"+customerUserId);
		}
		CustomerForm customerForm=bankCustomerService.findCustomerByUserId(customerUserId);
		if(customerForm==null || customerForm.getEmail()==null){
			SoapFaultMessage faultMessage=new SoapFaultMessage();
			faultMessage.setFaultCode("E1002");
			faultMessage.setDetailMessage("Customers do not exist into the database, please contant to admin");
			//first parameter = high level  description
			CustomerNotFoundException customerNotFoundException=new CustomerNotFoundException("DB Issue",faultMessage);
			throw customerNotFoundException;
		}
		return customerForm;
	}
	
}
