package aaa;

public class ResBean{
	private String resId;
	private String resDate;
	private String resUserName;
	private String resContent;
	//GOOD•]‰¿ABAD•]‰¿‚ğ•Û‚·‚é•Ï”
	private int resGood;
	private int resBad;
	
	
	
	//setter
	public String setResId(String id){
		resId = id;
	}
	
	public String setResDate(String date){
		resDate = date;
	}
	
	public String setResUserName(String run){
		resUserName = run;
	}
	
	public String setContent(String con){
		resContent = con;
	}
	
	public int setResGood(int good){
		resGood = good;
	}
	
	public int setResBad(int bad){
		resBad = bad;
	}
	
	//getter
	public void getResId(){
		return resId;
	}
	
	public void getResDate(){
		return resDate;
	}
	
	public void getResUserName(){
		return resUserName;
	}
	
	public void getResContnt(){
		return resContent;
	}
	
	public void getResGood(){
		return resGood;
	}
	
	public void getResBad(){
		return resBad;
	}
}