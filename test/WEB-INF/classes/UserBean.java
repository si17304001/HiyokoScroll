package Bean;

public class UserBean{
	private String userID;
	private String userName;
	private String userPass;
	
	public String getUserID(){
		return userID;
	}
	public String getUserName(){
		return userName;
	}
	public String getUserPass(){
		return userPass;
	}
	public void setUserID(String ID){
		this.userID=ID;
	}
	public void setUserName(String userName){
		this.userName=userName;
	}
	public void setUserPass(String userPass){
		this.userPass=userPass;
	}
}