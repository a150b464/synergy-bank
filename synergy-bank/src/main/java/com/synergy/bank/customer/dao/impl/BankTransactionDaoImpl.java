package com.synergy.bank.customer.dao.impl;

import java.sql.Types;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.synergy.bank.customer.dao.BankTransactionDao;
import com.synergy.bank.customer.dao.entity.CustomerTransactionEntity;
import com.synergy.bank.customer.dao.entity.CustomerTransactionsEntity;
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
	
	
	private int nextSNo(){
		String sql="select max(id) from customer_transactions_tbl";
		int p=super.getJdbcTemplate().queryForInt(sql);
		p=p+1;
		return p;
	}
	
	private int nextTransactionId(){
		String sql="select max(transactionId) from transaction_id_generator_tbl";
		int trasactionId=super.getJdbcTemplate().queryForInt(sql);
		trasactionId++;
		return trasactionId;
	}
	
	@Override
	public String addTransactionsHistory(
			CustomerTransactionsEntity entity) {
		int[] columnsType = new int[] { Types.BIGINT,
				Types.VARCHAR, Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.DATE,
				Types.BIGINT};
		Object data[] = new Object[] { nextSNo(), entity.getAccountID(),
				entity.getAmmount(), entity.getCreditDr(), entity.getDescription(), new Date(),
				nextTransactionId()};
		super.getJdbcTemplate().update(CustomerQuery.INSERT_CUSTOMER_TRANSACTIONS_HISTORY, data, columnsType);
		return "saved";
	}

	@Override
	public String addTransactions(CustomerTransactionEntity entity) {
		int[] columnsType = new int[] { Types.VARCHAR,
				Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.DATE, Types.VARCHAR,
				Types.INTEGER};
		Object data[] = new Object[] { entity.getCustomerAccountNumber(), entity.getCustomerAccountType(),
				entity.getPayeeAccountNumber(), entity.getTransactionAmount(), entity.getTransactionDate(), entity.getTransactionRemark(),
				entity.getTransactionPwd()};
		super.getJdbcTemplate().update(CustomerQuery.INSERT_CUSTOMER_TRANSACTION, data, columnsType);
		return "saved";
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

		return null;
	}

	@Override
	public List<CustomerTransactionsEntity> findCustomerTransactionByAccountNumber(
			String accountNumber) {
		/*
		 * List<CustomerTransactionEntity> transactionList = super
		 * .getJdbcTemplate()
		 * .query(CustomerQuery.FIND_TRANSACTION_BY_CUSTOMER_ACCOUNT_NUMBER +
		 * "'" + accountNumber + "'", new
		 * BeanPropertyRowMapper<CustomerTransactionEntity>(
		 * CustomerTransactionEntity.class));
		 */
		return null;
	}

	@Override
	public String addCustomerTransaction(CustomerTransactionsEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(CustomerTransactionsEntity entity) {
		// TODO Auto-generated method stub
		
	}

	

}
