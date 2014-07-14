package com.synergy.bank.common.query;

/**
 * 
 * @author nagendra.yadav
 *
 */
public interface CommonQuery {
	public static final String AUTH_BANK_USER="select loginid as userid,password,role from customer_login_tbl where loginid=? and password=?";
}
