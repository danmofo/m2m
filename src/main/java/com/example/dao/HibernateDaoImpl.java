package com.example.dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Extend this class to add basic CRUD methods to a DAO.
 * @author dan
 *
 * @param <E>
 * @param <K>
 */

@Repository
public abstract class HibernateDaoImpl<E, K extends Serializable> implements GenericDao<E, K> {
	
	/**
	 * Inherited classes MUST implement this method, returning the entity class
	 * @return
	 */
	protected abstract Class<E> getEntityClass();
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session session() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public K save(E entity) {
		return (K)session().save(entity);
	}

	@Override
	public void update(E entity) {
		session().saveOrUpdate(entity);
	}

	@Override
	public void delete(E entity) {
		session().delete(entity);
	}

	@Override
	public E findById(K key) {
		return (E)session().get(getEntityClass(), key);
	}

	@Override
	public List<E> findAll() {
		return (List<E>)session().createCriteria(getEntityClass()).list();
	}
		
	@Override
	public List<E> findByProperty(String propertyName, Object value) {
		Criteria c = session().createCriteria(getEntityClass()).add(Restrictions.eq(propertyName, value));
		return (List<E>)c.list();
	}
	
	
}
