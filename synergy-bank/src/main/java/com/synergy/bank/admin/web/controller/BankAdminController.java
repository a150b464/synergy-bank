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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.synergy.bank.admin.service.BankAdminService;
import com.synergy.bank.admin.web.constant.NavigationConstantAdmin;
import com.synergy.bank.common.service.BankEmailService;
import com.synergy.bank.common.service.impl.EmailSenderThread;
import com.synergy.bank.customer.web.controller.form.CustomerAccountForm;
import com.synergy.bank.customer.web.controller.form.CustomerForm;


/**
 * 
 * @author Naim
 * 
 * this is just change
 *
 */

@Controller
public class BankAdminController {
	
	@Autowired
	@Qualifier("BankAdminServiceImpl")
	private BankAdminService bankAdminService;
	
	@Autowired
	@Qualifier("BankEmailServiceImpl")
	private BankEmailService bankEmailService;
	
	@RequestMapping(value="showPendingApprovalCustomerList", method=RequestMethod.GET)
	public String findPendingApprovalCustomerList(Model model){
		
		List<CustomerForm> pendingCustomerList = bankAdminService.findPendingCustomerList();
		model.addAttribute("pendingCustomerList",pendingCustomerList);
		return NavigationConstantAdmin.ADMIN_PAGE+NavigationConstantAdmin.PENDING_APPROVAL_CUSTOMER_LIST_PAGE ;
	}
	
	@RequestMapping(value="approvePendingCustomers", method=RequestMethod.POST)
	public String approvePendingCustomers(@RequestParam("approveCheckbox") String[] approvedIds, 
			final RedirectAttributes redirectAttributes){
		
		String msg="";
		if(approvedIds.length>0){
			List<CustomerAccountForm> customerAccountForms =  bankAdminService.approvePendingCustomers(approvedIds);
			if(customerAccountForms==null){
				msg = "Failed to approve customer.";
			}
			else  if(customerAccountForms.size()>0){
				for (CustomerAccountForm customerAccountForm : customerAccountForms) {
					String body = "Dear Customer \n\n Your Account with Name :"+customerAccountForm.getCustomerName()+" " +
							"and Account No. "+customerAccountForm.getCustomerAccountNo()+" is been created. \n\n Thanks for banking with Synergy Bank.";
					EmailSenderThread emailSenderThread=new EmailSenderThread(bankEmailService, customerAccountForm.getCustomerEmail(), body, "Account creation notification !");
					emailSenderThread.start();
				}
				msg = approvedIds.length+" new customer(s) are approved successfully.";
			}
		}
		else{
			msg = "No customer was selected for approval.";
		}
		System.out.println(msg);
		redirectAttributes.addFlashAttribute("msg", msg);
		return "redirect:showPendingApprovalCustomerList";
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
