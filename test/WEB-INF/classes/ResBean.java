package Bean;

public class ResBean{
	private int No;
	private String ID;
	private String resContent;
	private String resUser;
	private String resDate;
	private String like;
	private String Good;
	private String Bad;
	
	public int getNo(){
		return No;
	}
	public String getResID(){
		return ID;
	}
	public String getResContent(){
		return resContent;
	}
	public String getResUser(){
		return resUser;
	}
	public String getResDate(){
		return resDate;
	}
	public String getLike(){
		return like;
	}
	public String getGood(){
		return Good;
	}
	public String getBad(){
		return Bad;
	}
	public void setNo(int No){
		this.No=No;
	}
	public void setResID(String ID){
		this.ID=ID;
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
	public void setLike(String likeCount){
		this.like=likeCount;
	}
	public void setGood(String Good){
		this.Good=Good;
	}
	public void setBad(String Bad){
		this.Bad=Bad;
	}
}