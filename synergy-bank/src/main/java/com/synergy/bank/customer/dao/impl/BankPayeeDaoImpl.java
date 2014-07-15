package com.synergy.bank.customer.dao.impl;

/**
 * @author this Tridib.Bandopadhyay
 * @since 9th July 2014
 * This is contract for customer for the bank.
 */


import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import com.synergy.bank.customer.dao.BankPayeeDao;
import com.synergy.bank.customer.dao.entity.CustomerEntity;
import com.synergy.bank.customer.dao.entity.PayeeDetailsEntity;
import com.synergy.bank.customer.dao.query.CustomerQuery;

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
		Object[] data = new Object[]{entity.getSno(),entity.getUserid(),entity.getPayeeAccountNo(),entity.getPayeeName(),entity.getPayeeNickName(),entity.getMobile(),entity.getDoe(),
				entity.getEmail(),entity.getStatus()};
		System.out.println(data);
		super.getJdbcTemplate().update(CustomerQuery.ADD_PAYEE,data);
		System.out.println("____AHAHAHA____");
		return "success";
	}


	@Override
	public String confirmPayee(PayeeDetailsEntity entity) {
		Object[] data = new Object[]{entity.getSno(),entity.getUserid(),entity.getPayeeAccountNo(),entity.getPayeeName(),entity.getPayeeNickName(),entity.getMobile(),entity.getDoe(),
				entity.getEmail(),entity.getStatus()};
		super.getJdbcTemplate().update(CustomerQuery.APPROVE_PAYEE_STATUS+ "'" +data+"'");
		System.out.println("____updated____");
		return "success";
	}

	@Override
	public PayeeDetailsEntity findPayeeByUserId(String userid) {
		PayeeDetailsEntity payeeDetailsEntity= super.getJdbcTemplate().queryForObject(CustomerQuery.SHOW_PART_PAYEELIST + "'"+ 
	userid +"'",new BeanPropertyRowMapper<PayeeDetailsEntity>(PayeeDetailsEntity.class));
		return payeeDetailsEntity;
	}

}
