package com.synergy.bank.admin.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.synergy.bank.admin.dao.query.AdminQuery;
import com.synergy.bank.customer.dao.BankAdminDao;
import com.synergy.bank.customer.dao.entity.CustomerEntity;

/**
 * 
 * @author Naim
 *
 */


@Repository("BankAdminDaoImpl")
@Scope("singleton")
public class BankAdminDaoImpl extends JdbcDaoSupport implements BankAdminDao{

	
	@Autowired
	@Qualifier("bankDataSource")
	// here we are injecting bankDataSource inside JdbcDaoSupport super class
	public void setDataSourceInBank(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	
	@Override
	public List<CustomerEntity> findPendingCustomerList(){
		
		List<CustomerEntity> customerList = super.getJdbcTemplate().query(AdminQuery.FIND_PENDING_CUSTOMER_LIST,
				new BeanPropertyRowMapper<CustomerEntity>(CustomerEntity.class));
		
		return customerList;
		
	}
	

}
