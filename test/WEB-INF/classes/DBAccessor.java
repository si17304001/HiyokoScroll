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
		
		String sql="select res_content, res_user, res_date from res where thread_id = "+ThreadID;
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
				//rb.setGood(rs.getString(4));
				//rb.setBad(rs.getString(5));
				
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
	/*public void writeThread(String tname,String user){
		try{
			String sql=
			"insert into thread(thread_id, thread_name) values(thread_seq.nextval,'')";
			getConnection();
			
			Statement st=cc.createStatement();
			st.executeUpdate(sql);
		}
		catch(SQLException e){}
		catch(Exception e){}
	}
	public void writeRes(String rname,String user, int tID){
		try{
			String sql=
			"insert into res(res_id, res_content, res_user) values(res_seq.nextval,'"+rname+"',"+tID+",'"+user+"')";
			
			
			getConnection();
			
			Statement st=cc.createStatement();
			st.executeUpdate(sql);
		}
		catch(SQLException e){}
		catch(Exception e){}
	}*/
	public void addAccount(int id, String uname, String pass){
		try{
			String sql="insert into useraccount values("+id+",'"+uname+"','"+pass+"')";
			
			
			getConnection();
			
			Statement st=cn.createStatement();
			
			st.executeUpdate(sql);
			
		}
		catch(SQLException e){e.printStackTrace();}
		catch(Exception e){e.printStackTrace();}
	}
}