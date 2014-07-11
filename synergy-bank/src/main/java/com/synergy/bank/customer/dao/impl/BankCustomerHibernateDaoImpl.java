package com.synergy.bank.customer.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.synergy.bank.base.dao.AbstractDaoImpl;
import com.synergy.bank.customer.dao.BankCustomerDao;
import com.synergy.bank.customer.dao.entity.CustomerEntity;
import com.synergy.bank.customer.dao.entity.PayeeDetailsEntity;

@Repository("BankCustomerHibernateDaoImpl")
@Transactional(propagation=Propagation.REQUIRED)
public class BankCustomerHibernateDaoImpl extends AbstractDaoImpl<CustomerEntity,String> implements BankCustomerDao {
	
	protected BankCustomerHibernateDaoImpl() {
        super(CustomerEntity.class);
    }

	@Override
	public String addCustomer(CustomerEntity entity) {
		 super.saveOrUpdate(entity);
		 return "success";
	}

	@Override
	public String updateCustomer(CustomerEntity entity) {
		super.saveOrUpdate(entity);
		return "success";
	}

	@Override
	public List<CustomerEntity> findCustomers() {
		return super.findAll();
	}

	@Override
	public CustomerEntity findCustomerByUserId(String userid) {
		return super.findById(userid);
	}

	@Override
	public List<PayeeDetailsEntity> showPayeeListByUserId(String userId) {
				return null;
	}


}
