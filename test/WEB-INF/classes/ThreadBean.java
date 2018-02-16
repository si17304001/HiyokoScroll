public class ThreadBean{
	private String ID;
	private String threadName;
	private String userName;
	private String threadDate;
	
	public String getID(){
		return ID;
	}
	public String getThreadName(){
		return threadName;
	}
	public String getUserName(){
		return userName;
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
	public void setUserName(String Username){
		this.userName=Username;
	}
	public void setThreadDate(String date){
		this.threadDate=date;
	}
}
