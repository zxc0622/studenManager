package com.student.manager.service;

import com.student.manager.beans.User;
import com.student.manager.dao.UserDao;
import com.student.manager.dao.UserDaoImpl;

public class UserserviceImpl implements UserService{

	private UserDao userDao = new UserDaoImpl();
	
	@Override
	public User validateUser(User user) {
		return userDao.getUserByUserInfo(user);
	}
}
