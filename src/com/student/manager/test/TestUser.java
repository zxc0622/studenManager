package com.student.manager.test;

import org.junit.Test;

import com.student.manager.beans.User;
import com.student.manager.dao.UserDao;
import com.student.manager.dao.UserDaoImpl;

public class TestUser {

	private UserDao userDao;
	
	{
		userDao = new UserDaoImpl();
	}
	
	@Test
	public void testValidateUser(){
		User user = new User("zxc", "123456", null);
		User newUser = userDao.getUserByUserInfo(user);
		System.out.println(newUser);
	}
}
