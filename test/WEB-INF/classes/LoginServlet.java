import java.io.IOException;
import DBA.Executer;
import Bean.UserBean;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;

public class LoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		
		String userName = req.getParameter("username");
		String password = req.getParameter("pass");
		
		boolean login = false;

		Executer ex = new Executer();
		UserBean ub = new UserBean();
		String user = ex.getUser(userName,password);
		System.out.println("getUser = "+user);
		if(user != null){
			login = true;
		}
			if(login){
				HttpSession session = req.getSession();
				session.setAttribute("uname",userName);
			}else{RequestDispatcher dis = req.getRequestDispatcher("login");
				dis.forward(req, res);
			}

			RequestDispatcher dis = req.getRequestDispatcher("index");
			dis.forward(req, res);
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		
		HttpSession session = req.getSession(false);
		session.invalidate();
		
		RequestDispatcher dis = req.getRequestDispatcher("index");
		dis.forward(req, res);
	}
}