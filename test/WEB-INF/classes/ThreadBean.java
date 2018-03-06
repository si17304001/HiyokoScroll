package Bean;

public class ThreadBean{
	private int No;
	private String ID;
	private String threadName;
	private String threadUser;
	private String threadDate;
	private String Tag;
	
	public int getNo(){
		return No;
	}
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
	public String getTag(){
		return Tag;
	}
	public void setNo(int No){
		this.No = No;
	}
	public void setID(String ID){
		this.ID = ID;
	}
	public void setThreadName(String ThreadName){
		this.threadName=ThreadName;
	}
	public void setUserName(String threadUser){
		this.threadUser=threadUser;
	}
	public void setThreadDate(String date){
		this.threadDate=date;
	}
	public void setTag(String Tag){
		this.Tag = Tag;
	}
}
