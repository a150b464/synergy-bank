package com.synergy.bank.customer.service;

/**
 * @author  Tridib.Bandopadhyay 
 * @since 9th July 2014
 * This is contract for customer for the bank.
 */

import java.util.List;

import com.synergy.bank.customer.web.controller.form.PayeeDetailsForm;
import com.synergy.bank.customer.web.controller.form.CustomerForm;
import com.synergy.bank.customer.web.controller.form.PayeeDetailsForm;

public interface BankPayeeService {
	
	public String addPayee(PayeeDetailsForm payeeDetailsForm);
	public String confirmPayee(String payeeAccountNo, String userId);
	public List<PayeeDetailsForm> getPayeeListForUserId(String userId);
	public List<PayeeDetailsForm> findPayeeByUserId(String userid);
	public boolean isPayeeExists(String userId, String payeeAccountNo);
	public String checkPayeeAccountNumber(String payeeAcoountNumber) ;
	public String checkPayeeName(String payeeName);
	public String checkPayeeName(String payeeName, String payeeAcoountNumber);
	public String deletePayeeRowById(String userid);
	public List<PayeeDetailsForm> findPayees();
	public List<PayeeDetailsForm> findAllPayees(String userid);
	public PayeeDetailsForm findAllPayeesByUserId(String userid);
	public byte[] findPhotoByEmail(String email);
	public byte[] findPhotoByUsedId(String userId);
	
}
