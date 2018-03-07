import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBA.Executer;

public class ResServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws IOException, ServletException{
		Executer ex=new Executer();

		try{
			String ThID = req.getParameter("id");
			
			req.setAttribute("threadname",ex.getThreadName(ThID));
			req.setAttribute("top",ex.getTopRes(ThID));
			req.setAttribute("res",ex.getRes(ThID));
			
			RequestDispatcher dis = req.getRequestDispatcher("/res");
			
			dis.forward(req, res);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws IOException, ServletException{
		
		req.setCharacterEncoding("Windows-31J");
		
		Executer ex=new Executer();
		HttpSession session = req.getSession(false);
		String content = req.getParameter("content");
		String user = null;
		String T = req.getParameter("TID");
		
		content = content.replaceAll("<","&lt");
		content = content.replaceAll(">","&gt");
		content = content.replaceAll("\"","&quot");
		content = content.replaceAll("'","&#39");
		content = content.replaceAll("\n","<br>");
		try{
			if(session.getAttribute("username") != null){
				user = session.getAttribute("username").toString();
			}else{}
			
			if(content == ""){
				req.setAttribute("res",ex.getRes(T));
				req.setAttribute("threadname",ex.getThreadName(T));
				req.setAttribute("top",ex.getTopRes(T));
				
				req.setAttribute("m","“à—e‚ð“ü—Í‚µ‚Ä‚­‚¾‚³‚¢");
				
				RequestDispatcher dis = req.getRequestDispatcher("/res");
				
				dis.forward(req, res);
			}else{
				ex.writeRes(content, user, T);
			
				System.out.println("content = "+content);
				System.out.println("user = "+user);
				System.out.println("Thread ID = "+T);
				
				req.setAttribute("res",ex.getRes(T));
				req.setAttribute("threadname",ex.getThreadName(T));
				req.setAttribute("top",ex.getTopRes(T));
				
				RequestDispatcher dis = req.getRequestDispatcher("/res");
				
				dis.forward(req, res);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}