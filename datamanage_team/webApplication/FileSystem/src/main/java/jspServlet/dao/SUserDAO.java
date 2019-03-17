package jspServlet.dao;

import java.util.List;
import jspServlet.vo.User;

public interface SUserDAO {
	public List<User> userInfo() throws Exception;

}

