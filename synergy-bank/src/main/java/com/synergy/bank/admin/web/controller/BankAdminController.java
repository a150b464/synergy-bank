package com.synergy.bank.admin.web.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.synergy.bank.admin.service.BankAdminService;
import com.synergy.bank.admin.web.constant.NavigationConstantAdmin;
import com.synergy.bank.admin.web.controller.form.ApprovedCustomerForm;
import com.synergy.bank.admin.web.controller.form.GallaryPhotoForm;
import com.synergy.bank.common.service.BankEmailService;
import com.synergy.bank.common.service.impl.EmailSenderThread;
import com.synergy.bank.customer.web.controller.CreditForm;
import com.synergy.bank.customer.web.controller.form.CustomerAccountForm;
import com.synergy.bank.customer.web.controller.form.CustomerForm;

/**
 * 
 * @author Naim
 * 
 *         this is just change
 * 
 */

@Controller
@Scope("request")
public class BankAdminController {

	@Autowired
	@Qualifier("BankAdminServiceImpl")
	private BankAdminService bankAdminService;

	@Autowired
	@Qualifier("BankEmailServiceImpl")
	private BankEmailService bankEmailService;
	
	
	
	@RequestMapping(value = "uploadNewPhoto.do", method = RequestMethod.POST)
	public String uploadNewPhoto(@ModelAttribute("gallaryPhotoForm") GallaryPhotoForm gallaryPhotoForm,Model model,HttpServletRequest request) {
		InputStream in = new ByteArrayInputStream(gallaryPhotoForm.getImage());
        BufferedImage image;
		try {
			image = ImageIO.read(in);
			String afileName = request.getSession().getServletContext().getRealPath("/images/" + gallaryPhotoForm.getPath());
			 ImageIO.write(image, "jpg",new File(afileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		///Here we have to write logix
		return NavigationConstantAdmin.ADMIN_PAGE
				+ NavigationConstantAdmin.ADMIN_HOME_PAGE;
	}
	
	@RequestMapping(value = "changeImage.do", method = RequestMethod.POST)
	public String changeImage(@RequestParam("imageName") String pimageName,Model model) {
		GallaryPhotoForm gallaryPhotoForm=new GallaryPhotoForm();
		gallaryPhotoForm.setPath(pimageName);
		model.addAttribute("gallaryPhotoForm",gallaryPhotoForm);
		return NavigationConstantAdmin.ADMIN_PAGE
				+ NavigationConstantAdmin.CHANGE_IMAGE_ADMIN_PAGE;
	}
		

	@RequestMapping(value = "showPendingApprovalCreditCardList", method = RequestMethod.GET)
	public String findPendingApprovalCreditCardList(Model model) {
		List<CreditForm> pendingCreditCardList = bankAdminService.findPendingCreditCardList();
		model.addAttribute("pendingCreditCardList", pendingCreditCardList);
		return NavigationConstantAdmin.ADMIN_PAGE
				+ NavigationConstantAdmin.PENDING_APPROVAL_CREDITCARD_LIST_PAGE;
	}
	
	@RequestMapping(value = "showPhotoById", method = RequestMethod.GET)
	public void showPhotoById(@RequestParam("userId") String userId, HttpServletResponse response) throws IOException {
		byte[] customerphoto =bankAdminService.findCustomerPhotoById(userId);
		response.setContentType("image/jpg");
		ServletOutputStream outputStream=response.getOutputStream();
		if(customerphoto!=null){
			outputStream.write(customerphoto);
		}else{
			outputStream.write(new byte[]{});
		}
		//outputStream.write(frogphoto);
		outputStream.flush();
		outputStream.close();
	}
	

//	@RequestMapping(value = "approvePendingCreditCard", method = RequestMethod.POST)
//	public String approvePendingCreditCards(
//			@RequestParam("approveCheckbox") String[] selectedCreditCardsUserIds,
//			final RedirectAttributes redirectAttributes) {
//		// public String
//		// approvePendingCustomers(@RequestParam("approveCheckbox") String[]
//		// approvedIds){
//		String msg = "Message";
//		if (selectedCreditCardsUserIds != null
//				&& selectedCreditCardsUserIds.length > 0) {
//			List<CreditCardAccountForm> customerAccountForms = bankAdminService
//					.approvePendingCreditCard(selectedCreditCardsUserIds);
//			if (customerAccountForms == null) {
//				msg = "Failed to approve customer.";
//			} else if (customerAccountForms.size() > 0) {
//				for (CustomerAccountForm customerAccountForm : customerAccountForms) {
//					String body = "Dear Customer \n\n Your Account with Name :"
//							+ customerAccountForm.getCustomerName()
//							+ " "
//							+ "and Account No. "
//							+ customerAccountForm.getCustomerAccountNo()
//							+ " is been created. \n\n Thanks for banking with Synergy Bank.";
//					EmailSenderThread emailSenderThread = new EmailSenderThread(
//							bankEmailService,
//							customerAccountForm.getCustomerEmail(), body,
//							"Account creation notification !");
//					emailSenderThread.start();
//				}
//				msg = selectedCustomerUserIds.length
//						+ " new customer(s) are approved successfully.";
//			}
//		} else {
//			msg = "No customer was selected for approval.";
//		}
//
//		redirectAttributes.addFlashAttribute("msg", msg);
//		return "redirect:showPendingApprovalCustomerList";
//	}
//	
	@RequestMapping(value = "showPendingApprovalCustomerList", method = RequestMethod.GET)
	public String findPendingApprovalCustomerList(Model model) {
		List<CustomerForm> pendingCustomerList = bankAdminService
				.findPendingCustomerList();
		model.addAttribute("pendingCustomerList", pendingCustomerList);
		return NavigationConstantAdmin.ADMIN_PAGE
				+ NavigationConstantAdmin.PENDING_APPROVAL_CUSTOMER_LIST_PAGE;
	}

	@RequestMapping(value = "approvePendingCustomers", method = RequestMethod.POST)
	public String approvePendingCustomers(
			@RequestParam("approveCheckbox") String[] selectedCustomerUserIds,
			final RedirectAttributes redirectAttributes) {
		// public String
		// approvePendingCustomers(@RequestParam("approveCheckbox") String[]
		// approvedIds){
		String msg = "Message";
		if (selectedCustomerUserIds != null
				&& selectedCustomerUserIds.length > 0) {
			List<CustomerAccountForm> customerAccountForms = bankAdminService
					.approvePendingCustomers(selectedCustomerUserIds);
			if (customerAccountForms == null) {
				msg = "Failed to approve customer.";
			} else if (customerAccountForms.size() > 0) {
				for (CustomerAccountForm customerAccountForm : customerAccountForms) {
					String body = "Dear Customer \n\n Your Account with Name :"
							+ customerAccountForm.getCustomerName()
							+ " "
							+ "and Account No. "
							+ customerAccountForm.getCustomerAccountNo()
							+ " is been created. \n\n Thanks for banking with Synergy Bank.";
					EmailSenderThread emailSenderThread = new EmailSenderThread(
							bankEmailService,
							customerAccountForm.getCustomerEmail(), body,
							"Account creation notification !");
					emailSenderThread.start();
				}
				msg = selectedCustomerUserIds.length
						+ " new customer(s) are approved successfully.";
			}
		} else {
			msg = "No customer was selected for approval.";
		}

		redirectAttributes.addFlashAttribute("msg", msg);
		return "redirect:showPendingApprovalCustomerList";
	}
	
	
	

	@RequestMapping(value = "customers", method = RequestMethod.GET)
	public String showApprovedCustomerList(Model model) {
		List<ApprovedCustomerForm> approvedCustomerList = bankAdminService
				.findApprovedCustomerList();
		model.addAttribute("approvedCustomerList", approvedCustomerList);
		return NavigationConstantAdmin.ADMIN_PAGE
				+ NavigationConstantAdmin.BLOCK_CUSTOMER_LIST_PAGE;
	}

	@RequestMapping(value = "blockCustomers", method = RequestMethod.POST)
	public String blockCustomer(
			@RequestParam("blockCheckbox") String[] blockedIds,
			final RedirectAttributes redirectAttributes) {
		String msg = "Message";
		System.out.println(blockedIds);
		if (blockedIds.length > 0) {

			if (!bankAdminService.blockCustomer(blockedIds)) {
				msg = "Failed to block customer.";
			} else {
				msg = blockedIds.length
						+ " customer(s) are blocked successfully.";
			}
		}

		else {
			msg = "No customer was selected to block";
		}
		redirectAttributes.addFlashAttribute("msg", msg);
		return NavigationConstantAdmin.ADMIN_PAGE
				+ NavigationConstantAdmin.BLOCK_CUSTOMER_LIST_PAGE;
	}

	@RequestMapping(value = "lockUnlockCustomers", method = RequestMethod.GET)
	@ResponseBody
	public String lockUnlockCustomers(@RequestParam("puserid") String puserid,
			@RequestParam("pstatus") String status, Model model) {
		boolean result = bankAdminService.lockUnlockCustomer(puserid, status);
		return result == true ? "yes" : "no";
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
