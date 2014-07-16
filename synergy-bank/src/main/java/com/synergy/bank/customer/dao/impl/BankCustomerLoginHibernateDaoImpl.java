package com.synergy.bank.customer.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.synergy.bank.base.dao.AbstractDaoImpl;
import com.synergy.bank.customer.dao.entity.CustomerEntity;
import com.synergy.bank.customer.dao.entity.CustomerLoginDetailEntity;

@Repository("BankCustomerLoginHibernateDaoImpl")
@Transactional(propagation=Propagation.REQUIRED,value="transactionManager")
public class BankCustomerLoginHibernateDaoImpl extends AbstractDaoImpl<CustomerLoginDetailEntity,String> {
	
	protected BankCustomerLoginHibernateDaoImpl() {
        super(CustomerLoginDetailEntity.class);
    }
	
	//@Transactional(propagation=Propagation.REQUIRED) == annotation will not work 
	//for super class method since it is applied 
	public void save(CustomerLoginDetailEntity customerLoginDetailEntity){
		super.saveOrUpdate(customerLoginDetailEntity);
	}

	@Override
	public List<CustomerEntity> getCustomerListForRowNumbers(
			int initialRowNumber, int maximumRowNumbers) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
