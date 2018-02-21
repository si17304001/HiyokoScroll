package Bean;

public class ResBean{
	private String ID;
	private String resContent;
	private String resUser;
	private String resDate;
	private String likeCount;
	
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
	public void setResContent(String resContent){
		this.resContent=resContent;
	}
	public void setResUser(String resUser){
		this.resUser=resUser;
	}
	public void setResDate(String resDate){
		this.resDate=resDate;
	}
	public void setLikePlus(int p){
		
	}
	public void setLikeMinus(int m){
		
	}
}