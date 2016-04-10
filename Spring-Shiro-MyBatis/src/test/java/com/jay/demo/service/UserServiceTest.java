package com.jay.demo.service;

import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jay.demo.bean.Permission;
import com.jay.demo.bean.Role;
import com.jay.demo.bean.User;
import com.jay.demo.service.UserService;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/context-global.xml"})
public class UserServiceTest {
	@Autowired
	private UserService userService;
	
	@Test
	public void testFindUserByName(){
		User user = userService.findUserByUsername("Tomy");
		System.out.println(user.getId());
		System.out.println(user.getRoleSet().size());
		if(user.getRoleSet().size()>1){
			Iterator<Role> it = user.getRoleSet().iterator();
			while(it.hasNext()){
				Iterator<Permission> pit = it.next().getPermissionSet().iterator();
				while(pit.hasNext()){
					System.out.println(pit.next().getName()+"++++");
				}
			}
		}
	}
}
