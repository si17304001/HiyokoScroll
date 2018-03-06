package DBA;
import Bean.*;
import java.util.ArrayList;


public class Executer{
	private DBAccessor dba=new DBAccessor();
	public ArrayList<ThreadBean> getThread(){
		dba.createConnection();
		return dba.getThread();
	}
	public ArrayList<ResBean> getRes(String threadID){
		dba.createConnection();
		return dba.getRes(threadID);
	}
	public String getThreadName(String threadID){
		dba.createConnection();
		return dba.getThreadName(threadID);
	}
	public void writeThread(String threadName, String user, String tag){
		dba.createConnection();
		if(user == null){
			dba.writeThread(threadName,"–¼–³‚µ‚³‚ñ",tag);
		}else{dba.writeThread(threadName,user,tag);}
	}
	public void writeRes(String resContent, String user, String ID){
		dba.createConnection();
		if(user == null){
			dba.writeRes(resContent, "–¼–³‚µ‚³‚ñ", ID);
		}else{dba.writeRes(resContent,user,ID);}
	}
	public boolean addAccount(String user, String pass){
		dba.createConnection();
		return dba.addAccount(user,pass);
	}
	public String getUser(String name, String pass){
		dba.createConnection();
		return dba.getUser(name, pass);
	} 
	public void Like(String resID,String like){
		dba.createConnection();
		dba.setLike(resID,like);
	}
	public ArrayList<ResBean> getTopRes(String threadID){
		dba.createConnection();
		return dba.getTopRes(threadID);
	}
}