package com.synergy.bank.common.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.synergy.bank.common.dao.BankAuthDao;
import com.synergy.bank.common.dao.entity.LoginEntity;
import com.synergy.bank.common.query.CommonQuery;

@Repository("BankAuthDaoImpl")
public class BankAuthDaoImpl extends JdbcDaoSupport implements BankAuthDao {
	
	@Autowired
	@Qualifier("bankDataSource")
	public void setBankDataSource(DataSource dataSource){
		super.setDataSource(dataSource);
	}

	@Override
	public LoginEntity authUser(String userid, String password) {
		LoginEntity loginEntity=null;
		try {
		   loginEntity=super.getJdbcTemplate().queryForObject(CommonQuery.AUTH_BANK_USER,new Object[]{userid,password},new BeanPropertyRowMapper<LoginEntity>(LoginEntity.class));
		}catch(Exception ex){
			loginEntity=new LoginEntity();
		}
		return loginEntity;
	}

	
}
