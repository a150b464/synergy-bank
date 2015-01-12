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
import com.synergy.bank.util.BankPasswordGenUtil;
import com.synergy.bank.util.PasswordGenerator;

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
		String userIdAndPassword="";
		System.out.println("inside add cus+" + customerForm);
		// char[] password=bankJdbcDao.generatePassword();
		String userid = bankJdbcDao.nextUserID();
		customerForm.setUserId(userid);
		userIdAndPassword="Bank userid ="+userid;
		// customerForm.setPassword(String.valueOf(password));
		
		//Generating the password for four characters
		 int passwordSize = 4;
	    // PasswordGenerator password = new PasswordGenerator( passwordSize );
	     //String genpass=new String(password.get());
		 BankPasswordGenUtil msr = new BankPasswordGenUtil();
	     String genpass=msr.generateRandomString();
	     System.out.println("****************************************************");
	     System.out.println("generated password is- ("+genpass+")____________");
	     System.out.println("****************************************************");
		customerForm.setPassword(genpass);
		userIdAndPassword=userIdAndPassword+" , password = "+genpass;
		
		CustomerEntity customerEntity = new CustomerEntity();
		// attribute and datatype should be match
		BeanUtils.copyProperties(customerForm, customerEntity);
		customerEntity.setApprove("no");
		
		CustomerLoginDetailEntity customerLoginDetailEntity = new CustomerLoginDetailEntity();
		customerLoginDetailEntity.setUserId(customerForm.getUserId());
		customerLoginDetailEntity.setActive("yes");
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
		
		//This code is not running running within a single transaction
		//This code we have to change so that both  query can run as part of
		//single transaction.............
		bankCustomerLoginHibernateDaoImpl.save(customerLoginDetailEntity);
		bankCustomerDao.addCustomer(customerEntity);
		
		return userIdAndPassword;
	}

	public String updateCustomer(CustomerForm customerForm) {
		//System.out.println("inside add cus+" + customerForm);
		CustomerEntity customerEntity = new CustomerEntity();
		
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

	@Override
	public List<CustomerForm> findCustomers() {

/*		System.out.println("---------Entered in FindCustomers() method of customerServiceImpl--------");
*/		List<CustomerEntity> customerEntityList = bankCustomerDao
				.findCustomers();
		List<CustomerForm> customerFormList = new ArrayList<CustomerForm>(
				customerEntityList.size());

		for (int i = 0; i < customerEntityList.size(); i++) {
			CustomerForm customerForm = new CustomerForm();
			BeanUtils.copyProperties(customerEntityList.get(i), customerForm);
			customerFormList.add(customerForm);
		}
/*		System.out.println("Printing from customerServiceImpl " + customerFormList);
*/		return customerFormList;
	}

	@Override
	public CustomerForm findCustomerByUserId(String userid) {
		CustomerForm customerForm=new CustomerForm(); 
		CustomerEntity customerEntity=bankCustomerDao.findCustomerByUserId(userid);
		if(customerEntity!=null)
		BeanUtils.copyProperties(bankCustomerDao.findCustomerByUserId(userid), customerForm);
		return customerForm;
	}

	@Override
	public List<PayeeDetailsForm> showPayeeListByUserId(String userId) {

		List<PayeeDetailsEntity> payeesEntityList = bankCustomerDaoSJdbc.showPayeeListByUserId(userId);
		System.out.println(payeesEntityList);
		List<PayeeDetailsForm> payeesFormList = new ArrayList<PayeeDetailsForm>();

		for(PayeeDetailsEntity entity:payeesEntityList){
			PayeeDetailsForm form = new PayeeDetailsForm();
			BeanUtils.copyProperties(entity, form);
			payeesFormList.add(form);
		}	

		return payeesFormList;
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

/*		System.out.println("---------Entered in ListFor RowNumbers methods------");
*/
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
		System.out.println("customerEntityList="+customerEntityList);
		return customerFormList;
	}

	@Override
	public List<CustomerForm> findCustomersByAttributeAndValue(
			String attribute, String value) {
		List<CustomerEntity> customerEntityList = bankCustomerDao.findCustomerByColumnNameAndValue(attribute, value);
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
			BeanUtils.copyProperties(customerRegistrationQuestionsEntity,customerRegistrationQuestionsForm);
			customerRegistrationQuestionsForms.add(customerRegistrationQuestionsForm);
		}
		System.out.println("Service: " + customerRegistrationQuestionsForms);
		return customerRegistrationQuestionsForms;
	}

}
