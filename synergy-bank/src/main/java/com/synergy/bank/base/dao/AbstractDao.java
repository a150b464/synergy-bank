package com.synergy.bank.base.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;

import com.synergy.bank.customer.dao.entity.CustomerEntity;

/**
 * @author nagendra
 * @param <E>
 * @param <I>
 */
public interface AbstractDao<E, I extends Serializable> {

	public E findById(I id);
    public void saveOrUpdate(E e);
    public List<E> findByCriteria(Criterion criterion);
    public List<E> findAll();
	void delete(E e);
    public List<E> findByAttributeAndValue(I attribute,I value);
	List<CustomerEntity> getCustomerListForRowNumbers(int initialRowNumber,
			int maximumRowNumbers);
	int getCount();	
}
