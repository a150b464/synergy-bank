package com.synergy.bank.customer.dao;

import java.util.List;

import com.synergy.bank.customer.dao.entity.CustomerAccountEntity;

public interface CustomerAccountDao {

	List<CustomerAccountEntity> findCustomerAccountByUserId(String userId);
}
