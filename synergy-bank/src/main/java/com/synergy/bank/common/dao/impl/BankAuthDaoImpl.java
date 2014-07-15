package com.synergy.bank.common.dao.impl;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.synergy.bank.common.dao.BankAuthDao;
import com.synergy.bank.common.dao.entity.LoginEntity;
import com.synergy.bank.common.query.CommonQuery;
import com.synergy.bank.common.service.impl.EmailSenderThread;
import com.synergy.bank.customer.dao.entity.CustomerEntity;
import com.synergy.bank.customer.dao.query.CustomerQuery;
import com.synergy.bank.customer.web.constant.NavigationConstant;
import com.synergy.bank.customer.web.controller.form.CustomerForm;

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

	@Override
	public String addCustomerDetails(LoginEntity entity) {
		
		Object[] data = new Object[] { entity.getUserId(), entity.getPassword(), entity.getRole(), "new  Customer" };

		int dataArra[] = new int[] { Types.VARCHAR, Types.VARCHAR,
				Types.VARCHAR, Types.VARCHAR};
		
		super.getJdbcTemplate().update(CommonQuery.INSERT_CUSTOMER_LOGIN_DETAILS,data,dataArra);
		System.out.println("____AHAHAHA____INSERTED");
		return "success";
	}

	
}
