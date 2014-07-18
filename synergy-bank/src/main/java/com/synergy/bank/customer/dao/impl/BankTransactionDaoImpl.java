package com.synergy.bank.customer.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.synergy.bank.customer.dao.BankTransactionDao;
import com.synergy.bank.customer.dao.entity.CustomerTransactionEntity;
import com.synergy.bank.customer.dao.query.CustomerQuery;

@Repository("BankTransactionDaoImpl")
@Scope("singleton")
public class BankTransactionDaoImpl extends JdbcDaoSupport implements
		BankTransactionDao {

	@Autowired
	@Qualifier("bankDataSource")
	public void setBankDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	public String addCustomerTransaction(CustomerTransactionEntity entity) {
		// TODO Auto-generated method stub
		return null;
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
	public List<CustomerTransactionEntity> findCustomerTransactionByUserId(
			String userid) {

		return null;
	}

	@Override
	public List<CustomerTransactionEntity> findCustomerTransactionByAccountNumber(
			String accountNumber) {
		List<CustomerTransactionEntity> transactionList = super
				.getJdbcTemplate()
				.query(CustomerQuery.FIND_TRANSACTION_BY_CUSTOMER_ACCOUNT_NUMBER
						+ "'" + accountNumber + "'",
						new BeanPropertyRowMapper<CustomerTransactionEntity>(
								CustomerTransactionEntity.class));
		return transactionList;
	}

	@Override
	public List<CustomerTransactionEntity> findCustomerTransactionByAccountNumber(
			String customerAccountNumber, String accountNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}