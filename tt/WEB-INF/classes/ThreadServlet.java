
//Executer�����p�b�P�[�W������(�`�`.*;)import����K�v�L
import aaa.*;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThreadServlet extends HttpServlet{

	//��������
	pubilc void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		req.setCharacterEncoding("Windows-31J");
		
		//ThreadBean���C���X�^���X��
		ThreadBean tb = new ThreadBean();
		//Executer���C���X�^���X��
		Executer ex1 = new Executer();
		
		//ThreadBean�Œl���Z�b�g
		tb.setThreadTitle(req.getParameter("Title"));
		
		//�쐬�������X���^�C�̓�����tb��addThread�ɑ���(���̐�Ńf�[�^�x�[�X�ɏ�������)
		ex1.addThread(tb);
		
		//executer��getThred�Ŗ��O��thread�Ƃ��ăZ�b�g
		req.setAttribute("thread",ex1.getThread());
		
		//""����top�y�[�WURL�����Ă�����req,res��]��
		RequestDispatcher dis = req.getRequestDispatcher("top");
		dis forward(req,res);
	
	}
	
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException,IOException{
		req.setCharacterEncoding("Windows-31J");
		
		//Executer���C���X�^���X��
		Executer ex2 �� new Executer();
		
		
		//���O��thread�Ƃ���executer����getexecute�ŃZ�b�g
		req.setAttribute("thread",ex2.getThread());
		//""����top�y�[�WURL�����Ă�����req,res��]��
		RequestDispatcher dis = req.getRequestDispatcher("top");
  		dis.forward(req, res);
		


}