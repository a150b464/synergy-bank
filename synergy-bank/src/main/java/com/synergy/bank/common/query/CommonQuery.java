package com.synergy.bank.common.query;

/**
 * 
 * @author nagendra.yadav
 *
 */
public interface CommonQuery {
	public static final String AUTH_BANK_USER="select loginid as userid,password,role,active,approve,loginCount from customer_login_tbl where loginid=? and password=?";
	public static final String AUTH_DETAIL_BANK_USER="select loginid as userid,password,role,active,approve,loginCount from customer_login_tbl where loginid=?";
	public static final String INSERT_CUSTOMER_LOGIN_DETAILS="insert into customer_login_tbl(userId,password,role,description) values(?,?,?,?)";
	public static final String UPDATE_CUSTOMER_LOGIN_ID_PASSWORD="Update customer_login_tbl set userId=?, password=?";
	public static final String FIND_BIRTHDAY_BASH="select userid,firstName,email,gender from customer_details_tbl WHERE MONTH(dob) = MONTH(CURRENT_DATE) AND DAY(dob) = DAY(CURRENT_DATE)";
}
