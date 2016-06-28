package com.example.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.model.Group;

@Repository("groupDao")
@Transactional
public class GroupDaoImpl extends HibernateDaoImpl<Group, Long> {

	@Override
	protected Class<Group> getEntityClass() {
		return Group.class;
	}

}
