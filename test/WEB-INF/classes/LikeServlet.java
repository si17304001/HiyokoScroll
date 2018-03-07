import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;

import DBA.Executer;

public class LikeServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws IOException, ServletException{
		
		Executer ex=new Executer();
		HttpSession session = req.getSession(false);
		
		String userID = ex.getUserID(session.getAttribute("username").toString());
		String rID = req.getParameter("rID");
		String ThID = req.getParameter("id");
		String like = req.getParameter("like");
		boolean check = true;
		Cookie userck = new Cookie(rID,userID);
		
		Cookie[] cks = req.getCookies();
		if(cks != null){
			for(int i = 0; i < cks.length; i++){
				Cookie ck = cks[i];
				System.out.println("name = "+ck.getName()+" value ="+ck.getValue());
				if(rID.equals(ck.getName())){
					if(userID.equals(ck.getValue())){
						check = false;
					}
				}
			}
		}
		if(check){
			try{
				ex.Like(rID,like);
				res.addCookie(userck);
				req.setAttribute("threadname",ex.getThreadName(ThID));
				req.setAttribute("top",ex.getTopRes(ThID));
				req.setAttribute("res",ex.getRes(ThID));
				
				RequestDispatcher dis = req.getRequestDispatcher("/res");
				
				dis.forward(req, res);
			}catch(IOException e){
				e.printStackTrace();
			}
		}else{
			req.setAttribute("threadname",ex.getThreadName(ThID));
			req.setAttribute("top",ex.getTopRes(ThID));
			req.setAttribute("res",ex.getRes(ThID));
			
			RequestDispatcher dis = req.getRequestDispatcher("/res");
			
			dis.forward(req, res);
		}
	}
		
}