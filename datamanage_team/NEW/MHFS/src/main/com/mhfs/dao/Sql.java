package com.mhfs.dao;

public class Sql {
	/**
	 * UserDao sql
	 */
	public static final String ADD_USER = "insert into users values (?, ?)";
	public static final String VERIFY_USER = "select * from users where name = ? and pwd = ?";
	public static final String CHECK_NAME_EXIST = "select * from users where name = ?";

	/**
	 * common sql
	 */
	public static final String SELECT_LAST_INSERT_ID = "SELECT LAST_INSERT_ID()";

}
