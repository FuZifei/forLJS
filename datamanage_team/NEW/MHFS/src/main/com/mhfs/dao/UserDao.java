package com.mhfs.dao;

import com.mhfs.javabean.User;

public interface UserDao {
	// 添加一条用户信息，返回操作是否成功
	boolean addUser(User user);

	// 修改用户密码，返回操作是否成功
	boolean changePwd(String name, String np);

	// 验证用户，返回操作是否成功
	boolean verifyUser(User user);

	// 检查用户名是否存在
	boolean checkNameExist(String username);
}
