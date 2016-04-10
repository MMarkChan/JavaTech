package com.jay.demo.dao;

import com.jay.demo.bean.User;

public interface UserDao {
	
	User findUserByUsername(String username); 
}
