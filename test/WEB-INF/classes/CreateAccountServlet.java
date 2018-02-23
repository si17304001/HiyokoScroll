import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import DBA.Executer;

public class CreateAccountServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws IOException, ServletException{
		req.setCharacterEncoding("Windows-31J");
		
		String u = req.getParameter("user");
		String p = req.getParameter("pass");
		
		Executer ex=new Executer();
		
		try{
			if(p != "" || u != ""){
				ex.addAccount(u,p);
				HttpSession session = req.getSession();
				session.setAttribute("uname",u);
			}else{}
			RequestDispatcher dis = req.getRequestDispatcher("/index");
				
				dis.forward(req, res);
			
		}
		catch(Exception e){
		e.printStackTrace();}
	}
}