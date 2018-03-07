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
		u = u.replaceAll("<","&lt");
		u = u.replaceAll(">","&gt");
		u = u.replaceAll("\"","&quot");
		u = u.replaceAll("'","&#39");
		u = u.replaceAll("\n","<br>");
		
		p = p.replaceAll("<","&lt");
		p = p.replaceAll(">","&gt");
		p = p.replaceAll("\"","&quot");
		p = p.replaceAll("'","&#39");
		p = p.replaceAll("\n","<br>");
		try{
			if(ex.addAccount(u,p)){
				HttpSession session = req.getSession();
				session.setAttribute("uname",u);
				
				RequestDispatcher dis = req.getRequestDispatcher("/index");
				
				dis.forward(req, res);
			}else{
				req.setAttribute("ames","そのユーザーIDは使われています");
				
				RequestDispatcher dis = req.getRequestDispatcher("/register");
				
				dis.forward(req, res);
			}
			
			
		}
		catch(Exception e){
		e.printStackTrace();}
	}
}