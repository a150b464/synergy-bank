package com.synergy.bank.common.dao;

/**
 * 
 * @author Swapnil
 *
 */
public interface BankJdbcDao {
	public String nextUserID();
	public String nextTransactionId();
	public char[] generatePassword();
}
