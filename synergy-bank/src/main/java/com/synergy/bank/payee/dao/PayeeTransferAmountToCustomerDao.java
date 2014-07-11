package com.synergy.bank.payee.dao;

/**
 * @author this Tridib.Bandopadhyay 
 * @since 9th July 2014
 * This is contract for customer for the bank.
 */

import java.util.List;

import com.synergy.bank.payee.dao.entity.PayeeTransferAmountToCustomerEntity;

public interface PayeeTransferAmountToCustomerDao {
	
	public String addPayee(PayeeTransferAmountToCustomerEntity payeeTransferAmountToCustomerEntity);
	public List<PayeeTransferAmountToCustomerEntity> showPayee();

}
