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
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.synergy.bank.customer.dao.BankPayeeDao;
import com.synergy.bank.customer.dao.entity.PayeeDetailsEntity;

@Repository("BankPayeeDaoImpl")
@Scope("singleton")
public class BankPayeeDaoImpl extends JdbcDaoSupport 
implements BankPayeeDao{

	
	@Autowired
	@Qualifier("bankDataSource")
	public void setDataSourceInBank(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	@Override
	public String addPayee(PayeeDetailsEntity entity){
		/*Object[] data = new Object[] { entity.getPayeeAccountNumber(),entity.getPayeeReAccountNumber(),
				entity.getPayeeName(),entity.getPayeeNickName(),entity.getPayeeEmailId(),
				entity.getPayeeAccountType() };
		super.getJdbcTemplate().update(PayeeTransferAmountToCustomerQuery.INSERT_Payee, data);
		System.out.println("____AHAHAHA____");*/
		return "success";
	}

	@Override
	public List<PayeeDetailsEntity> showPayee() {
	
		return null;
	}
}