package com.example.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * Generic DAO interface
 * @author dan
 *
 * @param <E> the entity
 * @param <K> the primary key
 */

public interface GenericDao<E, K extends Serializable> {
	K save(E entity);
	void update(E entity);
	void delete(E entity);
	E findById(K key);
	List<E> findAll();
	List<E> findByProperty(String propertyName, Object value);
}
