package aaa;

import java.util.ArrayList;
import java.util.List;

public class ThreadBean{
	private String threadId;
	private String threadTitle;
	private String threadBuildDate;
	//ArrayList�ɂ�ResBean��ۗL����
	
	
	
	//setter
	public String setThreadId(String id){
		threadId = id;
	}
	
	public String setThreadTitle(String tt){
		threadId = tt;
	}
	
	public String setThreadBuildDate(String tbd){
		threadId = tbd;
	}
	
	
	
	//getter
	public String getThreadId(){
		return threadId;
	}
	
	public String getThreadTitle(){
		return threadTitle;
	}
	
	public String getThreadBuildDate(){
		return threadBuildDate;
	}
	
	
}