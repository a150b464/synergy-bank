package com.synergy.bank.common.dao.impl;

import java.io.IOException;
import java.sql.Types;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.synergy.bank.common.dao.BankAuthDao;
import com.synergy.bank.common.dao.entity.LoginEntity;
import com.synergy.bank.common.query.CommonQuery;

@Repository("BankAuthDaoImpl")
@Transactional(value="jdbctransactionManager",propagation=Propagation.REQUIRED)
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
	@Transactional(value="jdbctransactionManager",noRollbackFor=NullPointerException.class,rollbackFor=IOException.class,timeout=3000)
	public String addCustomerDetails(LoginEntity entity) {
		Object[] data = new Object[] { entity.getUserId(), entity.getPassword(), entity.getRole(), "new  Customer" };
		int dataArra[] = new int[] { Types.VARCHAR, Types.VARCHAR,
				Types.VARCHAR, Types.VARCHAR};
		super.getJdbcTemplate().update(CommonQuery.INSERT_CUSTOMER_LOGIN_DETAILS,data,dataArra);
		/*System.out.println("____AHAHAHA____INSERTED");*/
		return "success";
	}



	@Override
	public LoginEntity findLoginDetailByUserName(String userid) {
		LoginEntity loginEntity=null;
		try {
		   loginEntity=super.getJdbcTemplate().queryForObject(CommonQuery.AUTH_DETAIL_BANK_USER,new Object[]{userid},new BeanPropertyRowMapper<LoginEntity>(LoginEntity.class));
		}catch(Exception ex){
			loginEntity=new LoginEntity();
		}
		return loginEntity;
	}
	
	@Override
	public List<String> imageAdminSliderList(){
		String query = "Select path from image_galary_tbl";
		List<String> imageList = super.getJdbcTemplate().queryForList(query, String.class);
		//Collections.sort(list)
		return imageList;
	}

	
}
