package com.synergy.bank.customer.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.synergy.bank.base.dao.AbstractDaoImpl;
import com.synergy.bank.customer.dao.BankTransactionDao;
import com.synergy.bank.customer.dao.entity.CustomerTransactionEntity;

@Repository("BankTransactionHibernateDaoImpl")
@Transactional(propagation=Propagation.REQUIRED)
public class BankTransactionHibernetDaoImpl extends AbstractDaoImpl<CustomerTransactionEntity,String>  implements BankTransactionDao {

	protected BankTransactionHibernetDaoImpl(){	
			super(CustomerTransactionEntity.class);
	}

	@Override
	public String addCustomerTransaction(CustomerTransactionEntity entity) {
		 super.saveOrUpdate(entity);
		 return "success";
	}

	@Override
	public String updateCustomerTransaction(CustomerTransactionEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerTransactionEntity> findCustomerTransactions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerTransactionEntity> findCustomerTransactionByColumnNameAndValue(
			String columnName, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerTransactionEntity findCustomerTransactionByUserId(
			String userid) {
		// TODO Auto-generated method stub
		return null;
	}

}