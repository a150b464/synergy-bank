package com.synergy.bank.customer.dao;

/**
 * @author this Tridib.Bandopadhyay 
 * @since 9th July 2014
 * This is contract for customer for the bank.
 */


import java.util.List;

import com.synergy.bank.customer.dao.entity.PayeeDetailsEntity;
import com.synergy.bank.customer.dao.entity.PayeeDetailsEntity;

public interface BankPayeeDao {
	public String addPayee(PayeeDetailsEntity payeeDetailsEntity);	
	public String confirmPayee(PayeeDetailsEntity payeeDetailsEntity);
	public List<PayeeDetailsEntity> getPayeeListForUserId(String userId);
	public abstract PayeeDetailsEntity findPayeeByUserId(String userid);

}
