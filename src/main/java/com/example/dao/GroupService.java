package com.example.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Group;

@Service
@Transactional
public class GroupService {

	@Autowired
	private HibernateDaoImpl<Group, Long> groupDao;
	
	public Long save(Group group) {	
		return groupDao.save(group);
	}
	
	public void remove(Group group) {
		Group groupToRemove = findById(group.getId());
		
		groupDao.delete(groupToRemove);
	}
	
	public Group findById(Long id) {
		return groupDao.findById(id);
	}
}
