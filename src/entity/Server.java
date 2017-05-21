package entity;


/**
 * 服务器状态类
 * @author 宁润
 *
 */
public class Server {
	public String serverIP;//服务器IP
	public int serverPort;//服务器端口
	public Boolean isServerRun;//服务器是否开启
	public Boolean isSMTPRun;//SMTP服务是否开启
	public Boolean isPOP3Run;//POP3服务是否开启
	
	private static Server server;
	
	public static Server getInstance(){
		if(server==null){
			return new Server();
		}else{
			return server;
		}
		
	}
	
	
	public Server(){
		
	}
	public Server(String ip,int port,Boolean isServerRun,Boolean isSMTPRun,Boolean isPOP3Run){

		this.serverIP=ip;
		this.serverPort=port;
		this.isServerRun=isServerRun;
		this.isSMTPRun=isSMTPRun;
		this.isPOP3Run=isPOP3Run;
		
	}
	public void setServerIP(String ip){
		this.serverIP=ip;
	}
	public String getServerIP(){
		return this.serverIP;
	}
	
	public void setServerPort(int port){
		this.serverPort=port;
	}
	public int getServerPort(){
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
