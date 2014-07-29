package com.synergy.bank.customer.web.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import com.sun.java.swing.plaf.motif.resources.motif;
import com.synergy.bank.common.service.BankEmailService;
import com.synergy.bank.common.service.SecurityQuestionService;
import com.synergy.bank.common.service.impl.EmailSenderThread;
import com.synergy.bank.common.web.controller.form.LoginForm;
import com.synergy.bank.common.web.controller.form.SecurityQuestionForm;
import com.synergy.bank.customer.dao.entity.CustomerRegistrationQuestionsEntity;
import com.synergy.bank.customer.service.BankCustomerService;
import com.synergy.bank.customer.service.BankTransactionService;
import com.synergy.bank.customer.service.CustomerAccountService;
import com.synergy.bank.customer.web.constant.NavigationConstant;
import com.synergy.bank.customer.web.controller.form.CustomerAccountForm;
import com.synergy.bank.customer.web.controller.form.CustomerForm;
import com.synergy.bank.customer.web.controller.form.CustomerRegistrationQuestionsForm;
import com.synergy.bank.customer.web.controller.form.CustomerTransactionForm;
import com.synergy.bank.customer.web.controller.form.PayeeDetailsForm;

@Controller
@Scope("request")
public class BankCustomerController {

	@Autowired
	@Qualifier("BankCustomerServiceImpl")
	private BankCustomerService bankCustomerService;

	@Autowired
	@Qualifier("CustomerAccountServiceImpl")
	private CustomerAccountService customerAccountService;

	@Autowired
	@Qualifier("BankEmailServiceImpl")
	private BankEmailService bankEmailService;

	@Autowired
	@Qualifier("BankTransactionServiceImpl")
	private BankTransactionService bankTransactionService;

	@Autowired
	@Qualifier("SecurityQuestionServiceImpl")
	private SecurityQuestionService securityQuestionServiceImpl;

	@RequestMapping(value = "customerRegistration", method = RequestMethod.GET)
	public String showCustomerRegistrationPage(Model model) {
		CustomerForm customerForm = new CustomerForm();

		List<SecurityQuestionForm> securityQuestionList = securityQuestionServiceImpl
				.getRandomQuestions(3);
		List<CustomerRegistrationQuestionsEntity> questionList = new ArrayList<CustomerRegistrationQuestionsEntity>();

		for (SecurityQuestionForm securityQuestion : securityQuestionList) {
			CustomerRegistrationQuestionsEntity customerRegistrationEntity = new CustomerRegistrationQuestionsEntity();
			customerRegistrationEntity.setQuestionId(securityQuestion.getId());
			customerRegistrationEntity.setDescription(securityQuestion
					.getDescription());
			customerRegistrationEntity.setCustomerId(customerForm.getUserId());
			questionList.add(customerRegistrationEntity);
		}

		/*System.out.println("woah iside question list" + questionList);*/

		customerForm.setQuestionList(questionList);

		model.addAttribute("customerForm", customerForm);
		UUID idOne = UUID.randomUUID();
		/*System.out.println("Random Id: " + idOne);*/
		return NavigationConstant.CUSTOMER_PAGE
				+ NavigationConstant.CUSTOMER_REGISTRATION_PAGE;
	}

	@RequestMapping(value = "/customerRegistration", method = RequestMethod.POST)
	public String showCustomerRegistrationSubmit(
			@ModelAttribute(value = "customerForm") CustomerForm customerForm) {
		bankCustomerService.addCustomer(customerForm);
		// here we are making this call asynchronous so we are creating
		EmailSenderThread emailSenderThread = new EmailSenderThread(
				bankEmailService, customerForm.getEmail(),
				"Hello Dear! Ahahahah", "Regarding Registration");
		emailSenderThread.start();
		return NavigationConstant.CUSTOMER_PAGE
				+ NavigationConstant.CUSTOMER_HOME_PAGE;
	}

	@RequestMapping(value = "showPayeeList", method = RequestMethod.GET)
	public String showPayeeList(Model model) {

		String userId = "1";
		List<PayeeDetailsForm> payeeList = bankCustomerService
				.showPayeeListByUserId(userId);
		model.addAttribute("payeeDetailsList", payeeList);
		/*System.out.println(payeeList);*/
		// return "customer/payeeList";
		return NavigationConstant.CUSTOMER_PAGE
				+ NavigationConstant.CUSTOMER_PAYEE_LIST_PAGE;
	}

	@RequestMapping(value = "/editRegistration", method = RequestMethod.GET)
	public String editRegistration(@RequestParam("userId") String userId,
			Model model) {

		CustomerForm customerForm = bankCustomerService
				.findCustomerByUserId(userId);
		model.addAttribute("customerForm", customerForm);
		return NavigationConstant.CUSTOMER_PAGE
				+ NavigationConstant.CUSTOMER_REGISTRATION_PAGE;
	}

	@RequestMapping(value = "/editRegistration", method = RequestMethod.POST)
	public String editRegistrationSubmit(
			@ModelAttribute("customerForm") CustomerForm customerForm) {
		/*System.out.println("Inside edit registration post");*/
		bankCustomerService.updateCustomer(customerForm);
		return "redirect:bank/customerInformation";
	}

	@RequestMapping(value = "/findPhotoById", method = RequestMethod.GET)
	public void findPhotoById(@RequestParam("userId") String userId,
			HttpServletResponse response) throws IOException {

		response.setContentType("image/jpg");
		byte[] photo = bankCustomerService.findPhotoById(userId);
		/*System.out.println("Inside find photo by id");*/
		if (photo != null) {
			System.out.println("found photo");
			ServletOutputStream outputStream = response.getOutputStream();
			outputStream.write(photo);
			outputStream.flush();
		}
	}

	@RequestMapping(value = "customerInformation", method = RequestMethod.GET)
	public String showCustomerInformation(Model model) {
		List<CustomerForm> customerDetailList = bankCustomerService
				.getCustomerListForRowNumbers(0, 5);

		model.addAttribute("pageInformation",
				"0/" + bankCustomerService.getCustomerEntriesCount() / 5);
		model.addAttribute("current_page_number", 0);
		model.addAttribute("customerList", customerDetailList);
		return NavigationConstant.ADMIN_PAGE
				+ NavigationConstant.CUSTOMER_INFORMATION;

	}

	@RequestMapping(value = "deleteCustomer", method = RequestMethod.GET)
	public String deleteCustomerbyId(@RequestParam("userId") String UserId) {
		bankCustomerService.deleteCustomerById(UserId);
		return "bank/customerInformation";
	}

	@RequestMapping(value = "loadNextPage", method = RequestMethod.GET)
	public String loadNextCustomerList(
			@RequestParam("current_page_number") int currentPageNumber,
			Model model) {

		if (currentPageNumber < bankCustomerService.getCustomerEntriesCount() / 5)
			currentPageNumber++;
		else
			currentPageNumber = bankCustomerService.getCustomerEntriesCount();

		List<CustomerForm> customerDetailList = bankCustomerService
				.getCustomerListForRowNumbers(currentPageNumber * 5, 5);

		model.addAttribute("pageInformation", currentPageNumber + "/"
				+ bankCustomerService.getCustomerEntriesCount() / 5);
		model.addAttribute("current_page_number", currentPageNumber);
		model.addAttribute("customerList", customerDetailList);

		return NavigationConstant.ADMIN_PAGE
				+ NavigationConstant.CUSTOMER_INFORMATION;

	}

	@RequestMapping(value = "loadPreviousPage", method = RequestMethod.GET)
	public String loadPreviousCustomerList(
			@RequestParam("current_page_number") int currentPageNumber,
			Model model) {
		if (currentPageNumber > 0)
			currentPageNumber--;
		else
			currentPageNumber = 0;

		List<CustomerForm> customerDetailList = bankCustomerService
				.getCustomerListForRowNumbers(currentPageNumber * 2, 2);

		model.addAttribute("pageInformation", currentPageNumber + "/"
				+ bankCustomerService.getCustomerEntriesCount() / 2);
		model.addAttribute("current_page_number", currentPageNumber);
		model.addAttribute("customerList", customerDetailList);

		return NavigationConstant.ADMIN_PAGE
				+ NavigationConstant.CUSTOMER_INFORMATION;
	}

	@RequestMapping(value = "searchCustomerInformation", method = RequestMethod.GET)
	public String searchCustomerbyAttributeAndValue(
			@RequestParam("searchAttr") String attribute,
			@RequestParam("searchValue") String value, Model model) {

		List<CustomerForm> customerDetailList = bankCustomerService
				.findCustomersByAttributeAndValue(attribute, value);
		model.addAttribute("customerList", customerDetailList);
		return NavigationConstant.ADMIN_PAGE
				+ NavigationConstant.CUSTOMER_INFORMATION;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// to actually be able to convert Multipart instance to byte[]
		// we have to register a custom editor
		binder.registerCustomEditor(byte[].class,
				new ByteArrayMultipartFileEditor());
		// now Spring knows how to handle multipart object and convert them
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// Create a new CustomDateEditor
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
		// Register it as custom editor for the Date type
		binder.registerCustomEditor(Date.class, editor);
	}

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "accountSummary", method = RequestMethod.GET)
	public String showAccountByUserId(Model model) {
		String userId = "aaa111";
		List<CustomerAccountForm> customerAccountForms = customerAccountService
				.findCustomerAccountByUserId(userId);
		model.addAttribute("customerAccountForms", customerAccountForms);

		double totalDeposit = 0;
		double totalLiability = 0;
		Date latestModifyDate = new Date(1900, 1, 1);

		for (int i = 0; i < customerAccountForms.size(); i++) {
			double amt = customerAccountForms.get(i).getAvailBalance();

			if (amt > 0)
				totalDeposit += amt;
			else
				totalLiability += amt;

			if (customerAccountForms.get(i).getDom().after(latestModifyDate))
				latestModifyDate = customerAccountForms.get(i).getDom();
		}

		model.addAttribute("totalDeposit", totalDeposit);
		model.addAttribute("totalLiability", totalLiability);
		model.addAttribute("totalAsset", totalDeposit + totalLiability);
		model.addAttribute("statusOf", latestModifyDate);

		return NavigationConstant.CUSTOMER_PAGE
				+ NavigationConstant.CUSTOMER_ACCOUNT_SUMMARY;
	}

	/*
	 * @RequestMapping(value = "viewMiniStatement", method = RequestMethod.GET)
	 * public String viewMiniStatement(Model model) {
	 * 
	 * String customerAccountNumber = "AAA001"; List<CustomerTransactionForm>
	 * transactionForms = bankTransactionService
	 * .findCustomerTransactionByAccountNumber(customerAccountNumber);
	 * 
	 * model.addAttribute("customerTransactionForms", transactionForms);
	 * 
	 * EmailSenderThread emailSenderThread = new EmailSenderThread(
	 * bankEmailService, "jeffcng@gmail.com", "Hello", "transaction");
	 * emailSenderThread.run();
	 * 
	 * return NavigationConstant.CUSTOMER_PAGE +
	 * NavigationConstant.CUSTOMER_MINI_STATEMENT; }
	 */

	@RequestMapping(value = "viewMiniStatement", method = RequestMethod.GET)
	public String viewMiniStatement(Model model) {

		String customerAccountNumber = "customerAccountNumber";
		String accountNumber = "AAA001";
		List<CustomerTransactionForm> transactionForms = bankTransactionService
				.findCustomerTransactionByAccountNumber(customerAccountNumber,
						accountNumber);

		model.addAttribute("customerTransactionForms", transactionForms);

		EmailSenderThread emailSenderThread = new EmailSenderThread(
				bankEmailService, "jeffcng@gmail.com", "Hello", "transaction");
		emailSenderThread.run();

		return NavigationConstant.CUSTOMER_PAGE
				+ NavigationConstant.CUSTOMER_MINI_STATEMENT;
	}

	@RequestMapping(value = "resetPasswordInit", method = RequestMethod.GET)
	public String resetPasswordInit(Model model, HttpSession session) {
		LoginForm loginForm = (LoginForm) session
				.getAttribute(NavigationConstant.USER_SESSION_DATA);
		List<CustomerRegistrationQuestionsForm> secretQuestions = bankCustomerService
				.findCustomerSecQuestions(loginForm.getUserId());

		for (CustomerRegistrationQuestionsForm questionForm : secretQuestions) {
			System.out.println(questionForm.getAnswer());
		}
		/*String answers = "";
		List<String> answerList = new ArrayList<String>(3);
		model.addAttribute("answers", answers);*/
		model.addAttribute("secretQuestions", secretQuestions);

		return NavigationConstant.CUSTOMER_PAGE
				+ NavigationConstant.CUSTOMER_RESET_PASSWORD_INIT;

	}

	@RequestMapping(value = "resetPasswordInit", method = RequestMethod.POST)
	public String resetPassword(@RequestParam("email") String email,@RequestParam("displayedQuestions") String[] displayedQuestions,@RequestParam("answersByCustomers") String[] answersByCustomers,HttpSession session,Model model) {
		LoginForm loginForm = (LoginForm) session
				.getAttribute(NavigationConstant.USER_SESSION_DATA);
		List<CustomerRegistrationQuestionsForm> secretQuestions = bankCustomerService
				.findCustomerSecQuestions(loginForm.getUserId());
		
		List<String> errorMessage=new ArrayList<String>();
		for(CustomerRegistrationQuestionsForm questionsForm:secretQuestions){
			 for(int p=0;p<displayedQuestions.length;p++){
				 if(displayedQuestions[p].equals(questionsForm.getQuestionId())){
					  if(!questionsForm.getAnswer().equals(answersByCustomers[p])){
						  errorMessage.add(questionsForm.getDescription()+" ,answer = "+
					  answersByCustomers[p]+" is not correct");
					  }
					  break;
				 }
			 }
		}
		String userId = loginForm.getUserId();
		CustomerForm customerForm = bankCustomerService
				.findCustomerByUserId(userId);
		String userEmail = customerForm.getEmail();
		if (errorMessage.size()==0) {
			return NavigationConstant.CUSTOMER_PAGE
					+ NavigationConstant.CUSTOMER_RESET_PASSWORD;
		}else if(errorMessage.size()>0){
			model.addAttribute("errorMessage", errorMessage);
			//List<CustomerRegistrationQuestionsForm> dsecretQuestions = bankCustomerService.findCustomerSecQuestions(loginForm.getUserId());
			model.addAttribute("secretQuestions", secretQuestions);
			return NavigationConstant.CUSTOMER_PAGE
					+ NavigationConstant.CUSTOMER_RESET_PASSWORD_INIT;
		}
		else if (email.length() == 0 && loginForm.getLoginCount() <= 3) {
			return NavigationConstant.CUSTOMER_PAGE
					+ NavigationConstant.CUSTOMER_RESET_PASSWORD;
		} else
			return NavigationConstant.CUSTOMER_PAGE
					+ NavigationConstant.CUSTOMER_ACCOUNT_LOCKED;
	}
}
