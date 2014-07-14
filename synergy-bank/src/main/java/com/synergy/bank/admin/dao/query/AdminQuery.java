package com.synergy.bank.admin.dao.query;

/**
 * 
 * @author naim
 *
 */

public interface AdminQuery {
	
	public static final String FIND_PENDING_CUSTOMER_LIST="select * from customer_details_tbl";
	public static final String FIND_PENDING_CUSTOMER_DETAILS="select * from customer_details_tbl where userId in ";
	public static final String ADD_NEW_ACCOUNT_NUMBER = "insert into customer_account_numbers_tbl (userId,name,accountNumber) value (?,?,?)";
	public static final String APPROVE_PENDING_CUSTOMER = "insert into customer_account_info_tbl (userid,customerAccountNo,accountType,availBalance,totalAvailBalance," +
			"currency,customerName,doe,dom) value(?,?,?,?,?,?,?,?,?)";

}
