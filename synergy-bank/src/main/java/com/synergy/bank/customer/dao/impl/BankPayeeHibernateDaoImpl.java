package com.synergy.bank.customer.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.synergy.bank.base.dao.AbstractDaoImpl;
import com.synergy.bank.customer.dao.BankPayeeDao;
import com.synergy.bank.customer.dao.entity.CustomerEntity;
import com.synergy.bank.customer.dao.entity.CustomerTransactionsEntity;
import com.synergy.bank.customer.dao.entity.PayeeDetailsEntity;


@Repository("BankPayeeHibernateDaoImpl")
@Transactional(propagation = Propagation.REQUIRED, value = "transactionManager")
public class BankPayeeHibernateDaoImpl extends AbstractDaoImpl<PayeeDetailsEntity, String>
										implements BankPayeeDao{

	protected BankPayeeHibernateDaoImpl() {
		super(PayeeDetailsEntity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<CustomerEntity> getCustomerListForRowNumbers(
			int initialRowNumber, int maximumRowNumbers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addPayee(PayeeDetailsEntity payeeDetailsEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String confirmPayee(PayeeDetailsEntity payeeDetailsEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PayeeDetailsEntity> getPayeeListForUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PayeeDetailsEntity findPayeeByUserId(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPayeeExists(String userId, String payeeAccountNo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String confirmPayee(String payeeAccountNo, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String checkPayeeAccountNumber(String payeeAcoountNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String checkPayeeName(String payeeName, String payeeAcoountNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String checkTransactionAmountNumber(String transactionAmount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletePayeeRowById(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PayeeDetailsEntity> findPayees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PayeeDetailsEntity> findAllPayees(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] findPhotoByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] findPhotoByUsedId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PayeeDetailsEntity findAllPayeesByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updatePayee(PayeeDetailsEntity payeeDetailsEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PayeeDetailsEntity> findPayeesByEmail(String email) {
		//Criterion criterion = Restrictions.eq("email", email);
		
		Criteria criteria = super.findByCriteria();
		List<PayeeDetailsEntity> payeeDetailsEntities = criteria
				.add(Restrictions.eq("email", email))
				.addOrder(Order.desc("payeeName")).setFirstResult(0)
				.setMaxResults(1).list();
		return payeeDetailsEntities;
	}

}
