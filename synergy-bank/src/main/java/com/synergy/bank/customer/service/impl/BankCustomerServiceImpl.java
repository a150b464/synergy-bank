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
import com.synergy.bank.customer.dao.BankCustomerDao;
import com.synergy.bank.customer.dao.entity.CustomerEntity;
import com.synergy.bank.customer.dao.entity.CustomerLoginDetailEntity;
import com.synergy.bank.customer.dao.entity.PayeeDetailsEntity;
import com.synergy.bank.customer.dao.impl.BankCustomerLoginHibernateDaoImpl;
import com.synergy.bank.customer.service.BankCustomerService;
import com.synergy.bank.customer.web.controller.form.CustomerForm;
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
	@Qualifier("BankJdbcDaoImpl")
	private BankJdbcDao bankJdbcDao;
	

	@Override
	public String addCustomer(CustomerForm customerForm) {
		
		char[] password=bankJdbcDao.generatePassword();
		String userid=bankJdbcDao.nextUserID();
		customerForm.setUserId(userid);
		customerForm.setPassword(new String(password));
		CustomerEntity customerEntity=new CustomerEntity();
		//attribute and datatype should be match
		BeanUtils.copyProperties(customerForm, customerEntity);
		CustomerLoginDetailEntity customerLoginDetailEntity=new CustomerLoginDetailEntity();
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
		customerLoginDetailEntity.setRole("customer");
		bankCustomerLoginHibernateDaoImpl.saveOrUpdate(customerLoginDetailEntity);
		return bankCustomerDao.addCustomer(customerEntity);
	}
	
	
	@Override
	public String updateCustomer(CustomerForm customerForm) {
		return null;
	}

	@Override
	public List<CustomerForm> findCustomers() {
		List<CustomerEntity> customerEntityList = bankCustomerDao.findCustomers();
		List<CustomerForm>   customerFormList   = new ArrayList<CustomerForm>(customerEntityList.size());

		for(int i=0;i<customerEntityList.size();i++)
		{
			CustomerForm customerForm = new CustomerForm();	
			BeanUtils.copyProperties(customerEntityList.get(i),customerForm);
			customerFormList.add(customerForm);
		}
		return customerFormList;
	}

	@Override
	public CustomerForm findCustomerByUserId(String userid) {
		CustomerForm customerForm=new CustomerForm(); 
		BeanUtils.copyProperties(bankCustomerDao.findCustomerByUserId(userid), customerForm);
		return customerForm;
	}

	@Override
	public List<PayeeDetailsForm> showPayeeListByUserId(String userId) {				
		
		List<PayeeDetailsEntity> payeeList = bankCustomerDao.showPayeeListByUserId(userId);		
		System.out.println(payeeList);
		List<PayeeDetailsForm> payeeListForms = new ArrayList<PayeeDetailsForm>();
		
		for (PayeeDetailsEntity pde : payeeList) 
		{
			PayeeDetailsForm pdf = new PayeeDetailsForm();
			BeanUtils.copyProperties(pde, pdf);
			payeeListForms.add(pdf);
		}
		
		return payeeListForms;
	}

	@Override
	public String deleteCustomerById(String userId) {
		bankCustomerDao.deleteCustomer(bankCustomerDao.findCustomerByUserId(userId));
		return "success";
	}

	@Override
	public List<CustomerForm> findCustomersByAttributeAndValue(
			String attribute, String value) {
		List<CustomerEntity> customerEntityList = bankCustomerDao.findCustomerByColumnNameAndValue(attribute, value);
		List<CustomerForm>   customerFormList   = new ArrayList<CustomerForm>(customerEntityList.size());

		for(int i=0;i<customerEntityList.size();i++)
		{
			CustomerForm customerForm = new CustomerForm();	
			BeanUtils.copyProperties(customerEntityList.get(i),customerForm);
			customerFormList.add(customerForm);
		}
		return customerFormList;
	}

	@Override
	public byte[] findPhotoById(String userId) {
		return bankCustomerDao.findPhotoById(userId);
	}

}
