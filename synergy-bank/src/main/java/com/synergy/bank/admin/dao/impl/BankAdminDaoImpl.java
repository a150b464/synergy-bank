package com.synergy.bank.admin.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.synergy.bank.admin.dao.BankAdminDao;
import com.synergy.bank.admin.dao.entity.ApprovedCustomerEntity;
import com.synergy.bank.admin.dao.query.AdminQuery;
import com.synergy.bank.customer.dao.entity.CustomerAccountEntity;
import com.synergy.bank.customer.dao.entity.CustomerEntity;
import com.synergy.bank.util.BankDaoUtil;

/**
 * 
 * @author Naim
 *
 */


@Repository("BankAdminDaoImpl")
@Scope("singleton")
@Transactional(propagation=Propagation.REQUIRED)
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
	public List<CustomerAccountEntity> approvePendingCustomers(String[] selectedCustomerUserIds) {
		
		List<CustomerAccountEntity> customerAccountEntities = new ArrayList<CustomerAccountEntity>();
		if(selectedCustomerUserIds.length>0){
			String findPendingCustomerDetailsSql = AdminQuery.FIND_PENDING_CUSTOMER_DETAILS
					+ "("
					+ new BankDaoUtil()
							.stringArrayToCommaSeperatedString(selectedCustomerUserIds)
					+ ") and approve='no'";
		
			List<CustomerEntity> customerDetailsList = super.getJdbcTemplate().query(findPendingCustomerDetailsSql,
					new BeanPropertyRowMapper<CustomerEntity>(CustomerEntity.class));			
			
			String recentAccountNo = null;
			try{
				recentAccountNo = super.getJdbcTemplate().queryForObject(AdminQuery.FIND_MOST_RECENT_ACC_NO, String.class);
			}
			catch(Exception e){
			}
			Long newAccNo=0L;		
			if(recentAccountNo==null || recentAccountNo.equals("0")){
				newAccNo=1000000001L;
			}
			
			for (CustomerEntity customerEntity : customerDetailsList) {
				newAccNo=newAccNo+1;
				Object[] data = new Object[] {
						customerEntity.getUserId(), newAccNo.toString(),
						"Savings", 1000D,
						1000D, "USD", 
						customerEntity.getFirstName()+" "+customerEntity.getMiddleName()+" "+customerEntity.getLastName(),
						new Date(), new Date(),customerEntity.getEmail()
					};																	

				//inserting new into customer_account_info_tbl
				super.getJdbcTemplate().update(AdminQuery.APPROVE_PENDING_CUSTOMER, data);
				
				//changing flag in customer_details_tbl which is approved now
				super.getJdbcTemplate().update(AdminQuery.UPDATE_CUSTOMER_DETAILS_APPROVE,customerEntity.getUserId());
				
				//changing flag in customer_login_tbl which is approved now
				super.getJdbcTemplate().update(AdminQuery.UPDATE_CUSTOMER_LOGIN_APPROVE,customerEntity.getUserId());
				CustomerAccountEntity customerAccountEntity = new CustomerAccountEntity();
				customerAccountEntity.setUserid(customerEntity.getUserId());
				customerAccountEntity.setCustomerName(customerEntity.getFirstName()+" "+customerEntity.getMiddleName()+" "+customerEntity.getLastName());
				customerAccountEntity.setCustomerAccountNo(newAccNo.toString());
				customerAccountEntity.setTotalAvailBalance(1000D);
				customerAccountEntity.setCustomerEmail(customerEntity.getEmail());
				customerAccountEntities.add(customerAccountEntity);
				
			} // End of for loop
			return customerAccountEntities;
		}  // End of if statement
		else{ 
			return customerAccountEntities;
		}	
	}


	@Override
	public List<ApprovedCustomerEntity> findApprovedCustomerList() {
		
		List<ApprovedCustomerEntity> approvedCustomerEntities = super.getJdbcTemplate().query(AdminQuery.FIND_APPROVED_CUSTOMERLIST,
				new BeanPropertyRowMapper<ApprovedCustomerEntity>(ApprovedCustomerEntity.class));
		
		return approvedCustomerEntities;
	}
	
	@Override
	public boolean blockCustomer(String[] cusomerUserNames) {
	
		try{
			for (String cusomerUserName : cusomerUserNames) {
				super.getJdbcTemplate().update(AdminQuery.BLOCK_CUSTOMER_QUERY+"'"+cusomerUserName+"'");
				/*System.out.println(cusomerUserName);
				System.out.println(AdminQuery.BLOCK_CUSTOMER_QUERY+"'"+cusomerUserName+"'");*/
			}			
		}
		catch(Exception e){
			
			e.printStackTrace();
			return false;
		}
/*		System.out.println("D Impl"+cusomerUserNames);
*/		return true;
	}
}
