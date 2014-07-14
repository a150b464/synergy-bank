package com.synergy.bank.admin.service;

import java.util.List;
import com.synergy.bank.customer.web.controller.form.CustomerForm;

public interface BankAdminService {
	
	public List<CustomerForm> findPendingCustomerList();
	public String approvePendingCustomers(String[] cusomerUserNames);

}
