package com.synergy.bank.admin.dao.query;

/**
 * 
 * @author naim
 *
 */

public interface AdminQuery {
	
	public static final String FIND_PENDING_CUSTOMER_LIST="select * from customer_details_tbl where approve='no'";
	public static final String FIND_PENDING_CUSTOMER_DETAILS="select * from customer_details_tbl where userId in ";
	public static final String ADD_NEW_ACCOUNT_NUMBER = "insert into customer_account_numbers_tbl (userId,name,accountNumber) value (?,?,?)";
	public static final String APPROVE_PENDING_CUSTOMER = "insert into customer_account_info_tbl (userid,customerAccountNo,accountType,availBalance,totalAvailBalance," +
			"currency,customerName,doe,dom,customerEmail) value(?,?,?,?,?,?,?,?,?,?)";
	public static final String FIND_MOST_RECENT_ACC_NO="select customerAccountNo from customer_account_info_tbl  where id=  (select  MAX(id) from customer_account_numbers_tbl)";
	public static final String UPDATE_CUSTOMER_DETAILS_APPROVE="update customer_details_tbl set approve='yes' where userId=?";
	public static final String UPDATE_CUSTOMER_LOGIN_APPROVE="update customer_login_tbl set approve='yes' where loginId=?";
	public static final String FIND_APPROVED_CUSTOMERLIST = "select cd.userId, cd.firstName,cd.middleName,cd.lastName,cd.email, ca.customerAccountNo,ca.accountType, " +
								"ca.totalAvailBalance,ca.currency from customer_details_tbl cd join customer_account_info_tbl ca join customer_login_tbl cl " +
								"where cd.userId=ca.userid and cd.userId = cl.userId";
	public static final String BLOCK_CUSTOMER_QUERY = "update customer_login_tbl set active='no' where userId=";
	public static final String UNBLOCK_CUSTOMER_QUERY = "update customer_login_tbl set active='yes' where userId=";
}


//and cd.approve = 'yes' and cl.active='yes' and cl.approve='yes'"