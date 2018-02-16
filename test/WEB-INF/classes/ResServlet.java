import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws IOException, ServletException{
		DBAccessor dba=new DBAccessor();
		try{
			String ThID = req.getParameter("id");
			
			req.setAttribute("res",dba.getRes(ThID));
			
			RequestDispatcher dis = req.getRequestDispatcher("/res");
			
			dis.forward(req,res);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}