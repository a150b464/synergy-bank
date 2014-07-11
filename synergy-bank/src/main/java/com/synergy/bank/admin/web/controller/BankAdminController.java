package com.synergy.bank.admin.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import com.synergy.bank.admin.web.constant.NavigationConstantAdmin;
import com.synergy.bank.customer.service.BankAdminService;
import com.synergy.bank.customer.service.BankCustomerService;
import com.synergy.bank.customer.web.controller.form.CustomerForm;


/**
 * 
 * @author Naim
 *
 */

@Controller
public class BankAdminController {
	
	@Autowired
	@Qualifier("BankAdminServiceImpl")
	private BankAdminService bankAdminService;
	
	@RequestMapping(value="showPendingApprovalCustomerList", method=RequestMethod.GET)
	public String findPendingApprovalCustomerList(Model model){
		
		List<CustomerForm> pendingCustomerList = bankAdminService.findPendingCustomerList();
		model.addAttribute("pendingCustomerList",pendingCustomerList);
		
		return NavigationConstantAdmin.ADMIN_PAGE+NavigationConstantAdmin.PENDING_APPROVAL_CUSTOMER_LIST_PAGE ;
	}
	
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// to actually be able to convert Multipart instance to byte[]
		// we have to register a custom editor
		binder.registerCustomEditor(byte[].class,
					new ByteArrayMultipartFileEditor());
		// now Spring knows how to handle multipart object and convert them
	}
}
