package Login_Signup;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
//import java.util.List;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.json.JSONException;
//import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
//import org.json.JSONException;
//import org.json.JSONException;
import org.json.JSONObject;


public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)
	    throws ServletException, IOException {
		
		String le=req.getParameter("k5");
		String lp=req.getParameter("k6");
		
		UserBeam luser = new UserBeam();
		
		luser.setUserEmail(le);
		luser.setPassword(lp);
		
		LoginImp limp = new LoginImp();
		
		//new try
		
		int flag = 0;

		try {
			flag = limp.gotoLogin(luser);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(flag==1) {
			System.out.println("Login Successful!");
			JSONObject jsonObj = new JSONObject();
			try {
				jsonObj.put("UserInfo", le+','+lp);
			    
				PrintWriter pw = resp.getWriter();
			    pw.write(jsonObj.toString());
			    pw.print(jsonObj.toString());
			    
			    System.out.println("LOGIN successful！"+ jsonObj.toString());
			    
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		/*ArrayList<UserBeam> userdata = limp.gotoLogin(luser);
		
		for(UserBeam u:userdata) {
			
			if(u.getUserEmail().equals(luser.getUserEmail()) && u.getPassword().equals(luser.getPassword())){
				
				JSONArray array = new JSONArray(userdata);
			
					PrintWriter pw = resp.getWriter();
					pw.write(array.toString());
					pw.print(array.toString());
					
					System.out.println("JSONArray data"+array.toString());
		  }
	   }*/
	}
}
