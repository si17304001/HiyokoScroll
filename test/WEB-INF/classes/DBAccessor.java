package DBA;
import Bean.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import java.util.ArrayList;



//select ResultSet rs=st.executeQuery
//insert st.executeUpdate

public class DBAccessor{
	private Connection cn;
	
	public void createConnection(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn=DriverManager.getConnection
	 	 	 ("jdbc:oracle:thin:@localhost:1521:orcl","info","pro");
			System.out.println("DBConected");
			cn.setAutoCommit(false);
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
      	e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public Connection getConnection(){
		if(this.cn == null){
			createConnection();
			
		}
		return this.cn;
	}
	public ArrayList<ThreadBean> getThread(){
		
		ArrayList<ThreadBean> thList=new ArrayList<>();
		
		String sql="select thread_id, thread_name, thread_user, thread_date, tag from thread order by thread_date desc";
		
		try{
			
			getConnection();
			
			Statement st=cn.createStatement();
			
			ResultSet rs=st.executeQuery(sql);
			
			for(int i = 1; rs.next(); i++){
				System.out.println("thread rs.next()==true");
				ThreadBean tb=new ThreadBean();
				System.out.println(rs.getString(1));
				tb.setNo(i);
				tb.setID(rs.getString(1));
				tb.setThreadName(rs.getString(2));
				tb.setUserName(rs.getString(3));
				tb.setThreadDate(rs.getString(4));
				tb.setTag(rs.getString(5));
				thList.add(tb);
			}
			cn.commit();
			
			st.close();
			
			cn.close();
		}
		catch(SQLException e){e.printStackTrace();}
		catch(Exception e){e.printStackTrace();}
		
		return thList;
	}
	public ArrayList<ResBean> getRes(String ThreadID){
		
		ArrayList<ResBean> resList=new ArrayList<>();
		
		String sql="select res_id, res_content, res_user, res_date, res_like from res where thread_id = "+ThreadID+" order by res_date asc";
		try{
			
			getConnection();
			
			Statement st=cn.createStatement();
			
			ResultSet rs=st.executeQuery(sql);
			
			for(int i = 1; rs.next(); i++){
				System.out.println("res rs.next()=true");
				ResBean rb=new ResBean();
				
				rb.setNo(i);
				rb.setResID(rs.getString(1));
				rb.setResContent(rs.getString(2));
				rb.setResUser(rs.getString(3));
				rb.setResDate(rs.getString(4));
				rb.setLike(rs.getString(5));
				
				resList.add(rb);
			}
			cn.commit();
			
			st.close();
			
			cn.close();
		}
		catch(SQLException e){e.printStackTrace();}
		catch(Exception e){e.printStackTrace();}
			
		return resList;
	}
	public void writeThread(String threadName,String user,String tag){
		
		String sql=
			"insert into thread(thread_id, thread_name, thread_user, tag) values(thread_id_seq.nextval,'"+threadName+"', '"+user+"', '"+tag+"')";
		
		try{
			
			getConnection();
			
			Statement st=cn.createStatement();
			st.executeUpdate(sql);
			System.out.println("updated");
			
			cn.commit();
			
			st.close();
			
			cn.close();
			
		}
		catch(SQLException e){e.printStackTrace();}
		catch(Exception e){e.printStackTrace();}
	}
	public void writeRes(String resContent,String user, String threadID){//<--------------
		try{
			String sql=
			"insert into res(res_id, res_content, thread_id, res_user) values(res_id_seq.nextval, '"+resContent+"', "+threadID+", '"+user+"')";
			
			getConnection();
			
			Statement st=cn.createStatement();
			st.executeUpdate(sql);
			
			cn.commit();
			
			st.close();
			
			cn.close();
			
		}
		catch(SQLException e){e.printStackTrace();}
		catch(Exception e){e.printStackTrace();}
	}
	
	//User

	public String getUser(String name, String pass){
		
		String sql="select user_name from useraccount where user_name = '"+name+"' and user_pass = '"+pass+"'";
		
		UserBean ub=new UserBean();
		try{
			getConnection();

			Statement st=cn.createStatement();

			ResultSet rs=st.executeQuery(sql);
			
			try{
				rs.next();
				System.out.println(rs.getString("user_name"));
				ub.setUserName(rs.getString(1));
			}catch(SQLException e){e.printStackTrace(); return "";}
				catch(Exception e){e.printStackTrace();}
			
			cn.commit();
			
			st.close();
			
			cn.close();
			
		}catch(SQLException e){e.printStackTrace();}
		catch(Exception e){e.printStackTrace();}
		
		return ub.getUserName();
	}
	public boolean addAccount(String name, String pass){
		
		String sql="insert into useraccount values(user_id_seq.nextval, '"+name+"','"+pass+"')";
		try{

			getConnection();
			
			Statement st=cn.createStatement();
			
			st.executeUpdate(sql);

			cn.commit();
			
			st.close();
			
			cn.close();
		}
		catch(SQLException e){e.printStackTrace();
			return false;}
		catch(Exception e){e.printStackTrace();}
		return true;
	}

	public void setLike(String resID, String like){
		String sql = null;
		if(like.equals("Good")){
			sql="update res set res_like = res_like + 1 where res_id = "+resID;
		}else{
			sql="update res set res_like = res_like - 1 where res_id = "+resID;
		}
		System.out.println(like);
		try{
		getConnection();

		Statement st=cn.createStatement();

		st.executeUpdate(sql);

		cn.commit();
			
		st.close();
			
		cn.close();

		}catch(SQLException e){e.printStackTrace();}
		catch(Exception e){e.printStackTrace();}
	}
	public String getThreadName(String threadID){
		
		String sql="select thread_name from thread where thread_id = "+threadID;
		String threadname = null;
		try{
			getConnection();
			
			Statement st=cn.createStatement();
			
			ResultSet rs=st.executeQuery(sql);
			
			rs.next();
			
			threadname = rs.getString(1);
			
			cn.commit();
			
			st.close();
			
			cn.close();
		}catch(SQLException e){e.printStackTrace();}
		catch(Exception e){e.printStackTrace();}
		
		return threadname;
	}
	public ArrayList<ResBean> getTopRes(String threadID){
		
		ArrayList<ResBean> top=new ArrayList<>();
		
		String sql = "select res_content, res_user, res_date, res_like, res_id from res where thread_id = "+threadID+" and res_like = (select max(res_like) from res)";
		
		try{
			
			getConnection();
			
			Statement st=cn.createStatement();
			
			ResultSet rs=st.executeQuery(sql);
			
			for(int i = 1; rs.next(); i++){
				System.out.println("resTop rs.next()=true");
				ResBean rb = new ResBean();
				
				rb.setResContent(rs.getString(1));
				rb.setResUser(rs.getString(2));
				rb.setResDate(rs.getString(3));
				rb.setLike(rs.getString(4));
				rb.setResID(rs.getString(5));
			
				top.add(rb);
			}
			
			cn.commit();
			
			st.close();
			
			cn.close();
		}
		catch(SQLException e){e.printStackTrace();}
		catch(Exception e){e.printStackTrace();}
			
		return top;
	}

}