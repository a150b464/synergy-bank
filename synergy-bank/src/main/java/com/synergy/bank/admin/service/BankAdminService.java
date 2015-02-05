package com.synergy.bank.admin.service;

import java.util.List;

import com.synergy.bank.admin.web.controller.form.ApprovedCustomerForm;
import com.synergy.bank.customer.web.controller.form.CustomerAccountForm;
import com.synergy.bank.customer.web.controller.form.CustomerForm;

public interface BankAdminService {
	
	public List<CustomerForm> findPendingCustomerList();
	public List<CustomerAccountForm> approvePendingCustomers(String[] cusomerUserNames);
	public List<ApprovedCustomerForm> findApprovedCustomerList();
	public boolean blockCustomer(String[] cusomerUserNames);
	public boolean unblockCustomer(String[] unblockedIds);
	public boolean lockUnlockCustomer(String userid, String status);
}
