package com.synergy.bank.customer.service.impl;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.synergy.bank.customer.dao.CustomerAccountDao;
import com.synergy.bank.customer.dao.entity.CustomerAccountEntity;
import com.synergy.bank.customer.service.CustomerAccountService;
import com.synergy.bank.customer.web.controller.form.CustomerAccountForm;

@Service("CustomerAccountServiceImpl")
@Scope("singleton")
public class CustomerAccountServiceImpl implements CustomerAccountService {

	@Autowired
	@Qualifier("CustomerAccountDaoImpl")
	private CustomerAccountDao customerAccountDao;

	@Override
	public List<CustomerAccountForm> findCustomerAccountByUserId(String userId) {
		List<CustomerAccountEntity> customerAccountEntities = customerAccountDao
				.findCustomerAccountByUserId(userId);
		List<CustomerAccountForm> customerAccountForms = new ArrayList<CustomerAccountForm>(
				customerAccountEntities.size());

		for (int i = 0; i < customerAccountEntities.size(); i++) {
			CustomerAccountForm customerAccountForm = new CustomerAccountForm();
			BeanUtils.copyProperties(customerAccountEntities.get(i),
					customerAccountForm);
			customerAccountForms.add(customerAccountForm);
		}
		return customerAccountForms;
	}
	
	@Override
	public double getBalance(String userid){
			
		double amount = customerAccountDao.getBalance(userid);
		
		return amount;
	}
	
	@Override
	public String updateAmount(double remAmount, String userid){
		customerAccountDao.updateAmount(remAmount, userid);
		return "success";
	}
}
