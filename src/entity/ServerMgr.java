package entity;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import method.KillPortMethod;
import method.XMLHelper;

/**
 * 服务器状态管理类
 * @author 宁润
 *
 */
public class ServerMgr {
	
	public Server server;
	private XMLHelper xmlHelper;
	
	
	
	public ServerMgr(String configFile){
		server=Server.getInstance();
		xmlHelper=new XMLHelper(configFile);
	}
	
	/**
	 * 启动服务器
	 */
	public void runServer(){
		try {
			String cmd="cmd /c start E://james-binary-2.3.2.1//james-2.3.2.1//bin//run.bat";
			Process p;
			p = Runtime.getRuntime().exec(cmd);

			try {
				Thread.sleep(6000);
				if(getServerState()){
					server.setServerState(true);
				}else{
					server.setServerState(false);
					System.out.println("run server error!");
					return ;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 关闭服务器
	 * @return
	 */
	public Boolean shutdownServer(){
		KillPortMethod kill=new KillPortMethod(server.getServerPort());
		if(kill.haveProcess(server.getServerPort())){
			kill.start();
			server.setServerState(false);
			return true;
		}else{
			System.out.println("服务器已在外部关闭！");
			server.setServerState(false);
			return false;
		}
		
		
	}
	
	public void restartServer(){
		shutdownServer();
		runServer();

	}
	
	/**
	 * 获取本机IP地址
	 * @return
	 */
	public String getLocalHost(){
		try {
			InetAddress host=InetAddress.getLocalHost();
			server.setServerIP(host.getHostAddress());
			return host.getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	public int getPortNum(){
		int port=xmlHelper.readPort();
		server.setServerPort(port);
		return port;
		
	}
	public void editPort(int port){
		xmlHelper.editPort(port);
		server.setServerPort(port);
		
	}
	public void setSMTPState(Boolean state){
		xmlHelper.editSMTPState(state);
		server.setSMTPState(state);
		
	}
	public void setPOP3State(Boolean state){
		xmlHelper.editPOP3State(state);
		server.setPOP3State(state);
		
	}
	public Boolean getServerState(){
		System.out.println("&&&"+server.getServerPort());
		KillPortMethod test=new KillPortMethod(server.getServerPort());
		Boolean flag=test.haveProcess(server.getServerPort());
	
		server.setServerState(flag);
		return flag;
	}

	public Boolean getSMTPState() {
		// TODO Auto-generated method stub
		String state=xmlHelper.readSMTPState();
		if(state.equals("true")){
			server.setSMTPState(true);
			return true;
		}else{
			server.setSMTPState(false);
			return false;
		}
			
		
	}

	public Boolean getPOP3State() {
		// TODO Auto-generated method stub
		String state=xmlHelper.readPOP3State();
		if(state.equals("true")){
			server.setPOP3State(true);
			return true;
		}else{
			server.setPOP3State(false);
			return false;
		}
			
	}
	

}
