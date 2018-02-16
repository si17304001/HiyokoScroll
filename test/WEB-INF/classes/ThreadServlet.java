
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThreadServlet extends HttpServlet{
  public void doGet(HttpServletRequest req, HttpServletResponse res)
  throws IOException, ServletException{

    req.setCharacterEncoding("Windows-31J");

	   try{
	   	DBAccessor dba=new DBAccessor();
	   	
  		req.setAttribute("thread",dba.getThread());
	   	
  		RequestDispatcher dis = req.getRequestDispatcher("/index");
	   	
  		dis.forward(req, res);

	  }catch(Exception e){
  		e.printStackTrace();
  		System.out.println("Thread‚Ìˆê——•\Ž¦‚Å—áŠO");
  	}
  }
}