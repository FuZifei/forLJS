package jspServlet.dao;

import jspServlet.vo.User;

public interface CUserDAO {
	
	public int changePwd(User user)throws Exception;

}
