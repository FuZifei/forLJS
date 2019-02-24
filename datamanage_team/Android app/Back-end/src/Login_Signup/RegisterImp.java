package Login_Signup;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

public class RegisterImp {
	//private static final String DRIVER = null;
	String DRIVER = "com.mysql.jdbc.Driver";
	String DBURL = "jdbc:mysql://127.0.0.1:3306/DMSYS?useSSL=false";
	String DBUSER = "root";
	String DBPASSWORD = "123456Qq";
	String sql = "INSERT INTO new_user_info(username,useremail,password) VALUES(?,?,?);";
	//String sql = "INSERT INTO user_info(username,useremail,userimg,password)"+"VALUES("+"'"+fn+"','"+se+"','123','"+sp+"');";
	
	int i;
	
	public int registerUser(UserBeam user) {
		// TODO Auto-generated method stub
		String fn = user.getUsername();
		String se = user.getUserEmail();
		String sp = user.getPassword();
		
		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, fn);
			ps.setString(2, se);
			ps.setString(3, sp);
			i = ps.executeUpdate();
			
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
		
	}

}
