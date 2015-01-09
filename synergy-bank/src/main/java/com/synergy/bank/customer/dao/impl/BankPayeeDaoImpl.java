package com.synergy.bank.customer.dao.impl;

/**
 * @author this Tridib.Bandopadhyay
 * @since 9th July 2014
 * This is contract for customer for the bank.
 */


import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.synergy.bank.customer.dao.BankPayeeDao;
import com.synergy.bank.customer.dao.entity.PayeeDetailsEntity;
import com.synergy.bank.customer.dao.query.CustomerQuery;
import com.synergy.bank.customer.web.constant.ApplicationStatus;

@Repository("BankPayeeDaoImpl")
@Scope("singleton")
public class BankPayeeDaoImpl extends JdbcDaoSupport 
implements BankPayeeDao{

	
	@Autowired
	@Qualifier("bankDataSource")
	public void setDataSourceInBank(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	private int findNextNum() {
		int num = getJdbcTemplate().queryForInt(
				"select max(sno) from payee_information_tbl");
		num = num + 1;
		return num;
	}
	
	@Override
	public String addPayee(PayeeDetailsEntity entity){
		Object[] data = new Object[]{findNextNum(),entity.getUserid(),entity.getPayeeAccountNo(),entity.getPayeeName(),entity.getPayeeNickName(),
				entity.getMobile(),entity.getDoe(),entity.getEmail(),entity.getStatus()};
		super.getJdbcTemplate().update(CustomerQuery.ADD_PAYEE,data);
		return "success";
	}


	@Override
	public String confirmPayee(PayeeDetailsEntity entity) {
		Object[] data = new Object[]{entity.getPayeeAccountNo(),entity.getPayeeName(),entity.getPayeeNickName(),
				entity.getEmail(),entity.getMobile(),entity.getSno(),entity.getDoe(),entity.getStatus(),entity.getUserid()};
		super.getJdbcTemplate().update(CustomerQuery.APPROVE_PAYEE_STATUS,data);
		return "success";
	}

	@Override
	public List<PayeeDetailsEntity> getPayeeListForUserId(String userId) {
		List<PayeeDetailsEntity> payeeDetailsEntityList = super.getJdbcTemplate().query(CustomerQuery.FIND_APPROVED_PAYEE_BY_USERID,new Object[]{userId,ApplicationStatus.APPROVED.value()},
				new BeanPropertyRowMapper<PayeeDetailsEntity>(PayeeDetailsEntity.class));
		return payeeDetailsEntityList;
	}
	
	@Override
	public PayeeDetailsEntity findPayeeByUserId(String userid) {
		PayeeDetailsEntity payeeDetailsEntity= super.getJdbcTemplate().queryForObject(CustomerQuery.FIND_PAYEE + "'"+ 
	userid +"'",new BeanPropertyRowMapper<PayeeDetailsEntity>(PayeeDetailsEntity.class));
		return payeeDetailsEntity;
	}
	
	@Override
	public List<PayeeDetailsEntity> findAllPayees() {
		List<PayeeDetailsEntity> payeeDetailsEntityList = super.getJdbcTemplate().query(CustomerQuery.FIND_ALL_PAYEES  
								,new BeanPropertyRowMapper<PayeeDetailsEntity>(PayeeDetailsEntity.class));
		return payeeDetailsEntityList;
	}
	
	@Override
	public String deletePayeeRowById(String userid){
		int a = super.getJdbcTemplate().update(CustomerQuery.DELETE_FROM_PAYEE_INFO_TBL+"'"+userid+"'");
		String message = "Not Deleted";
		if(a > 0)
			message = "Deleted";
		return message;
	}
	

	public boolean isPayeeExists(String userId, String payeeAccountNo){
	
		String sql = CustomerQuery.VALIDATE_PAYEE + " userid='"
				+ userId + "' and payeeAccountNo='"
				+ payeeAccountNo + "'";
	/*	System.out.println(sql);*/
		PayeeDetailsEntity payeeDetailsEntity = null;
		try{
			payeeDetailsEntity = super.getJdbcTemplate()
				.queryForObject(
						sql,
						new BeanPropertyRowMapper<PayeeDetailsEntity>(PayeeDetailsEntity.class));
		}
		catch(Exception e){
			return false;
		}
		if(payeeDetailsEntity!=null){
			return true;
		}
		else{
			return false;
		}		
	}

@Override
public String confirmPayee(String payeeAccountNo, String userId) {
	String confirmPayeeQuery="update payee_information_tbl set status='approved' where userid=? and payeeAccountNo=?";
	super.getJdbcTemplate().update(confirmPayeeQuery,new Object[]{userId,payeeAccountNo});
	return "success";
}

@Override
public String checkPayeeAccountNumber(String payeeAcoountNumber) {
	//
	String sql="select customerAccountNo from customer_account_info_tbl where customerAccountNo='"+payeeAcoountNumber+"'";
	try {
		super.getJdbcTemplate().queryForObject(sql,String.class);
	}catch(EmptyResultDataAccessException dataAccessException){
		return "invalid";
	}
	return "valid";
}

@Override
public String checkTransactionAmountNumber(String transactionAmount) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public String checkPayeeName(String payeeName, String payeeAcoountNumber) {
	//
	String sql="select customerAccountNo from customer_account_info_tbl where customerAccountNo='"+payeeAcoountNumber+"' and customerName='"+payeeName+"'";
	try {
		super.getJdbcTemplate().queryForObject(sql,String.class);
	}catch(EmptyResultDataAccessException dataAccessException){
		return "invalid";
	}
	return "valid";
}

}
