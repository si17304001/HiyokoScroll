import DBA.Executer;

import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThreadServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws IOException, ServletException{
		
		req.setCharacterEncoding("Windows-31J");
		
		Executer ex=new Executer();
		
		try{
			req.setAttribute("thread",ex.getThread());
			
			RequestDispatcher dis = req.getRequestDispatcher("/index");
			
			dis.forward(req, res);
		
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ThreadÇÃàÍóóï\é¶Ç≈ó·äO");
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws IOException, ServletException{
		
		req.setCharacterEncoding("Windows-31J");
		HttpSession session = req.getSession(false);
		String user = null;
		
		String Tname = req.getParameter("Tname");
		
		if(session.getAttribute("username") != null){
			user = session.getAttribute("username").toString();
		}else{}
		
		Executer ex=new Executer();
		System.out.println(Tname);
		System.out.println(user);
	try{
		if(Tname == ""){
			RequestDispatcher dis = req.getRequestDispatcher("/index");
			
			dis.forward(req, res);
		}else{
		ex.writeThread(Tname,user);
		
		RequestDispatcher dis = req.getRequestDispatcher("/index");
		
		dis.forward(req, res);
		}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ThreadçÏê¨Çé∏îsÇµÇ‹ÇµÇΩ");
		}
	}
}