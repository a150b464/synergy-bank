package com.synergy.bank.customer.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.synergy.bank.common.dao.BankJdbcDao;
import com.synergy.bank.common.dao.SecurityQuestionDao;
import com.synergy.bank.customer.dao.BankCustomerDao;
import com.synergy.bank.customer.dao.entity.CustomerEntity;
import com.synergy.bank.customer.dao.entity.CustomerLoginDetailEntity;
import com.synergy.bank.customer.dao.entity.CustomerRegistrationQuestionsEntity;
import com.synergy.bank.customer.dao.entity.PayeeDetailsEntity;
import com.synergy.bank.customer.dao.impl.BankCustomerLoginHibernateDaoImpl;
import com.synergy.bank.customer.service.BankCustomerService;
import com.synergy.bank.customer.web.controller.form.CustomerForm;
import com.synergy.bank.customer.web.controller.form.CustomerRegistrationQuestionsForm;
import com.synergy.bank.customer.web.controller.form.PayeeDetailsForm;

@Service("BankCustomerServiceImpl")
@Scope("singleton")
public class BankCustomerServiceImpl implements BankCustomerService {

	@Autowired
	@Qualifier("BankCustomerHibernateDaoImpl")
	private BankCustomerDao bankCustomerDao;

	@Autowired
	@Qualifier("BankCustomerLoginHibernateDaoImpl")
	private BankCustomerLoginHibernateDaoImpl bankCustomerLoginHibernateDaoImpl;

	@Autowired
	@Qualifier("BankCustomerDaoImpl")
	private BankCustomerDao bankCustomerDaoSJdbc;

	@Autowired
	@Qualifier("BankJdbcDaoImpl")
	private BankJdbcDao bankJdbcDao;

	@Autowired
	@Qualifier("SecurityQuestionDaoImpl")
	private SecurityQuestionDao securityQuestionDao;

	@Override
	public String addCustomer(CustomerForm customerForm) {
		System.out.println("inside add cus+" + customerForm);
		// char[] password=bankJdbcDao.generatePassword();
		String userid = bankJdbcDao.nextUserID();
		customerForm.setUserId(userid);
		// customerForm.setPassword(String.valueOf(password));
		customerForm.setPassword("1");
		CustomerEntity customerEntity = new CustomerEntity();
		// attribute and datatype should be match
		BeanUtils.copyProperties(customerForm, customerEntity);
		CustomerLoginDetailEntity customerLoginDetailEntity = new CustomerLoginDetailEntity();
		customerLoginDetailEntity.setUserId(customerForm.getUserId());
		customerLoginDetailEntity.setActive("no");
		customerLoginDetailEntity.setApprove("no");
		customerLoginDetailEntity.setCreatedDate(new Date());
		customerLoginDetailEntity.setDescription("new user");
		customerLoginDetailEntity.setLoginCount(0);
		customerLoginDetailEntity.setLoginId(customerForm.getUserId());
		customerLoginDetailEntity.setModifiedDate(new Date());
		customerLoginDetailEntity.setNumberOfAttempt(0);
		customerLoginDetailEntity.setOldPassword(customerForm.getPassword());
		customerLoginDetailEntity.setPassword(customerForm.getPassword());
		customerLoginDetailEntity.setRole("customer");

		/*
		 * List<SecurityQuestionEntity> securityQuestionList =
		 * securityQuestionDao.getRandomSecurityQuestions(3);
		 * Set<CustomerRegistrationQuestionsEntity> questionSet = new
		 * HashSet<CustomerRegistrationQuestionsEntity>();
		 * 
		 * for(SecurityQuestionEntity securityQuestion:securityQuestionList) {
		 * CustomerRegistrationQuestionsEntity customerRegistrationEntity = new
		 * CustomerRegistrationQuestionsEntity();
		 * customerRegistrationEntity.setQuestionId(securityQuestion.getId());
		 * customerRegistrationEntity
		 * .setDescription(securityQuestion.getDescription());
		 * customerRegistrationEntity.setCustomerId(customerForm.getUserId());
		 * questionSet.add(customerRegistrationEntity); }
		 */
		bankCustomerLoginHibernateDaoImpl.save(customerLoginDetailEntity);

		bankCustomerDao.addCustomer(customerEntity);
		return "success";
	}

	public String updateCustomer(CustomerForm customerForm) {
		System.out.println("inside add cus+" + customerForm);
		/*
		 * char[] password=bankJdbcDao.generatePassword(); String
		 * userid=bankJdbcDao.nextUserID(); customerForm.getUserId()(userid);
		 * customerForm.setPassword(new String(password));
		 */
		CustomerEntity customerEntity = new CustomerEntity();
		// attribute and datatype should be match
		BeanUtils.copyProperties(customerForm, customerEntity);
		CustomerLoginDetailEntity customerLoginDetailEntity = new CustomerLoginDetailEntity();
		customerLoginDetailEntity.setUserId(customerForm.getUserId());
		customerLoginDetailEntity.setActive("no");
		customerLoginDetailEntity.setApprove("no");
		customerLoginDetailEntity.setCreatedDate(new Date());
		customerLoginDetailEntity.setDescription("password Changed");
		customerLoginDetailEntity.setLoginCount(1);
		customerLoginDetailEntity.setLoginId(customerForm.getUserId());
		customerLoginDetailEntity.setModifiedDate(new Date());
		customerLoginDetailEntity.setNumberOfAttempt(0);
		customerLoginDetailEntity.setOldPassword(customerForm.getPassword());
		customerLoginDetailEntity.setPassword(customerForm.getPassword());
		customerLoginDetailEntity.setRole("customer");
		bankCustomerLoginHibernateDaoImpl.save(customerLoginDetailEntity);
		bankCustomerDao.addCustomer(customerEntity);
		return "success";
	}

	/*
	 * @Override public String updateCustomer(CustomerForm customerForm) {
	 * CustomerEntity entity=new CustomerEntity();
	 * BeanUtils.copyProperties(customerForm,entity);
	 * bankCustomerDao.updateCustomer(entity); return null; }
	 */

	@Override
	public List<CustomerForm> findCustomers() {

		System.out
				.println("---------Entered in FindCustomers() method of customerServiceImpl--------");
		List<CustomerEntity> customerEntityList = bankCustomerDao
				.findCustomers();
		List<CustomerForm> customerFormList = new ArrayList<CustomerForm>(
				customerEntityList.size());

		for (int i = 0; i < customerEntityList.size(); i++) {
			CustomerForm customerForm = new CustomerForm();
			BeanUtils.copyProperties(customerEntityList.get(i), customerForm);
			customerFormList.add(customerForm);
		}
		System.out.println("Printing from customerServiceImpl "
				+ customerFormList);
		return customerFormList;
	}

	@Override
	public CustomerForm findCustomerByUserId(String userid) {
		CustomerForm customerForm = new CustomerForm();
		BeanUtils.copyProperties(bankCustomerDao.findCustomerByUserId(userid),
				customerForm);

		return customerForm;
	}

	@Override
	public List<PayeeDetailsForm> showPayeeListByUserId(String userId) {

		List<PayeeDetailsEntity> payeeList = bankCustomerDaoSJdbc
				.showPayeeListByUserId(userId);
		System.out.println(payeeList);
		List<PayeeDetailsForm> payeeListForms = new ArrayList<PayeeDetailsForm>();

		for (PayeeDetailsEntity pde : payeeList) {
			PayeeDetailsForm pdf = new PayeeDetailsForm();
			BeanUtils.copyProperties(pde, pdf);
			payeeListForms.add(pdf);
		}

		return payeeListForms;
	}

	@Override
	public String deleteCustomerById(String userId) {
		bankCustomerDao.deleteCustomer(bankCustomerDao
				.findCustomerByUserId(userId));
		return "success";
	}

	@Override
	public List<CustomerForm> getCustomerListForRowNumbers(
			int initialRowNumber, int maximumRowNumbers) {

		System.out
				.println("---------Entered in ListFor RowNumbers methods------");

		List<CustomerEntity> customerEntityList = bankCustomerDao
				.getCustomerListForRowNumbers(initialRowNumber,
						maximumRowNumbers);
		List<CustomerForm> customerFormList = new ArrayList<CustomerForm>(
				customerEntityList.size());

		for (int i = 0; i < customerEntityList.size(); i++) {
			CustomerForm customerForm = new CustomerForm();
			BeanUtils.copyProperties(customerEntityList.get(i), customerForm);
			customerFormList.add(customerForm);
		}
		return customerFormList;
	}

	@Override
	public List<CustomerForm> findCustomersByAttributeAndValue(
			String attribute, String value) {
		List<CustomerEntity> customerEntityList = bankCustomerDao
				.findCustomerByColumnNameAndValue(attribute, value);
		List<CustomerForm> customerFormList = new ArrayList<CustomerForm>(
				customerEntityList.size());

		for (int i = 0; i < customerEntityList.size(); i++) {
			CustomerForm customerForm = new CustomerForm();
			BeanUtils.copyProperties(customerEntityList.get(i), customerForm);
			customerFormList.add(customerForm);
		}
		return customerFormList;
	}

	@Override
	public byte[] findPhotoById(String userId) {
		return bankCustomerDao.findPhotoById(userId);
	}

	@Override
	public int getCustomerEntriesCount() {

		return bankCustomerDao.getCount();
	}

	@Override
	public void updateCustomersnewLoginIdAndPassword(String userId,
			String password) {
		// TODO Auto-generated method stub

	}

	public List<CustomerRegistrationQuestionsForm> findCustomerSecQuestions(
			String userid) {

		List<CustomerRegistrationQuestionsEntity> customerRegistrationQuestionsEntities = bankCustomerDaoSJdbc
				.findCustomerSecQuestions(userid);
		List<CustomerRegistrationQuestionsForm> customerRegistrationQuestionsForms = new ArrayList<CustomerRegistrationQuestionsForm>();

		for (CustomerRegistrationQuestionsEntity customerRegistrationQuestionsEntity : customerRegistrationQuestionsEntities) {
			CustomerRegistrationQuestionsForm customerRegistrationQuestionsForm = new CustomerRegistrationQuestionsForm();
			BeanUtils.copyProperties(customerRegistrationQuestionsEntity,
					customerRegistrationQuestionsForm);
			customerRegistrationQuestionsForms
					.add(customerRegistrationQuestionsForm);
		}
		System.out.println("Service: " + customerRegistrationQuestionsForms);
		return customerRegistrationQuestionsForms;
	}

}
