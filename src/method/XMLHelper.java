package method;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


/**
 * XML文件解析类
 * @author 宁润
 *
 */
public class XMLHelper {
	public SAXReader saxReader;
	public Document document;
	public Element root;
	public File xmlFile;
	
	
	/**
	 * 构造函数
	 * @param filename
	 */
	public XMLHelper(String filename){
		this.saxReader = new SAXReader();
		this.xmlFile=new File(filename);
		this.root=readXML();
	}
	
	public Element readXML(){
		try {
			this.document = saxReader.read(xmlFile);
			// 获取根元素
	        Element root = this.document.getRootElement();
	        System.out.println("Root: " + root.getName());
	        
	        return root;

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	/**
	 * 读取配置文件中james服务器的端口
	 * @return
	 */
	public int readPort(){
        Element first = root.element("remotemanager");
        Element portElement=first.element("port");
        String port=portElement.getText();
        return Integer.parseInt(port);
	}
	
	
	/**
	 * 读取配置文件中james服务器的DNS地址
	 * @return
	 */
	public List<String> readDNS(){
		Element first = root.element("dnsserver");
        Element serversElement=first.element("servers");
        List<Element> serverList=serversElement.elements("server");
        List<String> dnsList=new ArrayList<String>();
        for(Element each:serverList){
        	dnsList.add(each.getText());
        }

        return dnsList;
		
		
	}
	
	/**
	 * 读取配置文件中SMTP的端口
	 * @return
	 */
	public int readSMTPPort(){
		Element first = root.element("smtpserver");
        Element portElement=first.element("port");
        String port=portElement.getText();
        return Integer.parseInt(port);
	}
	
	
	/**
	 * 读取配置文件中SMTP状态
	 * @return
	 */
	public String readSMTPState(){
		Element first = root.element("smtpserver");
        String attr=first.attributeValue("enabled");
        return attr;
		
	}
	
	/**
	 * 读取配置文件中POP3端口
	 * @return
	 */
	
	public int readPOP3Port(){
		Element first = root.element("pop3server");
        Element portElement=first.element("port");
        String port=portElement.getText();
        return Integer.parseInt(port);
	}
	
	/**
	 * 读取配置文件中POP3状态
	 * @return
	 */
	
	public String readPOP3State(){
		Element first = root.element("pop3server");
        String attr=first.attributeValue("enabled");
        return attr;
        
	}
	
	
	/**
	 * 设置服务器端口号
	 * @param port
	 */
	public void editPort(int port){
		Element first = root.element("remotemanager");
        Element portElement=first.element("port");
//        String port=portElement.getText();
        portElement.setText(String.valueOf(port));
        saveDocument();
		
		
	}
	
	/**
	 * 设置SMTP端口号
	 * @param port
	 */
	
	public void editSMTPPort(int port){
		Element first = root.element("smtpserver");
        Element portElement=first.element("port");
//        String port=portElement.getText();
        portElement.setText(String.valueOf(port));
        saveDocument();
        
	}
	
	/**
	 * 设置SMTP状态
	 * @param state
	 */
	
	public void editSMTPState(Boolean state){
		Element first = root.element("smtpserver");
//        String attr=first.attributeValue("enabled");
        Attribute attr=first.attribute("enabled");
        attr.setData(state);
        saveDocument();
	}
	
	
	/**
	 * 设置POP3端口号
	 * @param port
	 */
	public void editPOP3Port(int port){
		Element first = root.element("pop3server");
        Element portElement=first.element("port");
//        String port=portElement.getText();
        portElement.setText(String.valueOf(port));
        saveDocument();
	}
	
	
	/**
	 * 设置POP3状态
	 * @param state
	 */
	
	public void editPOP3State(Boolean state)
	{
		Element first = root.element("pop3server");
//      String attr=first.attributeValue("enabled");
		Attribute attr=first.attribute("enabled");
		attr.setData(state);
		saveDocument();
	}
	
	
	
	/**
	 * 添加管理员账户
	 * @param username
	 * @param psw
	 */
	public void addAdministrator(String username, String psw) {
		// TODO Auto-generated method stub
		Element first = root.element("remotemanager");
        Element handlerElement=first.element("handler");
//        String port=portElement.getText();
        Element adElement=handlerElement.element("administrator_accounts");
        Element account=adElement.addElement("account");
        account.addAttribute("login", username);
        account.addAttribute("password", psw);
        saveDocument();
		
		
	}
	
	
	public void saveDocument(){
		try {
			FileWriter fw=new FileWriter(xmlFile);
			//Writer osWrite=new OutputStreamWriter(new FileOutputStream(xmlFile));//创建输出流  
			OutputFormat format = OutputFormat.createPrettyPrint();  //获取输出的指定格式    
			format.setEncoding("UTF-8");//设置编码 ，确保解析的xml为UTF-8格式  
			XMLWriter writer = new XMLWriter(fw,format);//XMLWriter 指定输出文件以及格式    
			writer.write(document);
			writer.flush();  
			writer.close(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//把document写入xmlFile指定的文件(可以为被解析的文件或者新创建的文件)    
		
	}
	
	public static void main(String[] args){
		String filename="E:/james-binary-2.3.2.1/james-2.3.2.1/apps/james/SAR-INF/config.xml";
		XMLHelper test=new XMLHelper(filename);
//		int port=test.readPort();
//		System.out.println(port);
//		
//		List<String> dnsList=test.readDNS();
//		System.out.println(dnsList);
		
		String pop3state=test.readPOP3State();
		System.out.println(pop3state);
		
		System.out.println(test.readPOP3Port());
		

		test.editPOP3State(false);
		test.editPOP3Port(1100);
		
		test.editSMTPState(false);
		test.editSMTPPort(250);
		test.editPort(5555);
		
	}



}
