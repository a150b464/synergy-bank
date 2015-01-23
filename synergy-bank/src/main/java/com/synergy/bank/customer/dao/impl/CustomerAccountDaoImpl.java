package com.synergy.bank.customer.dao.impl;

import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.synergy.bank.customer.dao.CustomerAccountDao;
import com.synergy.bank.customer.dao.entity.CustomerAccountEntity;
import com.synergy.bank.customer.dao.query.CustomerQuery;

@Repository("CustomerAccountDaoImpl")
@Scope("singleton")
@Transactional(value="jdbctransactionManager")
public class CustomerAccountDaoImpl extends JdbcDaoSupport implements
		CustomerAccountDao {

	@Autowired
	@Qualifier("bankDataSource")
	public void setDataSourceInBank(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	public List<CustomerAccountEntity> findCustomerAccountByUserId(String userId) {
		List<CustomerAccountEntity> accountList = super.getJdbcTemplate()
				.query(CustomerQuery.FIND_CUSTOMER_ACCOUNT_BY_ID + "'" + userId	+ "'",
						new BeanPropertyRowMapper<CustomerAccountEntity>(CustomerAccountEntity.class));
		return accountList;
	}
	
	@Override
	public double getBalance(String userid){
				
		String sql = "select totalAvailBalance from customer_account_info_tbl where userid="+"'"+userid+"'";
		double amount = (double) super.getJdbcTemplate().queryForLong(sql);
		
		return amount;
	}
	
	@Override
	public String updateAmount(double remAmount, String userid){
		CustomerAccountEntity customerAccountEntity = new CustomerAccountEntity();
		String sql = "UPDATE customer_account_info_tbl set totalAvailBalance="+remAmount+" , availBalance="+remAmount+" where userid="+"'"+userid+"'";
				
		super.getJdbcTemplate().update(sql);
		return "success";
	}
}
