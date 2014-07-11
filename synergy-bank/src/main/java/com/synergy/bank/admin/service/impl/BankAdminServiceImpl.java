package com.synergy.bank.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.synergy.bank.customer.dao.entity.CustomerEntity;
import com.synergy.bank.customer.web.controller.form.CustomerForm;


@Service("BankAdminServiceImpl")
@Scope("singleton")
public class BankAdminServiceImpl implements com.synergy.bank.admin.service.BankAdminService{

	@Autowired
	@Qualifier("BankAdminDaoImpl")
	private com.synergy.bank.admin.dao.BankAdminDao bankAdminDao;

	@Override
	public List<CustomerForm> findPendingCustomerList() {
		
		List<CustomerEntity> pendingCustomerEntityList = bankAdminDao.findPendingCustomerList();  
		List<CustomerForm> pendingApprovalCustomerList= new ArrayList<CustomerForm>();
		
		for (CustomerEntity customerEntity : pendingCustomerEntityList) {
			CustomerForm cf = new CustomerForm();
			BeanUtils.copyProperties(customerEntity, cf);
			pendingApprovalCustomerList.add(cf);
		}		
		return pendingApprovalCustomerList;
	}
	
	
	
}
