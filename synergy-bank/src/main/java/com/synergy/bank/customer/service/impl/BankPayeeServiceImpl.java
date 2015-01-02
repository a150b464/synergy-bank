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
		/*
		 * System.out.println(payeeDetailsForm);
		 * System.out.println("In service Layer");
		 */
		PayeeDetailsEntity payeeDetailsEntity = new PayeeDetailsEntity();
		BeanUtils.copyProperties(payeeDetailsForm, payeeDetailsEntity);
		return bankPayeeDao.addPayee(payeeDetailsEntity);
	}

	@Override
	public String confirmPayee(String payeeAccountNo, String userId) {

		return bankPayeeDao.confirmPayee(payeeAccountNo, userId);
	}

	@Override
	public List<PayeeDetailsForm> findPayeeByUserId(String userid) {
		List<PayeeDetailsForm> payeeDetailsForms = new ArrayList<PayeeDetailsForm>();
		List<PayeeDetailsEntity> payeeDetailsEntities = (List<PayeeDetailsEntity>) bankPayeeDao
				.getPayeeListForUserId(userid);
		for (PayeeDetailsEntity payeeDetailsEntity : payeeDetailsEntities) {
			PayeeDetailsForm payeeDetailsForm = new PayeeDetailsForm();
			BeanUtils.copyProperties(payeeDetailsEntity, payeeDetailsForm);
			payeeDetailsForms.add(payeeDetailsForm);
		}

		return payeeDetailsForms;
	}

	@Override
	public boolean isPayeeExists(String userId, String payeeAccountNo) {
		return bankPayeeDao.isPayeeExists(userId, payeeAccountNo);

	}

	@Override
	public List<PayeeDetailsForm> getPayeeListForUserId(String userId) {
		return null;
	}

	@Override
	public String checkPayeeAccountNumber(String payeeAcoountNumber) {
		return bankPayeeDao.checkPayeeAccountNumber(payeeAcoountNumber);
	}

	@Override
	public String checkPayeeName(String payeeName) {
		return bankPayeeDao.checkPayeeAccountNumber(payeeName);
	}

	@Override
	public String checkPayeeName(String payeeName, String payeeAcoountNumber) {
		// TODO Auto-generated method stub
		return bankPayeeDao.checkPayeeName(payeeName, payeeAcoountNumber);
	}

}
