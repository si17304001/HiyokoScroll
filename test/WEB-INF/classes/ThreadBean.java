package Bean;

public class ThreadBean{
	private String ID;
	private String threadName;
	private String threadUser;
	private String threadDate;
	
	public String getID(){
		return ID;
	}
	public String getThreadName(){
		return threadName;
	}
	public String getThreadUser(){
		return threadUser;
	}
	public String getThreadDate(){
		return threadDate;
	}
	public void setID(String ID){
		this.ID = ID;
	}
	public void setThreadName(String Threadname){
		this.threadName=Threadname;
	}
	public void setUserName(String threadUser){
		this.threadUser=threadUser;
	}
	public void setThreadDate(String date){
		this.threadDate=date;
	}
}
