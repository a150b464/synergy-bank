package com.synergy.bank.customer.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.synergy.bank.base.dao.AbstractDaoImpl;
import com.synergy.bank.customer.dao.BankTransactionDao;
import com.synergy.bank.customer.dao.entity.CustomerEntity;
import com.synergy.bank.customer.dao.entity.CustomerLoginDetailEntity;
import com.synergy.bank.customer.dao.entity.CustomerTransactionEntity;
import com.synergy.bank.customer.dao.entity.CustomerTransactionsEntity;

@Repository("BankTransactionHibernateDaoImpl")
@Transactional(propagation = Propagation.REQUIRED, value = "transactionManager")
public class BankTransactionHibernetDaoImpl extends
		AbstractDaoImpl<CustomerTransactionsEntity, String> implements
		BankTransactionDao {

	protected BankTransactionHibernetDaoImpl() {
		super(CustomerTransactionsEntity.class);
	}

	@Override
	public String addCustomerTransaction(CustomerTransactionsEntity entity) {
		super.saveOrUpdate(entity);
		return "success";
	}
	
	@Override
	public void save(CustomerTransactionsEntity entity){
		super.saveOrUpdate(entity);
	}

	@Override
	public String updateCustomerTransaction(CustomerTransactionsEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerTransactionsEntity> findCustomerTransactions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerTransactionsEntity> findCustomerTransactionByColumnNameAndValue(
			String columnName, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerTransactionsEntity> findCustomerTransactionByUserId(
			String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerEntity> getCustomerListForRowNumbers(
			int initialRowNumber, int maximumRowNumbers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerTransactionsEntity> findCustomerTransactionByAccountNumber(
			String accountNumber) {
		// Criterion criterion = Restrictions.eq("accountID", accountNumber);
		Criteria criteria = super.findByCriteria();
		List<CustomerTransactionsEntity> customerTransactionsEntities = criteria
				.add(Restrictions.eq("accountID", accountNumber))
				.addOrder(Order.desc("transactionDate")).setFirstResult(0)
				.setMaxResults(3).list();
		return customerTransactionsEntities;
	}

	@Override
	public String addTransactions(CustomerTransactionEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
