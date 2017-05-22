package method;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * JamesMail测试程序
 */
public class MailSender {

	//邮件服务器， 发信人， 收信人， 邮件主题， 邮件内容
	private String mailServer, from, mailSubject, mailContent;
	private List<String> tolist;
	
	private String username, password;
	
	private Session mailSession;//Session服务
	
	//属性列表对象
	private Properties prop;
	
	private Message message;//发送的邮件消息
	
	//发送邮件调用方法！！
//	public static void main(String[] args) {
//		MailSender mailTest = new MailSender(
//				"root@netpower.com",
//				"ningrun@netpower.com", 
//				"My sisiter!",
//				"Hope You like me!");
//		System.out.println("sending..........");
//		mailTest.send();
//		System.out.println("finished !");
//	}
	
	
	/**
	 * 初始化
	 */
	
	public MailSender(String from,List<String> tolist,String mailSubject,String mailContent) {
		this.from = from;
		this.tolist = tolist;
		this.mailSubject = mailSubject;
		this.mailContent = mailContent;
	}
	
	@SuppressWarnings("finally")
	public int send() {
		//EmailAuthenticator mailauth = new EmailAuthenticator(username, password);
		int result=1;
		//设置邮件服务器
		prop = System.getProperties();
		
		prop.put("mail.transport.protocol", "smtp");
		prop.put("mail.smtp.host", "127.0.0.1");
		//验证发件人用户名和密码
//		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.port", "25");
		
		//产生新的Session服务，通过属性文件来创建与邮件服务器的会话
		//mailSession = Session.getInstance(prop, (Authenticator) mailauth);
		mailSession=Session.getInstance(prop);
		message = new MimeMessage(mailSession);
		try {
			//设置发件人
			message.setFrom(new InternetAddress(from));
			for(int i=0;i<tolist.size();i++){
				String to=tolist.get(i);
				//设置收件人
				message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
				//设置主题
				message.setSubject(mailSubject);
				//设置内容
				message.setContent(mailContent, "text/plain");
				//设置日期
				message.setSentDate(new Date());
				//指定协议发送消息的对象
				Transport tran = mailSession.getTransport("smtp");
				tran.connect(mailServer, username, password);
				Transport.send(message, message.getAllRecipients());
//				tran.send(message, message.getAllRecipients());
				tran.close();
			}
			result=2;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			return result;
		}

		
	}
	
	
	


}

/**
 * 定义自己的认证器类
 */
class EmailAuthenticator extends Authenticator {
	
	private String m_username = null;
	
	private String m_password = null;

	public void setM_username(String m_username) {
		this.m_username = m_username;
	}
	
	public void setM_password(String m_password) {
		this.m_password = m_password;
	}
	
	public EmailAuthenticator(String m_username, String m_password) {
		super();
		setM_username(m_username);
		setM_password(m_password);
	}

	public String getM_username() {
		return m_username;
	}
	public String getM_password() {
		return m_password;
	}
}
