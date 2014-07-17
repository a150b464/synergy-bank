package com.synergy.bank.customer.dao;

import java.util.List;

import com.synergy.bank.customer.dao.entity.CustomerEntity;
import com.synergy.bank.customer.dao.entity.PayeeDetailsEntity;

/**
 * @author this nagendra.yadav
 * @since 9th July 1014
 * This is contract for customer for the bank.
 */
public interface BankCustomerDao {

	public abstract String addCustomer(CustomerEntity entity);
	public abstract String updateCustomer(CustomerEntity entity);
	public abstract List<CustomerEntity> findCustomers();
	public abstract List<CustomerEntity> findCustomerByColumnNameAndValue(String columnName, String value);
	public abstract CustomerEntity findCustomerByUserId(String userid);
	public abstract List<PayeeDetailsEntity> showPayeeListByUserId(String userId);
	public abstract String deleteCustomer(CustomerEntity entity);
	public abstract byte[] findPhotoById(String userId);
	public abstract String addCustomerLoginDetails(CustomerEntity entity);
	List<CustomerEntity> getCustomerListForRowNumbers(int initialRowNumber,
			int maximumRowNumbers);
	public abstract String updateCustomersnewLoginIdAndPassword(String userId, String password);
	
}
