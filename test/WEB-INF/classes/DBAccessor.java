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
		
		String sql="select * from thread order by thread_date desc";
		
		try{
			
			getConnection();
			
			Statement st=cn.createStatement();
			
			ResultSet rs=st.executeQuery(sql);
			
			while(rs.next()){
				System.out.println("rs.next()==true");
				ThreadBean tb=new ThreadBean();
				System.out.println(rs.getString(1));
				tb.setID(rs.getString(1));
				tb.setThreadName(rs.getString(2));
				tb.setUserName(rs.getString(3));
				tb.setThreadDate(rs.getString(4));
				System.out.println("seted");
				thList.add(tb);
				System.out.println("addtolist");
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
		
		String sql="select res_content, res_user, res_date, res_like from res where thread_id = "+ThreadID;
		try{
			
			getConnection();
			
			Statement st=cn.createStatement();
			
			ResultSet rs=st.executeQuery(sql);
			
			while(rs.next()){
				System.out.println("rs.next()=true");
				ResBean rb=new ResBean();
				System.out.println(rs.getString("res_content"));
				rb.setResContent(rs.getString("res_content"));
				rb.setResUser(rs.getString(2));
				rb.setResDate(rs.getString(3));
				rb.setLike(rs.getString(4));
				
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
	public void writeThread(String tname,String user){
		
		String sql=
			"insert into thread(thread_id, thread_name, thread_user) values(thread_id_seq.nextval,'"+tname+"', '"+user+"')";
		
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
	public void writeRes(String rcontent,String user, String tID){//<--------------
		try{
			String sql=
			"insert into res(res_id, res_content, thread_id, res_user) values(res_id_seq.nextval, '"+rcontent+"', "+tID+", '"+user+"')";
			
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
			}catch(SQLException e){e.printStackTrace();}
				catch(Exception e){e.printStackTrace();}
			
			cn.commit();
			
			st.close();
			
			cn.close();
			
		}catch(SQLException e){e.printStackTrace();}
		catch(Exception e){e.printStackTrace();}
		
		return ub.getUserName();
	}
	public void addAccount(String uname, String pass){
		
		String sql="insert into useraccount values(user_id_seq.nextval, '"+uname+"','"+pass+"')";
		try{

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
	
}