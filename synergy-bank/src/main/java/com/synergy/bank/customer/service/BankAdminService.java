package com.synergy.bank.customer.service;

import java.util.List;
import com.synergy.bank.customer.web.controller.form.CustomerForm;

public interface BankAdminService {
	
	public List<CustomerForm> findPendingCustomerList();

}
