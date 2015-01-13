package com.synergy.bank.soap.web.provider;

import java.util.List;

import javax.jws.WebService;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

import com.synergy.bank.customer.service.BankPayeeService;
import com.synergy.bank.customer.web.controller.form.PayeeDetailsForm;
import com.synergy.bank.soap.web.provider.model.PayeeList;



@WebService
public class BankPayeeSoapWebService {

	public PayeeList findAllPayees(){
		ApplicationContext applicationContext=ContextLoader.getCurrentWebApplicationContext();
		BankPayeeService bankPayeeService = (BankPayeeService)applicationContext.getBean("BankPayeeServiceImpl");
		List<PayeeDetailsForm> payeeList = bankPayeeService.findPayees();
		
		PayeeList pList = new PayeeList();
		pList.setPayeeList(payeeList);
		
		return pList;
	}
}
