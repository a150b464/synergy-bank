package com.synergy.bank.customer.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.synergy.bank.base.dao.AbstractDaoImpl;
import com.synergy.bank.common.web.controller.LoginController;
import com.synergy.bank.customer.dao.BankCustomerDao;
import com.synergy.bank.customer.dao.entity.CustomerEntity;
import com.synergy.bank.customer.dao.entity.CustomerRegistrationQuestionsEntity;
import com.synergy.bank.customer.dao.entity.PayeeDetailsEntity;

@Repository("BankCustomerHibernateDaoImpl")
@Transactional(propagation = Propagation.REQUIRED, value = "transactionManager")
public class BankCustomerHibernateDaoImpl extends
		AbstractDaoImpl<CustomerEntity, String> implements BankCustomerDao {
	
	/**
     * Initiate Logger for this class
     */
    private static final Log logger = LogFactory.getLog(BankCustomerHibernateDaoImpl.class);

	protected BankCustomerHibernateDaoImpl() {
		super(CustomerEntity.class);
	}

	@Override
	public String addCustomer(CustomerEntity entity) {
		boolean yes = TransactionSynchronizationManager
				.isActualTransactionActive();
		if (yes) {
			/*System.out.println("woowowow spring transaction is working ...");*/
		} else {
			/*System.out.println("not woowowow since spring transaction is not working ...");*/
		}
		entity.setApprove("no");
		super.saveOrUpdate(entity);
		return "success";
	}

	@Override
	public String addCustomerLoginDetails(CustomerEntity entity) {
		super.saveOrUpdate(entity);
		return "success";
	}

	@Override
	public String updateCustomer(CustomerEntity entity) {
		super.saveOrUpdate(entity);
		return "success";
	}

	@Override
	public String deleteCustomer(CustomerEntity entity) {
		super.delete(entity);
		return "success";
	}

	@Override
	public List<CustomerEntity> findCustomers() {
		return super.findAll();
	}

	@Override
	public CustomerEntity findCustomerByUserId(String userid) {
		return super.findById(userid);
	}

	/*@Override
	public List<PayeeDetailsEntity> showPayeeListByUserId(String userId) {
		return null;
	}*/

	@Override
	public List<CustomerEntity> findCustomerByColumnNameAndValue(
			String columnName, String value) {
		return super.findByAttributeAndValue(columnName, value);
	}

	@Override
	public byte[] findPhotoById(String userId) {
		return super.findById(userId).getPhoto();
	}

	@Override
	public List<CustomerEntity> getCustomerListForRowNumbers(
			int initialRowNumber, int maximumRowNumbers) {
		Criteria criteria = super.getCurrentSession().createCriteria(
				CustomerEntity.class);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.setFirstResult(initialRowNumber);
		criteria.setMaxResults(maximumRowNumbers*3);

		@SuppressWarnings("unchecked")
		List<CustomerEntity> list = (List<CustomerEntity>) criteria.list();
		if(logger.isDebugEnabled())
		logger.debug("list inside criteria="+list);
		return list;
	}

	@Override
	public int getCount() {
		return super.getCount();
	}

	@Override
	public String updateCustomersnewLoginIdAndPassword(String userId,
			String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerRegistrationQuestionsEntity> findCustomerSecQuestions(
			String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
