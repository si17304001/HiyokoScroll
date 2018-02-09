import aaa.*;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		
		req.setCharacterEncoding("Windows-31J");
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws ServletException, IOException{
		
		req.setCharacterEncoding("Windows-31J");
	}
}