package entity;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 服务器状态管理类
 * @author 宁润
 *
 */
public class ServerMgr {
	
	public void runServer(){
		
	}
	
	public void shutdownServer(Integer port){
		KillPortMethod kill=new KillPortMethod(port);
		kill.start();
	}
	
	/**
	 * 获取本机IP地址
	 * @return
	 */
	public String getLocalHost(){
		try {
			InetAddress host=InetAddress.getLocalHost();
			return host.getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	public void editPort(){
		
	}
	public void startSMTP(){
		
	}
	public void startPOP3(){
		
	}

}
