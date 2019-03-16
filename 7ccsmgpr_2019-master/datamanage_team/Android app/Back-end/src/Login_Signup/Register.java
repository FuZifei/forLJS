package Login_Signup;

import java.io.IOException;
import java.io.PrintWriter;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

public class Register extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	  throws ServletException, IOException{
		//super.doPost(req, resp);
		
		String fn=req.getParameter("k1");
		String se=req.getParameter("k2");
		String sp=req.getParameter("k3");
		//String img=req.getParameter("k4");
		
		UserBeam user = new UserBeam();
		
		user.setUsername(fn);
		user.setUserEmail(se);
		user.setPassword(sp);
		//user.setUserImg(img);
		
		RegisterImp rimp = new RegisterImp();
		
		int i = rimp.registerUser(user);
		
		if(i>0) {
			System.out.println("Register successfull!");
			JSONObject jsonObject = new JSONObject();
			try {
				jsonObject.put("UserInfo", fn+','+se+','+sp);
			    //jsonObject.put("REGISTER", "SUCCESS");
			    PrintWriter pw = resp.getWriter();
			    pw.write(jsonObject.toString());
			    pw.print(jsonObject.toString());
			    
			    System.out.println("REGISTER successful！"+ jsonObject.toString());
			    
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}
}
