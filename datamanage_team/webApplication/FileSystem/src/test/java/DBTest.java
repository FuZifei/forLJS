
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jspServlet.db.DBConnect;

import jspServlet.vo.User;

//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;



public class DBTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con;
		String driver = "com.mysql.cj.jdbc.Driver";
		String DBURL = "jdbc:mysql://106.15.186.234:3306/DMSYS?serverTimezone=GMT";
		String DBUSER = "root";
		String DBPASSWORD = "123456";
		
		
		
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
			System.out.println("Success!!!!");
			System.out.println(con);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error!!!!!");}
		
		//String rusername = "fuzifei";
		//String rpassword = "123";
		//String remail = "123@qq.com";
		//try {
		//DBConnect db = new DBConnect();
		
		
		//}catch(Exception e) {
			//e.printStackTrace();
		//}
		//String sql = "INSERT INTO user_info(username,password,emailaddress)"+"VALUES("+"'"+rusername+"','"+rpassword+"','"+remail+"');";Connection conn = db.getConnection();
		
		//System.out.println(db);
		
		//Statement statement = conn.createStatement();
		//
		//statement.executeUpdate(sql);
		
		//statement.close();
		
		//conn.close();
	//}catch(Exception e) {
		//e.printStackTrace();
	//}
	
	User user = new User();
	user.setUsername("fuzifei");
	user.setPassword("123");
	user.setEmailAddress("asd");
	
	DBConnect dbc = new DBConnect();
	String sql = "SELECT * FROM user_info where username=?";
	PreparedStatement pstmt = null;
	try {
		pstmt = dbc.getConnection().prepareStatement(sql);
		pstmt.setString(1,user.getUsername());
		
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			if(rs.getString("password").contentEquals(user.getPassword())){
				System.out.println("YES@");
				System.out.println(rs.getString("password"));
			}
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("errrrrrrrrro1");
	}
	System.out.println(pstmt);
	if(pstmt==null) {System.out.println("null pointer!!!!!!");}	

	}

}
