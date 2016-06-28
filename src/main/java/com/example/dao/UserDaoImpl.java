package com.example.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.model.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl extends HibernateDaoImpl<User, Long> {

	@Override
	protected Class<User> getEntityClass() {
		return User.class;
	}
	
	
}
