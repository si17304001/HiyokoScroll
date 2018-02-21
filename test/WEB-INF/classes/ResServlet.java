import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBA.Executer;

public class ResServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws IOException, ServletException{
		Executer ex=new Executer();
		try{
			String ThID = req.getParameter("id");
			
			req.setAttribute("res",ex.getRes(ThID));
			
			RequestDispatcher dis = req.getRequestDispatcher("/res");
			
			dis.forward(req, res);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws IOException, ServletException{
		Executer ex=new Executer();
		String content = req.getParameter("content");
		String user = req.getParameter("username");
		String T = req.getParameter("TID");

		ex.writeRes(content, user, T);
		System.out.println("content = "+content);
		System.out.println("user = "+user);
		System.out.println("Thread ID = "+T);
		try{
			String ThID = req.getParameter("id");
			
			req.setAttribute("res",ex.getRes(ThID));
			
			RequestDispatcher dis = req.getRequestDispatcher("/res");

			dis.forward(req, res);
		}catch(IOException e){
			e.printStackTrace();
		}


	}
}