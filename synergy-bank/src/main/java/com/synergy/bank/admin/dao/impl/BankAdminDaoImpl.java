package com.synergy.bank.admin.dao.impl;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.synergy.bank.admin.dao.BankAdminDao;
import com.synergy.bank.admin.dao.query.AdminQuery;
import com.synergy.bank.customer.dao.entity.CustomerEntity;
import com.synergy.bank.util.BankDaoUtil;

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


	@Override
	public String approvePendingCustomers(String[] cusomerUserNames) {
		
		if(cusomerUserNames.length>0){
			
			String findPendingCustomerDetailsSql = AdminQuery.FIND_PENDING_CUSTOMER_DETAILS
					+ "("
					+ new BankDaoUtil()
							.stringArrayToCommaSeperatedString(cusomerUserNames)
					+ ")";
			List<CustomerEntity> customerDetailsList = super.getJdbcTemplate().query(findPendingCustomerDetailsSql,
					new BeanPropertyRowMapper<CustomerEntity>(CustomerEntity.class));			
			
			for (CustomerEntity customerEntity : customerDetailsList) {
				
				String recentAccountNoSql = "select accountNumber from customer_account_numbers_tbl  where id=  (select  MAX(id) from customer_account_numbers_tbl)";
				
				String recentAccountNo = null;
				try{
					recentAccountNo = super.getJdbcTemplate().queryForObject(recentAccountNoSql, String.class);
				}
				catch(Exception e){
					recentAccountNo = "empty";
				}
								
				Long recentAccoNo;
				Long newAccNo;				
				if(recentAccountNo==null || "empty".equals(recentAccountNo)){
					recentAccoNo = 999999999L;
					newAccNo=1000000000L;
				}
				else{
					recentAccoNo = Long.parseLong(recentAccountNo);
					newAccNo = recentAccoNo+1;
				}
				
				System.out.println("Recent Acc No: "+recentAccoNo);
				System.out.println("New Acc No: "+newAccNo);
				
				Object[] accNumbersData = new Object[]{
						customerEntity.getUserId(), customerEntity.getFirstName()+" "+customerEntity.getMiddleName()+" "+customerEntity.getLastName(),
						newAccNo.toString()
				};				
				super.getJdbcTemplate().update(AdminQuery.ADD_NEW_ACCOUNT_NUMBER, accNumbersData);
				
				Object[] data = new Object[] {
						customerEntity.getUserId(), newAccNo.toString(),
						"AccType", 1000D,
						1000D, "Currency", 
						customerEntity.getFirstName()+" "+customerEntity.getMiddleName()+" "+customerEntity.getLastName(),
						new Date(), new Date()
					};																	
				super.getJdbcTemplate().update(AdminQuery.APPROVE_PENDING_CUSTOMER, data);					
				
			} // End of for loop
			return "success";
		}  // End of if statement
		else return "fails";
	}
	

}
