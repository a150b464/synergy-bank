package com.synergy.bank.common.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.synergy.bank.common.dao.BankJdbcDao;
import com.synergy.bank.util.PasswordGenerator;

@Repository("BankJdbcDaoImpl")
@Transactional(value="jdbctransactionManager")
public class BankJdbcDaoImpl extends JdbcDaoSupport implements BankJdbcDao{
	 
	 int passwordSize = 4;
     private PasswordGenerator password = new PasswordGenerator( passwordSize );
	
	@Autowired
	@Qualifier("bankDataSource")
	public void setBankDataSource(DataSource dataSource){
		super.setDataSource(dataSource);
	}

	@Override
	public String nextUserID() {
		String sql="select userid from userid_gen_tbl";
		Long userid=getJdbcTemplate().queryForLong(sql);
		userid=userid+1;
		String sqlUpdate="update userid_gen_tbl set userid="+userid;
		getJdbcTemplate().update(sqlUpdate);
		return userid+"";
	}

	@Override
	public String nextTransactionId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public char[] generatePassword() {
	      char[] gpassword=password.get();   
	     /* System.out.println("gpassword  = "+gpassword);*/
	      return gpassword;
	}

}
