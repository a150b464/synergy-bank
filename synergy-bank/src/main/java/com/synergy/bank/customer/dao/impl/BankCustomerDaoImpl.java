package com.synergy.bank.customer.dao.impl;

import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;

import com.synergy.bank.common.dao.entity.LoginEntity;
import com.synergy.bank.common.query.CommonQuery;
import com.synergy.bank.customer.dao.BankCustomerDao;
import com.synergy.bank.customer.dao.entity.CustomerEntity;
import com.synergy.bank.customer.dao.entity.PayeeDetailsEntity;
import com.synergy.bank.customer.dao.query.CustomerQuery;

/**
 * @author this nagendra.yadav
 * @since 9th July 1014 This is contract for customer for the bank.
 */

@Repository("BankCustomerDaoImpl")
@Scope("singleton")
public class BankCustomerDaoImpl extends JdbcDaoSupport implements
		BankCustomerDao {

	@Autowired
	@Qualifier("bankDataSource")
	// here we are injecting bankDataSource inside JdbcDaoSupport super class
	public void setDataSourceInBank(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	public String addCustomer(CustomerEntity entity) {
		LobHandler lobHandler = new DefaultLobHandler();
		SqlLobValue dphtoto = new SqlLobValue(entity.getPhoto(), lobHandler);
		Object[] data = new Object[] { entity.getUserId(),
				entity.getPassword(), entity.getSalutation(),
				entity.getGender(), entity.getFirstName(),
				entity.getMiddleName(), entity.getLastName(),
				entity.getMaritalStatus(), entity.getDob(),
				entity.getCategory(), entity.getMotherMaidenName(),
				entity.getFatherName(), entity.getEmail(), entity.getMobile(),
				entity.getSsn(), entity.getOccupation(),
				entity.getOccupationType(), entity.getEducation(),
				entity.getGrossAnualIncome(), entity.getSourceOfFunds(),
				entity.getRole(), dphtoto, entity.getDoe(), entity.getDom(),
				"new  Customer" };

		int dataArra[] = new int[] { Types.VARCHAR, Types.VARCHAR,
				Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
				Types.VARCHAR, Types.VARCHAR, Types.DATE, Types.VARCHAR,
				Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
				Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
				Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.BLOB,
				Types.DATE, Types.DATE, Types.VARCHAR};
		super.getJdbcTemplate().update(CustomerQuery.INSERT_CUSTOMER, data,dataArra);
		addCustomerLoginDetails(entity);
		System.out.println("____AHAHAHA____");
		return "success";
	}

	@Override
	public String addCustomerLoginDetails(CustomerEntity entity) {
		System.out.println("at add cusdetails ");
		Object[] data = new Object[] { entity.getUserId(), entity.getPassword(), entity.getRole(), "new  Customer" };

		int dataArra[] = new int[] { Types.VARCHAR, Types.VARCHAR,
				Types.VARCHAR, Types.VARCHAR};
		super.getJdbcTemplate().update(CommonQuery.INSERT_CUSTOMER_LOGIN_DETAILS, data,dataArra);
		System.out.println("____AHAHAHA____INSERTED");
		return "success";
	}
	
	@Override
	public String updateCustomer(CustomerEntity entity) {
		return null;
	}

	@Override
	public List<CustomerEntity> findCustomers() {
		List<CustomerEntity> customerList = super.getJdbcTemplate().query(CustomerQuery.FIND_CUTOMER,
				new BeanPropertyRowMapper<CustomerEntity>(CustomerEntity.class));
		return customerList;
	}

	@Override
	public CustomerEntity findCustomerByUserId(String userid) {
		
		return null;
	}
	@Override
	public String deleteCustomer(CustomerEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerEntity> findCustomerByColumnNameAndValue(
			String columnName, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] findPhotoById(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PayeeDetailsEntity> showPayeeListByUserId(String userId) {
		
		List<PayeeDetailsEntity> payeeList = super.getJdbcTemplate().query(CustomerQuery.SHOW_PAYEE_LIST+"'"+userId+"'",
							new BeanPropertyRowMapper<PayeeDetailsEntity>(PayeeDetailsEntity.class));
        return payeeList;
		
	}

	@Override
	public List<CustomerEntity> getCustomerListForRowNumbers(
			int initialRowNumber, int maximumRowNumbers) {
		// TODO Auto-generated method stub
		return null;
	}

}
