package com.synergy.bank.customer.dao;

/**
 * @author this Tridib.Bandopadhyay 
 * @since 9th July 2014
 * This is contract for customer for the bank.
 */


import java.util.List;

import com.synergy.bank.customer.dao.entity.PayeeDetailsEntity;

public interface BankPayeeDao {
	public String addPayee(PayeeDetailsEntity payeeDetailsEntity);	
	public String confirmPayee(PayeeDetailsEntity payeeDetailsEntity);
	public List<PayeeDetailsEntity> getPayeeListForUserId(String userId);
	public abstract PayeeDetailsEntity findPayeeByUserId(String userid);
	public boolean isPayeeExists(String userId, String payeeAccountNo);
	public String confirmPayee(String payeeAccountNo, String userId);
	public String checkPayeeAccountNumber(String payeeAcoountNumber);
	public String checkPayeeName(String payeeName,String payeeAcoountNumber);
	
	public String checkTransactionAmountNumber(String transactionAmount);
}
