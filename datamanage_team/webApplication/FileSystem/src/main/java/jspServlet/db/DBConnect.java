package jspServlet.db;



import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	Connection con;
	String driver = "com.mysql.cj.jdbc.Driver";
	String DBURL = "jdbc:mysql://127.0.0.1:3306/filesystemdb?serverTimezone=GMT";
	String DBUSER = "root";
	String DBPASSWORD = "feifei960728";
	
	public DBConnect(){
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
			//System.out.println("Success!!!!");
			//System.out.println(con);
		}catch(Exception e){
			e.printStackTrace();
			//System.out.println(e.getMessage()+"23333");
			//System.out.println("Error!!!!!");
		}
	}
	
	public Connection getConnection(){
		return this.con;
	}
	
	public void close(){
		try{
			this.con.close();
		}catch(Exception e){}
	}

}
