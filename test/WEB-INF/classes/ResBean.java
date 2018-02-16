public class ResBean{
	private String ID;
	private String resContent;
	private String resUser;
	private String resDate;
	private String Good;
	private String Bad;
	
	public String getResName(){
		return resContent;
	}
	public String getResUser(){
		return resUser;
	}
	public String getResDate(){
		return resDate;
	}
	public String getGood(){
		return Good;
	}
	public String getBad(){
		return Bad;
	}
	public void setResContent(String resContent){
		this.resContent=resContent;
	}
	public void setResUser(String resUser){
		this.resUser=resUser;
	}
	public void setResDate(String resDate){
		this.resDate=resDate;
	}
	public void setGood(String Good){
		this.Good=Good;
	}
	public void setBad(String Bad){
		this.Bad=Bad;
	}
}