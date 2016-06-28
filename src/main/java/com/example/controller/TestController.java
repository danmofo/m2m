package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.cypher.internal.compiler.v2_1.planner.logical.findShortestPaths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dao.GroupService;
import com.example.dao.UserService;
import com.example.model.Group;
import com.example.model.User;

@Controller
public class TestController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private GroupService groupService;
	
	@RequestMapping(value="/")
	public String home() {
		
		User daniel = new User();
		User david = new User();
		
		Group work = new Group();
		Group home = new Group();
		
		List<Group> groups = new ArrayList<Group>();
		groups.add(work);
		groups.add(home);
		work.getUsers().add(daniel);
		home.getUsers().add(david);
	
		List<Group> moreGroups = new ArrayList<Group>();
		moreGroups.add(groupService.findById(1L));
		
		daniel.setGroups(groups);		
		david.setGroups(moreGroups);
		
		userService.save(daniel);
		userService.save(david);
		
		daniel.getGroups().clear();
		
		work.getUsers().remove(daniel);
		
		userService.update(daniel);
		
		david.getGroups().add(groupService.findById(2L));
		userService.update(david);
		
		System.out.println(home);
		System.out.println(work);
		
				
		return "/templates/home";
	}
	
}
