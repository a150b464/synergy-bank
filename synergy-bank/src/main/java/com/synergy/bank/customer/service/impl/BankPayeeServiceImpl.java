package com.synergy.bank.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.synergy.bank.customer.dao.BankPayeeDao;
import com.synergy.bank.customer.service.BankPayeeService;
import com.synergy.bank.customer.web.controller.form.PayeeDetailsForm;

@Service("BankPayeeServiceImpl")
public class BankPayeeServiceImpl implements BankPayeeService {
	
	@Autowired
	@Qualifier("BankPayeeDaoImpl")
	private BankPayeeDao bankPayeeDao;

	@Override
	public String addPayee(PayeeDetailsForm payeeDetailsForm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PayeeDetailsForm> showPayee() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
