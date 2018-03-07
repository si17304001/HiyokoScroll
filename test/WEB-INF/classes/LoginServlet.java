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
		req.setCharacterEncoding("Windows-31J");
		
		String userName = req.getParameter("username");
		String password = req.getParameter("pass");
		
		userName = userName.replaceAll("<","&lt");
		userName = userName.replaceAll(">","&gt");
		userName = userName.replaceAll("\"","&quot");
		userName = userName.replaceAll("'","&#39");
		userName = userName.replaceAll("\n","<br>");
		
		password = password.replaceAll("<","&lt");
		password = password.replaceAll(">","&gt");
		password = password.replaceAll("\"","&quot");
		password = password.replaceAll("'","&#39");
		password = password.replaceAll("\n","<br>");
		
		Executer ex = new Executer();
		String user = ex.getUser(userName,password);
		System.out.println("getUser = "+user);
		
			if(user != ""){
				HttpSession session = req.getSession();
				session.setAttribute("uname",userName);
				
				RequestDispatcher dis = req.getRequestDispatcher("index");
				
				dis.forward(req, res);
				
			}else{
				
				req.setAttribute("lmes","ユーザーIDまたはパスワードが違います！");
				
				RequestDispatcher dis = req.getRequestDispatcher("login");
				
				dis.forward(req, res);
			}

			
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		
		HttpSession session = req.getSession(false);
		session.invalidate();
		
		RequestDispatcher dis = req.getRequestDispatcher("cover");
		dis.forward(req, res);
	}
}