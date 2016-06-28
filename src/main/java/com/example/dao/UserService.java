package com.example.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;

@Service
@Transactional
public class UserService {

	@Autowired
	private HibernateDaoImpl<User, Long> userDao;
	
	public Long save(User user) {	
		return userDao.save(user);
	}
	
	public void update(User user) {
		userDao.update(user);
	}
	
}
