package entity;


/**
 * ������״̬��
 * @author ����
 *
 */
public class Server {
	public String serverIP;//������IP
	public String serverPort;//�������˿�
	public Boolean isServerRun;//�������Ƿ���
	public Boolean isSMTPRun;//SMTP�����Ƿ���
	public Boolean isPOP3Run;//POP3�����Ƿ���
	
	
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
