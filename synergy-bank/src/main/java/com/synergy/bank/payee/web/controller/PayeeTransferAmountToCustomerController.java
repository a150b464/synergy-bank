package com.synergy.bank.payee.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.synergy.bank.customer.web.constant.NavigationConstant;
import com.synergy.bank.payee.dao.PayeeTransferAmountToCustomerDao;
import com.synergy.bank.payee.dao.entity.PayeeTransferAmountToCustomerEntity;

@Controller
public class PayeeTransferAmountToCustomerController {

	@Autowired
	@Qualifier("PayeeTransferAmountToCustomerDaoImp")
	private PayeeTransferAmountToCustomerDao payeeTransferAmountToCustomerDao;
	
	@RequestMapping(value = "addpayee.do", method = RequestMethod.GET)
	public String addpayee(Model model) {
		PayeeTransferAmountToCustomerEntity payeeTransferAmountToCustomerEntity = new PayeeTransferAmountToCustomerEntity();
		model.addAttribute("addPayeeCommand",payeeTransferAmountToCustomerEntity);
		System.out.println("in controller");
		return NavigationConstant.CUSTOMER_PAGE+NavigationConstant.ADD_PAYEE_PAGE;
	}
	
	@ModelAttribute("acclist")
	public List<String> populateAccType(){
		List<String> accList=new  ArrayList<String>();
		accList.add("Checking");
		accList.add("Saving");
		return accList;
	}
	
	
	@RequestMapping(value = "addpayee.do", method = RequestMethod.POST)
	public String addpayee(@ModelAttribute("addPayeeCommand")PayeeTransferAmountToCustomerEntity payeeTransferAmountToCustomerEntity) {
		System.out.println("in post");
		payeeTransferAmountToCustomerDao.addPayee(payeeTransferAmountToCustomerEntity);
		return NavigationConstant.CUSTOMER_PAGE+NavigationConstant.ADD_PAYEE_PAGE;
	}
}
