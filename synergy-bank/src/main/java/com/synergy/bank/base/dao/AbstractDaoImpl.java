package com.synergy.bank.base.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author yadna01
 * @param <E>
 * @param <I>
 */
public abstract class AbstractDaoImpl<E, I extends Serializable> implements
		AbstractDao<E, I> {

	private Class<E> entityClass;

	protected AbstractDaoImpl(Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	@Autowired
	@Qualifier("synegySessionFactory")
	private SessionFactory psessionFactory;

	
	public Session getCurrentSession() {
		return psessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public E findById(I id) {
		return (E) getCurrentSession().get(entityClass, id);
	}

	@Override
	public void saveOrUpdate(E e) {
		/*System.out.println("Object to save" + e);*/
		getCurrentSession().saveOrUpdate(e);
	}

	@Override
	public List<E> findTopNRandomRows(int count) {

		Criteria criteria = getCurrentSession().createCriteria(entityClass);
		criteria.add(Restrictions.sqlRestriction("1=1 order by rand()"));
		criteria.setMaxResults(count);
		return criteria.list();
	}

	@Override
	public void delete(E e) {
		getCurrentSession().delete(e);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> findByCriteria(Criterion criterion) {
		Criteria criteria = getCurrentSession().createCriteria(entityClass);
		criteria.add(criterion);
		return criteria.list();
	}
	
	public Criteria findByCriteria() {
		Criteria criteria = getCurrentSession().createCriteria(entityClass);
		return criteria;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> findAll() {
		return getCurrentSession().createQuery("from " + entityClass.getName())
				.list();
	}

	@Override
	public int getCount() {
		Number rowCount = (Number) getCurrentSession()
				.createCriteria(entityClass.getName())
				.setProjection(Projections.rowCount()).uniqueResult();
		return rowCount.intValue();
	}

	@Override
	public List<E> findByAttributeAndValue(I attribute, I value) {
		@SuppressWarnings("unchecked")
		List<E> list = getCurrentSession().createQuery(
				"from " + entityClass.getName() + " e where e." + attribute
						+ " like '" + value + "'").list();
		return list;
	}
}
