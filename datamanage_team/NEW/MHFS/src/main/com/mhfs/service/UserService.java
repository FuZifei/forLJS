package com.mhfs.service;

import com.mhfs.dao.UserDao;
import com.mhfs.dao.impl.UserDaoImpl;
import com.mhfs.javabean.User;

public class UserService {
	private static String reject = "";

	UserDao userDao = new UserDaoImpl();

	public boolean login(User user) {
		return userDao.verifyUser(user);
	}

	public boolean register(User user) {
		synchronized (reject) {
			if (!userDao.checkNameExist(user.getName())) {
				return userDao.addUser(user);
			}
			return false;
		}
	}
}
