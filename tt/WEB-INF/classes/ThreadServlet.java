
//Executer他をパッケージ化して(～～.*;)importする必要有
import aaa.*;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThreadServlet extends HttpServlet{

	//書き込み
	pubilc void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		req.setCharacterEncoding("Windows-31J");
		
		//ThreadBeanをインスタンス化
		ThreadBean tb = new ThreadBean();
		//Executerをインスタンス化
		Executer ex1 = new Executer();
		
		//ThreadBeanで値をセット
		tb.setThreadTitle(req.getParameter("Title"));
		
		//作成したいスレタイの入ったtbをaddThreadに送る(この先でデータベースに書き込み)
		ex1.addThread(tb);
		
		//executerのgetThredで名前をthreadとしてセット
		req.setAttribute("thread",ex1.getThread());
		
		//""内にtopページURLを入れてそこにreq,resを転送
		RequestDispatcher dis = req.getRequestDispatcher("top");
		dis forward(req,res);
	
	}
	
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException,IOException{
		req.setCharacterEncoding("Windows-31J");
		
		//Executerをインスタンス化
		Executer ex2 ＝ new Executer();
		
		
		//名前をthreadとしてexecuterからgetexecuteでセット
		req.setAttribute("thread",ex2.getThread());
		//""内にtopページURLを入れてそこにreq,resを転送
		RequestDispatcher dis = req.getRequestDispatcher("top");
  		dis.forward(req, res);
		


}