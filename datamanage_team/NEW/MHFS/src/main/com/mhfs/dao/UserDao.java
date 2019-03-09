package com.mhfs.dao;

import com.mhfs.javabean.User;

public interface UserDao {
	// add an user and see whether it is successful
	boolean addUser(User user);

	// change user password
	boolean changePwd(User user);

	// whether verification successful
	boolean verifyUser(User user);

	// if the username exist
	boolean checkNameExist(String username);
}
