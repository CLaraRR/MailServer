package entity;

public class User {
	public String username;
	public String psw;
	public int usertype;
	
	
	public User(String username,String psw){
		this.username=username;
		this.psw=psw;
	}
	public User(String username,String psw,int type){
		this.username=username;
		this.psw=psw;
		this.usertype=type;
	}
	
	public void setUsername(String username){
		this.username=username;
		
	}
	public void setPsw(String psw){
		this.psw=psw;
	}

	public void setUsertype(int type){
		this.usertype=type;
	}
	
	public String getUsername(){
		return this.username;
	}
	public String getPsw(){
		return this.psw;
	}
	
	public int getUsertype(){
		return this.usertype;
	}
}
