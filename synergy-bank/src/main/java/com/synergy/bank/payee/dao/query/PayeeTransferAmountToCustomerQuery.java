package com.synergy.bank.payee.dao.query;
/**
 * @author this Tridib.Bandopadhyay
 * @since 9th July 2014
 * This is contract for customer for the bank.
 */
public interface PayeeTransferAmountToCustomerQuery {
 public static final String INSERT_Payee="insert into payeeDetails(payeeAccountNumber," +
 		"payeeName,payeeNickName," + "payeeReAccountNumber,payeeAccountType,payeeEmailId) " +
 				"values(?,?,?,?,?,?)";

}
