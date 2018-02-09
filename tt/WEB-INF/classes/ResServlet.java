import aaa.*;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ResServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		
		req.setCharacterEncoding("Windows-31J");
		
		Executer ex1 = new Executer();
		
		ResBean re1 = new ResBean();
		
	}	
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		
		req.setCharacterEncoding("Windows-31J");
		
	}
	
}










