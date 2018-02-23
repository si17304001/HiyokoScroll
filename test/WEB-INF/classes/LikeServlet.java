import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBA.Executer;

public class LikeServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws IOException, ServletException{
		
		Executer ex=new Executer();
		
		String l = req.getParameter("rID");
		String ThID = req.getParameter("id");
		
		try{
			ex.Like(l);
			
			req.setAttribute("res",ex.getRes(ThID));
			
			RequestDispatcher dis = req.getRequestDispatcher("/res");
			
			dis.forward(req, res);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
		
}