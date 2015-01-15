package com.synergy.bank.customer.web.controller;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.synergy.bank.common.service.BankEmailService;
import com.synergy.bank.common.service.impl.EmailSenderThread;
import com.synergy.bank.common.web.controller.form.LoginForm;
import com.synergy.bank.customer.service.BankCustomerService;
import com.synergy.bank.customer.service.BankPayeeService;
import com.synergy.bank.customer.web.constant.ApplicationMessageConstant;
import com.synergy.bank.customer.web.constant.ApplicationStatus;
import com.synergy.bank.customer.web.constant.NavigationConstant;
import com.synergy.bank.customer.web.controller.form.CustomerForm;
import com.synergy.bank.customer.web.controller.form.CustomerTransactionForm;
import com.synergy.bank.customer.web.controller.form.PayeeDetailsForm;

@Controller
public class BankPayeeCustomerController {

	@Autowired
	@Qualifier("BankPayeeServiceImpl")
	private BankPayeeService bankPayeeService;
	
	@Autowired
	@Qualifier("BankCustomerServiceImpl")
	private BankCustomerService bankCustomerService;

	@Autowired
	@Qualifier("BankEmailServiceImpl")
	private BankEmailService bankEmailService;

	// Add PayeeAccountNumber Methods for Ajax Validation
	@RequestMapping(value = "checkPayeeAccountNo.do", method = RequestMethod.GET)
	public @ResponseBody String checkPayeeAccountNo(
			@RequestParam("ppayeeAccountNumber") String payeeAccountNumber) {
		String result = bankPayeeService
				.checkPayeeAccountNumber(payeeAccountNumber);
		// @ResponseBody =>>by pass view resolver and write this data directly
		// into the response body
		return result;
	}

	/**
	 * @method checks for payee name exists or not
	 * @param payeeName
	 * @return string
	 */
	@RequestMapping(value = "checkPayeeName.do", method = RequestMethod.GET)
	public @ResponseBody String checkPayeeName(
			@RequestParam("ppayeeName") String payeeName,@RequestParam("ppayeeAccount") String ppayeeAccount,HttpSession session) {
		/*LoginForm loginForm=(LoginForm)session.getAttribute(NavigationConstant.USER_SESSION_DATA);
		String userid=loginForm.getUserId();*/
		String result = bankPayeeService.checkPayeeName(payeeName, ppayeeAccount);
		// @ResponseBody =>>by pass view resolver and write this data directly
		// into the response body
		return result;
	}

	// Add Payee Methods
	 @RequestMapping(value = "addpayee.do", method = RequestMethod.GET)
	public String addpayee(Model model,HttpSession session) {
        LoginForm loginForm=(LoginForm)session.getAttribute(NavigationConstant.USER_SESSION_DATA);
        String userid=loginForm.getUserId();
        CustomerForm customerForm=bankCustomerService.findCustomerByUserId(userid);
  
        PayeeDetailsForm payeeDetailsForm = new PayeeDetailsForm();
        payeeDetailsForm.setEmail(customerForm.getEmail());
        String mobile=customerForm.getMobile();
        session.setAttribute("smobile", mobile);
        if(mobile!=null && mobile.length()>2){
            //988777
            mobile=mobile.substring(mobile.length()-2);
        }else{
            mobile="xxx";
        }
        payeeDetailsForm.setMobile("********"+mobile);
        model.addAttribute("addPayeeCommand", payeeDetailsForm);
        /* System.out.println("in controller"); */
        return NavigationConstant.CUSTOMER_PAGE
                 + NavigationConstant.ADD_PAYEE_PAGE;
   }
	 
	 @RequestMapping(value = "showPayeeList.do", method = RequestMethod.GET)
		public String findAllPayees(Model model,HttpSession session) {
		 LoginForm loginForm=(LoginForm)session.getAttribute(NavigationConstant.USER_SESSION_DATA);
	        String userid=loginForm.getUserId();
		 List<PayeeDetailsForm> payeeDetailsFormList = bankPayeeService.findAllPayees(userid);
		 model.addAttribute("showPayeeList", payeeDetailsFormList);
		 return NavigationConstant.CUSTOMER_PAGE + NavigationConstant.CUSTOMER_PAYEE_LIST_PAGE;
	 }
	 
	 @RequestMapping(value = "/findPhotoByEmail", method = RequestMethod.GET)
		public void findPhotoByEmail(@RequestParam("email") String email,
				HttpServletResponse response) throws IOException {
			response.setContentType("image/jpg");
			byte[] photo = bankPayeeService.findPhotoByEmail(email);
			/*System.out.println("Inside find photo by id");*/
			if (photo != null) {
				System.out.println("found photo");
				ServletOutputStream outputStream = response.getOutputStream();
				outputStream.write(photo);
				outputStream.flush();
				outputStream.close();
			}
		}
	 
	 @RequestMapping(value = "/findPhotoByUserId", method = RequestMethod.GET)
		public void findPhotoByUsedId(Model model, HttpServletResponse response, HttpSession session) throws IOException {
		 LoginForm loginForm=(LoginForm)session.getAttribute(NavigationConstant.USER_SESSION_DATA);
	        String userId=loginForm.getUserId();
		 	response.setContentType("image/jpg");
			byte[] photo = bankPayeeService.findPhotoByUsedId(userId);
			/*System.out.println("Inside find photo by id");*/
			if (photo != null) {
				System.out.println("found photo");
				ServletOutputStream outputStream = response.getOutputStream();
				outputStream.write(photo);
				outputStream.flush();
				outputStream.close();
			}
		}
	 
	 /**
	    * Handle request to download an Excel document
	    */
	   @RequestMapping(value = "/downloadExcel", method = RequestMethod.GET)
	   public ModelAndView downloadExcel(HttpSession session,Model model) {
		   LoginForm loginForm=(LoginForm)session.getAttribute(NavigationConstant.USER_SESSION_DATA);
	       String userid=loginForm.getUserId();
		   List<PayeeDetailsForm> listPayee = bankPayeeService.findAllPayees(userid);
		   //model.addAttribute("payeeList", listPayee);                  
	       // return a view which will be resolved by an excel view resolver
	       return new ModelAndView("excelView", "listPayee", listPayee);
	   }
	   
	   /**
	    * Handle request to download an Excel document
	    */
	   @RequestMapping(value = "/downloadPDF", method = RequestMethod.GET)
	   public ModelAndView downloadPDF(HttpSession session,Model model) {
		   LoginForm loginForm=(LoginForm)session.getAttribute(NavigationConstant.USER_SESSION_DATA);
	       String userid=loginForm.getUserId();
		   List<PayeeDetailsForm> listPayee = bankPayeeService.findAllPayees(userid);
		   //model.addAttribute("payeeList", listPayee);                  
	       // return a view which will be resolved by an excel view resolver
	       return new ModelAndView("pdfView", "listPayee", listPayee);
	   }
	 
	 @RequestMapping( value = "ajaxDeleteRow", method = RequestMethod.GET)
		public @ResponseBody String ajaxDeleteRowByUserId(@RequestParam("userid") String userid){
			String message = bankPayeeService.deletePayeeRowById(userid);
			return "done";
		}
	 
	 @RequestMapping(value="editPayeeById",method=RequestMethod.GET)
		public String editPayeeById(@RequestParam("userid") String userid, Model model){
			model.addAttribute("EditPayeeForm", bankPayeeService.findAllPayeesByUserId(userid));
			return NavigationConstant.CUSTOMER_PAGE + NavigationConstant.EDIT_PAYEE_TABLE;
			
		}
	 

   @RequestMapping(value = "addpayee.do", method = RequestMethod.POST)
   public String addpayee(
            @ModelAttribute("addPayeeCommand") PayeeDetailsForm payeeDetailsForm,
            Model model, HttpSession session) {
        String mobile=(String)session.getAttribute("smobile");
        payeeDetailsForm.setMobile(mobile);
        session.removeAttribute("smobile");
       
        //String userId = "customer";
        LoginForm loginForm=(LoginForm)session.getAttribute(NavigationConstant.USER_SESSION_DATA);
        String userid=loginForm.getUserId();
        if (bankPayeeService.isPayeeExists(userid,
                 payeeDetailsForm.getPayeeAccountNo())) {
            model.addAttribute("message", ApplicationMessageConstant.THIS_PAYEE_ALREADY_EXISTS);
            return NavigationConstant.CUSTOMER_PAGE
                      + NavigationConstant.ADD_PAYEE_PAGE;
        } else {
			payeeDetailsForm.setDoe(new Date());
			payeeDetailsForm.setUserid(userid);
			payeeDetailsForm.setStatus(ApplicationStatus.PENDING.value());
			bankPayeeService.addPayee(payeeDetailsForm);
			model.addAttribute("payeeDetailsForm", payeeDetailsForm);
			// Random Number Generator
			Random generator = new Random();
			int genPin = generator.nextInt(999999);
			
			session.setAttribute("verificationPin", genPin);
			System.out.println("____GENEREDTED PIN IS  ==="+genPin);
			EmailSenderThread emailSenderThread = new EmailSenderThread(
					bankEmailService, payeeDetailsForm.getEmail(), "Hello "
							+ payeeDetailsForm.getPayeeName()
							+ "! Your Registration Verification Pin is:   "
							+ genPin, "Verification Pin Number");
			emailSenderThread.start();
			
			return NavigationConstant.CUSTOMER_PAGE
					+ NavigationConstant.CONFIRM_PAYEE_PAGE;
		}

	}

	@RequestMapping(value = "confirmpayee.do", method = RequestMethod.POST)
	public String confirmpayee(
			@ModelAttribute("confirmPayeeCommand") PayeeDetailsForm payeeDetailsForm,
			HttpServletRequest request, HttpSession sess, Model model) {
		int genPin = Integer.parseInt(request.getParameter("verificationCode"));
		//String userId = "admin";
		 LoginForm loginForm=(LoginForm)sess.getAttribute(NavigationConstant.USER_SESSION_DATA);
	      String userid=loginForm.getUserId();
	        
		int enteredPin = (Integer) sess.getAttribute("verificationPin");
		if (genPin == enteredPin) {
			String errorMessage = payeeDetailsForm.getPayeeName()+" has been approved now, you can transefer money to him.";
			model.addAttribute("errormessage", errorMessage);
			String status=bankPayeeService.confirmPayee(payeeDetailsForm.getPayeeAccountNo(),
					userid);
			System.out.println("____status____=>>"+status);
			sess.removeAttribute("verificationPin");
			return NavigationConstant.CUSTOMER_PAGE
					+ NavigationConstant.CUSTOMER_HOME_PAGE;
		}
		String errorMessage = "Verification Pin Not Valid. Please Contact the Customer Service to generate a new Verification Pin!!!";
		model.addAttribute("errormessage", errorMessage);
		return NavigationConstant.CUSTOMER_PAGE
				+ NavigationConstant.CONFIRM_PAYEE_PAGE;
		// return NavigationConstant.CUSTOMER_PAGE
		// + NavigationConstant.VERIFICATION_PIN_NOT_VALID;

	}

	public String isPayeeExists() {

		if (bankPayeeService.isPayeeExists("admin", "400")) {
			System.out.println("Exists");
		} else {
			System.out.println("Does not exist");
		}

		return "";
	}

	@RequestMapping(value = "selectPayee", method = RequestMethod.GET)
	public String selectPayee(HttpSession session,Model model) {
		CustomerTransactionForm customerTransactionCommand = new CustomerTransactionForm();
		LoginForm loginForm=(LoginForm)session.getAttribute(NavigationConstant.USER_SESSION_DATA);
		String userid=loginForm.getUserId();
		
		List<PayeeDetailsForm> payeeDetailsFormList = bankPayeeService
				.findPayeeByUserId(userid);
		
		Map<String, String> payeeList = new LinkedHashMap<String, String>();
		for (PayeeDetailsForm detailsForm : payeeDetailsFormList) {
			payeeList.put(
					detailsForm.getPayeeAccountNo(),
					detailsForm.getPayeeName() + " - "
							+ detailsForm.getPayeeAccountNo());
		}
		model.addAttribute("payeeDetailsFormList",payeeList);

		model.addAttribute("customerTransactionCommand",
				customerTransactionCommand);
		return NavigationConstant.CUSTOMER_PAGE
				+ NavigationConstant.SELECT_PAYEE;
	}
}
