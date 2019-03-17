package Login_Signup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.json.JSONException;


public class LoginImp {
	
	String DRIVER = "com.mysql.jdbc.Driver";
	String DBURL = "jdbc:mysql://127.0.0.1:3306/DMSYS?useSSL=false";
	String DBUSER = "root";
	String DBPASSWORD = "123456Qq";
	
	Connection con;
	PreparedStatement ps;
	String sql = "SELECT * FROM DMSYS.new_user_info where useremail = ? AND password = ?";
	//ArrayList<UserBeam> userdatalist = new ArrayList<>();
	int flag = 0;

	public int gotoLogin(UserBeam luser) {
		//String le = luser.getUserEmail();
		//String lp = luser.getPassword();
		
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
			ps = con.prepareStatement(sql);
			//ps.setString(1,le);
			//ps.setString(2,lp);
			
			ps.setString(1,luser.getUserEmail());
			ps.setString(2,luser.getPassword());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				//UserBeam user = new UserBeam();
				//user.setUserEmail(rs.getString(1));
				//user.setPassword(rs.getString(2));
				if(rs.getString("useremail").contentEquals(luser.getUserEmail())&&rs.getString("password").contentEquals(luser.getPassword())){
					flag = 1;
					
					
				//userdatalist.add(user);
		
				//System.out.println("Userdata was get:Useremail "+le+",Password "+lp);	
				
			   }
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return userdatalist;
		return flag;
	   }

	}
