package aaa;

public class UserBean{
	private String userId;
	private String userName;
	private String userPass;
	
	public void set UserId(String id){
		userId = id;
	}
	
	public void set UserName(String name){
		userName = name;
	}
	
	public void set UserPass(String pass){
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