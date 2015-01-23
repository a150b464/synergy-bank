package com.synergy.bank.customer.dao;

import java.util.List;

import com.synergy.bank.customer.dao.entity.CustomerAccountEntity;

public interface CustomerAccountDao {

	public List<CustomerAccountEntity> findCustomerAccountByUserId(String userId);

	public double getBalance(String userId);

	/*public String updateAmount(double remAmount);*/

	public String updateAmount(double remAmount, String userid);
}
