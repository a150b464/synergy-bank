package com.synergy.bank.customer.dao;

/**
 * @author this Tridib.Bandopadhyay 
 * @since 9th July 2014
 * This is contract for customer for the bank.
 */


import java.util.List;

import com.synergy.bank.customer.dao.entity.CustomerEntity;
import com.synergy.bank.customer.dao.entity.PayeeDetailsEntity;

public interface BankPayeeDao {
	
	public String addPayee(PayeeDetailsEntity payeeDetailsEntity);	
	public String confirmPayee(String payeeAccountNo, String userId);
	public abstract List<PayeeDetailsEntity> findPayeeByUserId(String userid);
	public boolean isPayeeExists(String userId, String payeeAccountNo);
}
