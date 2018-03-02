package DBA;
import Bean.*;
import java.util.ArrayList;


public class Executer{
	public ArrayList<ThreadBean> getThread(){
		DBAccessor dba = new DBAccessor();
		return dba.getThread();
	}
	public ArrayList<ResBean> getRes(String tID){
		DBAccessor dba = new DBAccessor();
		return dba.getRes(tID);
	}
	public void writeThread(String Tname, String user, String tag){
		DBAccessor dba = new DBAccessor();
		if(user == null){
			dba.writeThread(Tname,"–¼–³‚µ‚³‚ñ",tag);
		}else{dba.writeThread(Tname,user,tag);}
	}
	public void writeRes(String rContent, String user, String id){
		DBAccessor dba = new DBAccessor();
		if(user == null){
			dba.writeRes(rContent, "–¼–³‚µ‚³‚ñ", id);
		}else{dba.writeRes(rContent,user,id);}
	}
	public void addAccount(String user, String pass){
		DBAccessor dba = new DBAccessor();
		dba.addAccount(user,pass);
	}
	public String getUser(String uname, String pass){
		DBAccessor dba = new DBAccessor();
		return dba.getUser(uname, pass);
	} 
	public void Like(String rid,String like){
		DBAccessor dba=new DBAccessor();
		dba.setLike(rid,like);
	}
}