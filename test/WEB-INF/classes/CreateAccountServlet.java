import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

public class CreateAccountServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws IOException, ServletException{
		req.setCharacterEncoding("Windows-31J");
		String u = req.getParameter("user");
		String p = req.getParameter("pass");
		
		try{
			
			DBAccessor dba=new DBAccessor();
			
			dba.addAccount(u,p);
			
			RequestDispatcher dis = req.getRequestDispatcher("/ThreadServlet");
			dis.forward(req, res);
		}
		catch(Exception e){
		e.printStackTrace();}
	}
}