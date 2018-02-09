package aaa;

public class UserBean{
	private String userId;
	private String userName;
	private String userPass;
	
	public void setUserId(String id){
		userId = id;
	}
	
	public void setUserName(String name){
		userName = name;
	}
	
	public void setUserPass(String pass){
		userPass = pass;
	}
	
	public String getUserId(){
		return userId;
	}
	
	public String getUserName(){
		return userName;
	}
	
	public String getUserPass(){
		return userPass;
	}
}