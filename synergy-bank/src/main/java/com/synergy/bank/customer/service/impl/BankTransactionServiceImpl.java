package com.synergy.bank.customer.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.synergy.bank.common.web.controller.form.LoginForm;
import com.synergy.bank.customer.dao.BankPayeeDao;
import com.synergy.bank.customer.dao.BankTransactionDao;
import com.synergy.bank.customer.dao.entity.CustomerTransactionEntity;
import com.synergy.bank.customer.dao.entity.CustomerTransactionsEntity;
import com.synergy.bank.customer.service.BankTransactionService;
import com.synergy.bank.customer.service.CustomerAccountService;
import com.synergy.bank.customer.web.constant.NavigationConstant;
import com.synergy.bank.customer.web.controller.form.CustomerTransactionForm;
import com.synergy.bank.customer.web.controller.form.CustomerTransactionsForm;

@Service("BankTransactionServiceImpl")
@Scope("singleton")
public class BankTransactionServiceImpl implements BankTransactionService {

	@Autowired
	@Qualifier("BankPayeeDaoImpl")
	private BankPayeeDao bankPayeeDao;
	
	@Autowired
	@Qualifier("BankTransactionDaoImpl")
	private BankTransactionDao bankTransactionDao;

	@Autowired
	@Qualifier("BankTransactionHibernateDaoImpl")
	private BankTransactionDao bankTransactionHibernetDao;

	@Autowired
	@Qualifier("CustomerAccountServiceImpl")
	private CustomerAccountService customerAccountService;
	
	@Transactional
	@Override
	public String addCustomerTransaction(CustomerTransactionForm transactionForm, String userid) {

		
		CustomerTransactionEntity entity = new CustomerTransactionEntity();
		BeanUtils.copyProperties(transactionForm, entity);
		/*System.out.println("Entity at beanUtils" + entity);*/
		
		CustomerTransactionsEntity customerTransactionsEntity = new CustomerTransactionsEntity();
		customerTransactionsEntity.setAccountID(transactionForm.getPayeeAccountNumber());
		customerTransactionsEntity.setAmmount(Integer.parseInt(transactionForm.getTransactionAmount()));
		customerTransactionsEntity.setCreditDr("CR");
		customerTransactionsEntity.setDescription(transactionForm.getTransactionRemark());
		customerTransactionsEntity.setTransactionDate(transactionForm.getTransactionDate());
		customerTransactionsEntity.setTransactionId(transactionForm.getTransactionId());
		
		bankTransactionHibernetDao.save(customerTransactionsEntity);
		bankTransactionDao.addTransactions(entity);
		
	    /*CustomerForm customerForm = new CustomerForm();
	    String userid = customerForm.getUserId();*/
		
	    double amount = customerAccountService.getBalance(userid);
	    double transactionAmount = Double.parseDouble(transactionForm.getTransactionAmount());
	    double remAmount;
	    if(amount > transactionAmount)
	    	remAmount = amount - transactionAmount;
	    else{
	    	//TODO
	    	remAmount = amount - transactionAmount;
	    }
	    customerAccountService.updateAmount(remAmount, userid);
			
		return "success";
	}

	@Override
	public List<CustomerTransactionsForm> findCustomerTransactionByAccountNumber(
			String accountNumber) {
		List<CustomerTransactionsEntity> customerTransactionEntityList = bankTransactionHibernetDao
				.findCustomerTransactionByAccountNumber(accountNumber);
		List<CustomerTransactionsForm> customerTransactionFormList = new ArrayList<CustomerTransactionsForm>(
				customerTransactionEntityList.size());
		for (int i = 0; i < customerTransactionEntityList.size(); i++) {
			CustomerTransactionsForm customerTransactionForm = new CustomerTransactionsForm();
			BeanUtils.copyProperties(customerTransactionEntityList.get(i),
					customerTransactionForm);
			customerTransactionFormList.add(customerTransactionForm);
		}
		return customerTransactionFormList;
	}

	/*@Override
	public List<CustomerTransactionForm> findCustomerTransactionByAccountNumber(
			String customerAccountNumber, String accountNumber) {
		List<CustomerTransactionEntity> customerTransactionEntities = bankTransactionHibernetDao
				.findCustomerTransactionByAccountNumber(customerAccountNumber,
						accountNumber);
		List<CustomerTransactionForm> customerTransactionForms = new ArrayList<CustomerTransactionForm>(
				customerTransactionEntities.size());
		for (int i = 0; i < customerTransactionEntities.size(); i++) {
			CustomerTransactionForm customerTransactionForm = new CustomerTransactionForm();
			BeanUtils.copyProperties(customerTransactionEntities.get(i),
					customerTransactionForm);
			customerTransactionForms.add(customerTransactionForm);
		}
		return customerTransactionForms;
	}*/
	// This method finds the accountnumber by Userid
public String findAccountNumberbyUserId(String Userid){
	
	//String userid = bankTransactionDao.
	//Add dao code for getting the account number by userId
	return Userid;
	
}
	@Override
	public String checkTransactionAmountNumber(String transactionAmount) {

			return bankPayeeDao.checkTransactionAmountNumber(transactionAmount);
			
	
	}

	@Override
	public List<CustomerTransactionForm> findCustomerTransactionByAccountNumber(
			String customerAccountNumber, String accountNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addCustomerTransaction(CustomerTransactionForm transactionForm) {
		// TODO Auto-generated method stub
		return null;
	}

}
