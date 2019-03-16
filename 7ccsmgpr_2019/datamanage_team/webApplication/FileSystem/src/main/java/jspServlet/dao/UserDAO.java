package jspServlet.dao;

import jspServlet.vo.User;
//Define an interface which contains the function used to
//query the database by username.
public interface UserDAO {

	public int queryByUsername(User user)throws Exception;
}
