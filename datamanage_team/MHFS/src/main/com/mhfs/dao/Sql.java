package com.mhfs.dao;

public class Sql {
	/**
	 * UserDao sql
	 */
	public static final String ADD_USER = "insert into users values (?, ?)";
	public static final String VERIFY_USER = "select * from users where name = ? and pwd = ?";
	public static final String CHECK_NAME_EXIST = "select * from users where name = ?";
	public static final String CHANGE_PWD = "update users set pwd = ? where name = ?";

	/**
	 * filedao sql
	 */
	public static final String SEARCH_FILE = "select id, u_name, name from file where u_name like ? and name like ? and private = 0";
	public static final String SEARCH_FILE_BY_ID = "select * from file where id = ?";
	public static final String SEARCH_PRI_FILE = "select  id, u_name, name from file where u_name = ? and private = 1";
	public static final String ADD_FILE = "insert into file values (null, ?, ?, ?, ?)";
	public static final String GET_UNMAE_BY_FID = "select u_name from file where id = ?";
	public static final String DELETE_FILE = "delete from file where id = ?";
	public static final String UPDATE_FILE_BY_ID = "update file set name = ? , content = ? where id = ?";

	/**
	 * common sql
	 */
	public static final String SELECT_LAST_INSERT_ID = "SELECT LAST_INSERT_ID()";

}
