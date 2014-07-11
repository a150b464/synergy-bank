package com.synergy.bank.payee.dao.impl;

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

import com.synergy.bank.payee.dao.PayeeTransferAmountToCustomerDao;
import com.synergy.bank.payee.dao.entity.PayeeTransferAmountToCustomerEntity;
import com.synergy.bank.payee.dao.query.PayeeTransferAmountToCustomerQuery;

@Repository("PayeeTransferAmountToCustomerDaoImp")
@Scope("singleton")
public class PayeeTransferAmountToCustomerDaoImp extends JdbcDaoSupport 
implements PayeeTransferAmountToCustomerDao{

	
	@Autowired
	@Qualifier("payeeCustomerDataSource")
	public void setDataSourceInBank(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	@Override
	public String addPayee(PayeeTransferAmountToCustomerEntity entity){
		Object[] data = new Object[] { entity.getPayeeAccountNumber(),entity.getPayeeReAccountNumber(),
				entity.getPayeeName(),entity.getPayeeNickName(),entity.getPayeeEmailId(),
				entity.getPayeeAccountType() };
		super.getJdbcTemplate().update(PayeeTransferAmountToCustomerQuery.INSERT_Payee, data);
		System.out.println("____AHAHAHA____");
		return "success";
	}

	@Override
	public List<PayeeTransferAmountToCustomerEntity> showPayee() {
		// TODO Auto-generated method stub
		return null;
	}
}
