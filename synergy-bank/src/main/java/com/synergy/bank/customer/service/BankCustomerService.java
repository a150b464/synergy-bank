package com.synergy.bank.customer.service;

import java.util.List;

import com.synergy.bank.customer.web.controller.form.CustomerForm;
import com.synergy.bank.customer.web.controller.form.CustomerRegistrationQuestionsForm;
import com.synergy.bank.customer.web.controller.form.PayeeDetailsForm;

/**
 * @author this nagendra.yadav
 * @since 9th July 1014 This is contract for customer for the bank.
 */
public interface BankCustomerService {

	public String addCustomer(CustomerForm customerForm);

	public String updateCustomer(CustomerForm customerForm);

	public List<CustomerForm> findCustomers();

	public CustomerForm findCustomerByUserId(String userid);

	public String deleteCustomerById(String userId);

	public List<CustomerForm> findCustomersByAttributeAndValue(
			String attribute, String value);

	public byte[] findPhotoById(String userId);

	public List<PayeeDetailsForm> showPayeeListByUserId(String userId);

	// public String addCustomerDetails(CustomerForm customerForm);
	List<CustomerForm> getCustomerListForRowNumbers(int initialRowNumber,
			int maximumRowNumbers);

	public int getCustomerEntriesCount();

	public void updateCustomersnewLoginIdAndPassword(String userId,
			String password);

	public List<CustomerRegistrationQuestionsForm> findCustomerSecQuestions(
			String userid);

	
}
