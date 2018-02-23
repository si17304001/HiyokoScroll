package Bean;

public class ResBean{
	private int No;
	private String ID;
	private String resContent;
	private String resUser;
	private String resDate;
	private String like;
	
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
}