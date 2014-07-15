package com.synergy.bank.customer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.synergy.bank.customer.dao.BankPayeeDao;
import com.synergy.bank.customer.dao.entity.PayeeDetailsEntity;
import com.synergy.bank.customer.service.BankPayeeService;
import com.synergy.bank.customer.web.controller.form.PayeeDetailsForm;

@Service("BankPayeeServiceImpl")
@Scope("singleton")
public class BankPayeeServiceImpl implements BankPayeeService {
	
	@Autowired
	@Qualifier("BankPayeeDaoImpl")
	private BankPayeeDao bankPayeeDao;

	@Override
	public String addPayee(PayeeDetailsForm payeeDetailsForm) {
		
		PayeeDetailsEntity payeeDetailsEntity = new PayeeDetailsEntity();
		BeanUtils.copyProperties(payeeDetailsForm, payeeDetailsEntity);
		return bankPayeeDao.addPayee(payeeDetailsEntity);
	}

	@Override
	public String confirmPayee(PayeeDetailsForm payeeDetailsForm) {
		PayeeDetailsEntity payeeDetailsEntity = new PayeeDetailsEntity();
		BeanUtils.copyProperties(payeeDetailsForm, payeeDetailsEntity);
		return bankPayeeDao.confirmPayee(payeeDetailsEntity);
	}

	@Override
	public List<PayeeDetailsForm> getPayeeListForUserId(String userId) {
		List<PayeeDetailsEntity> payeeDetailsEntityList = bankPayeeDao.getPayeeListForUserId(userId);
		List<PayeeDetailsForm>   payeeDetailsFormList   = new ArrayList<PayeeDetailsForm>(payeeDetailsEntityList.size());

		for(int i=0;i<payeeDetailsEntityList.size();i++)
		{
			PayeeDetailsForm payeeDetailsForm = new PayeeDetailsForm();	
			BeanUtils.copyProperties(payeeDetailsEntityList.get(i),payeeDetailsForm);
			payeeDetailsFormList.add(payeeDetailsForm);
		}
		return payeeDetailsFormList;		
	}
	
	@Override
	public PayeeDetailsForm findPayeeByUserId(String userid) {
		PayeeDetailsForm payeeDetailsForm = new PayeeDetailsForm();
		BeanUtils.copyProperties(bankPayeeDao.findPayeeByUserId(userid), payeeDetailsForm);
		return payeeDetailsForm;
	}

}
