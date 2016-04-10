package com.jay.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jay.demo.bean.User;
import com.jay.demo.dao.UserDao;
import com.jay.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao dao;
	
	@Override
	public User findUserByUsername(String username) {
		return dao.findUserByUsername(username);
	}
	
}
