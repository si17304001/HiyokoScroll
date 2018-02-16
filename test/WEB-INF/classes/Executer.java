import java.util.ArrayList;

public class Executer{
	public ArrayList<ThreadBean> getThread(){
		DBAccessor dba = new DBAccessor();
		dba.getThread();
	}
	public void addAccount(String user, String pass){
		DBAccessor dba = new DBAccessor();
		dba.addAccount(user,pass);
	}
}