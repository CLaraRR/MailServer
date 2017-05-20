package entity;


/**
 * 服务器状态类
 * @author 宁润
 *
 */
public class Server {
	public String serverIP;//服务器IP
	public String serverPort;//服务器端口
	public Boolean isServerRun;//服务器是否开启
	public Boolean isSMTPRun;//SMTP服务是否开启
	public Boolean isPOP3Run;//POP3服务是否开启
	
	
	public String getServerIP(){
		return this.serverIP;
	}
	
	public void setServerPort(String port){
		this.serverPort=port;
	}
	public String getServerPort(){
		return this.serverPort;
	}
	
	public void setServerState(Boolean flag){
		this.isServerRun=flag;
	}
	public Boolean isServerRun(){
		return this.isServerRun;
	}
	
	public void setSMTPState(Boolean flag){
		this.isSMTPRun=flag;
	}
	public Boolean isSMTPRun(){
		return this.isSMTPRun;
	}
	
	public void setPOP3State(Boolean flag){
		this.isPOP3Run=flag;
	}
	public Boolean isPOP3Run(){
		return this.isPOP3Run;
	}

}
