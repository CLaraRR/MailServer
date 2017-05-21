package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import entity.Server;
import entity.ServerMgr;
import method.XMLHelper;


public class ControlPanel implements ActionListener{
	private JPanel detailPanel;
	private JTextField IPtextField;
	private JTextField PorttextField;
	private JButton startButton;
	private JTextField smtpstateTextField;
	private JButton startSMTPButton;
	private JTextField pop3stateTextField;
	private JButton startPOP3Button;
	private ServerMgr serverMgr;

	private String configFile;
	
	public ControlPanel(MainFrame mFrame){
		detailPanel=mFrame.getDetatilPanel();
		configFile="E:/james-binary-2.3.2.1/james-2.3.2.1/apps/james/SAR-INF/config.xml";
		serverMgr=new ServerMgr(configFile);

	}


	public void setDetailPanel(JPanel panel){
		panel.removeAll();
		panel.setLayout(null);
		/**
		 * IP地址部分
		 */
		JLabel lblIp = new JLabel("IP地址");
		lblIp.setBounds(70, 39, 54, 15);
		panel.add(lblIp);
		
		JLabel lblmailserver = new JLabel("欢迎使用MailServer，版本号v1.0");
		lblmailserver.setBounds(154, 64, 277, 15);
		panel.add(lblmailserver);
		
		JLabel lblip = new JLabel("服务器当前IP地址:");
		lblip.setBounds(154, 109, 114, 15);
		panel.add(lblip);
		
		IPtextField = new JTextField();
		IPtextField.setEditable(false);
		IPtextField.setBorder(null);
		IPtextField.setBounds(278, 106, 114, 21);
		panel.add(IPtextField);
		IPtextField.setColumns(10);
		
		JLabel lblPort = new JLabel("服务器当前端口:");
		lblPort.setBounds(154, 160, 114, 15);
		panel.add(lblPort);
		
		PorttextField = new JTextField();
		PorttextField.setBounds(278, 157, 114, 21);
		panel.add(PorttextField);
		PorttextField.setColumns(10);
		
		JButton refreshButton=new JButton();
		refreshButton.setBounds(469, 106, 93, 21);
		refreshButton.setText("刷新IP");
		refreshButton.setActionCommand("refresh");
		refreshButton.addActionListener(this);
		panel.add(refreshButton);
		
		JButton button = new JButton("确定修改端口");
		button.setBounds(469, 156, 114, 23);
		button.setActionCommand("edit");
		button.addActionListener(this);
		panel.add(button);
		
		startButton=new JButton();
		startButton.setBounds(646, 61, 100, 21);
		//startButton.setText("运行服务器");
		startButton.setActionCommand("run");
		startButton.addActionListener(this);
		panel.add(startButton);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 223, 864, 2);
		panel.add(separator);
		
		/**
		 * SMTP协议部分
		 */
		JLabel lblsmtp=new JLabel("SMTP协议");
		lblsmtp.setBounds(64, 253, 60, 15);
		panel.add(lblsmtp);
		
		JLabel lblsmtpstate=new JLabel("SMTP协议状态:");
		lblsmtpstate.setBounds(154, 313, 114, 15);
		panel.add(lblsmtpstate);
		
		smtpstateTextField=new JTextField();
		smtpstateTextField.setEditable(false);
		smtpstateTextField.setBorder(null);
		smtpstateTextField.setBounds(278, 310, 114, 21);
		//smtpstateTextField.setBackground();
		panel.add(smtpstateTextField);
		smtpstateTextField.setColumns(10);
		
		startSMTPButton=new JButton();
		startSMTPButton.setBounds(646, 310, 120, 21);
//		startSMTPButton.setText("启动SMTP协议");
		startSMTPButton.setActionCommand("startSMTP");
		startSMTPButton.addActionListener(this);
		panel.add(startSMTPButton);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 382, 864, 2);
		panel.add(separator_1);
		
		/**
		 * POP3协议
		 */
		JLabel lblpop=new JLabel("POP3协议");
		lblpop.setBounds(64, 416, 60, 15);
		panel.add(lblpop);
		
		JLabel lblpopstate=new JLabel("POP3协议状态:");
		lblpopstate.setBounds(154, 473, 114, 15);
		panel.add(lblpopstate);
		
		pop3stateTextField=new JTextField();
		pop3stateTextField.setEditable(false);
		pop3stateTextField.setBorder(null);
		pop3stateTextField.setBounds(278, 470, 114, 21);
		//smtpstateTextField.setBackground();
		panel.add(pop3stateTextField);
		pop3stateTextField.setColumns(10);
		
		startPOP3Button=new JButton();
		startPOP3Button.setBounds(646, 470, 120, 21);
		//startPOPButton.setText("启动POP3协议");
		startPOP3Button.setActionCommand("startPOP3");
		startPOP3Button.addActionListener(this);
		panel.add(startPOP3Button);
		
		
		initState();

	}

	private void initState() {
		// TODO Auto-generated method stub
		/**
		 * 初始化本机IP地址
		 */
		String host=serverMgr.getLocalHost();//获取本机IP地址
		IPtextField.setText(host);
		
		/**
		 * 初始化服务器端口号
		 */
		int port=serverMgr.getPortNum();
		PorttextField.setText(String.valueOf(port));
		
		/**
		 * 初始化运行服务器按钮状态
		 */
		Boolean serverstate=serverMgr.getServerState();
		if(serverstate){
			startButton.setText("关闭服务器");
		}else{
			startButton.setText("运行服务器");
			smtpstateTextField.setText("协议已停止");
			startSMTPButton.setText("启动SMTP协议");
			pop3stateTextField.setText("协议已停止");
			startPOP3Button.setText("启动POP3协议");
		}

		setProtocolState();
		
	}


	
	public void setProtocolState(){

		Boolean serverstate=serverMgr.getServerState();
		System.out.println(serverstate);
		/**
		 * 初始化SMTP协议状态
		 */
		Boolean smtpstate=serverMgr.getSMTPState();
		if(smtpstate&&serverstate){
			smtpstateTextField.setText("协议已开启");
			startSMTPButton.setText("关闭SMTP协议");
		}else{
			smtpstateTextField.setText("协议已停止");
			startSMTPButton.setText("启动SMTP协议");
		}

		
		/**
		 * 初始化POP3协议状态
		 */
		Boolean pop3state=serverMgr.getPOP3State();
		if(pop3state&&serverstate){
			pop3stateTextField.setText("协议已开启");
			startPOP3Button.setText("关闭POP3协议");
		}else{
			pop3stateTextField.setText("协议已停止");
			startPOP3Button.setText("启动POP3协议");
		}
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String event=e.getActionCommand();
		switch(event){
		case "refresh":
			String host=serverMgr.getLocalHost();//获取本机IP地址
			IPtextField.setText(host);
			break;
			
		case "run":
			if(startButton.getText().equals("运行服务器")){
				serverMgr.runServer();
				startButton.setText("关闭服务器");
				setProtocolState();
				
			}else if(startButton.getText().equals("关闭服务器")){
				int port=Integer.parseInt(PorttextField.getText());
				Boolean flag=serverMgr.shutdownServer();
				if(flag){
					startButton.setText("运行服务器");
					setProtocolState();
				}else{
					JOptionPane.showMessageDialog(detailPanel, "服务器已在外部关闭！", "消息",JOptionPane.WARNING_MESSAGE);  
					startButton.setText("运行服务器");
					setProtocolState();	
				}
				
			}
			break;
		case "edit":
			String newport=PorttextField.getText();
			
			if(startButton.getText().equals("关闭服务器")){
				int n = JOptionPane.showConfirmDialog(null, "重启服务器后生效", "消息",JOptionPane.YES_NO_OPTION);
				if(n==0){
					serverMgr.shutdownServer();
					serverMgr.editPort(Integer.parseInt(newport));
					serverMgr.runServer();
				}
			}
			break;
		case "startSMTP":
			if(startSMTPButton.getText().equals("启动SMTP协议")){
				if(startButton.getText().equals("关闭服务器")){
					int n = JOptionPane.showConfirmDialog(null, "重启服务器后生效", "消息",JOptionPane.YES_NO_OPTION);
					if(n==0){
						serverMgr.restartServer();
						serverMgr.setSMTPState(true);
						startSMTPButton.setText("关闭SMTP协议");
						smtpstateTextField.setText("协议已开启");
					}
				}else{
					serverMgr.setSMTPState(true);
					startSMTPButton.setText("关闭SMTP协议");
					smtpstateTextField.setText("协议已开启");
				}
				
			}else{
				if(startButton.getText().equals("关闭服务器")){
					int n = JOptionPane.showConfirmDialog(null, "重启服务器后生效", "消息",JOptionPane.YES_NO_OPTION);
					if(n==0){
						serverMgr.restartServer();
						serverMgr.setSMTPState(false);
						startSMTPButton.setText("启动SMTP协议");
						smtpstateTextField.setText("协议已停止");
					}
				}else{
					serverMgr.setSMTPState(false);
					startSMTPButton.setText("启动SMTP协议");
					smtpstateTextField.setText("协议已停止");
				}
				
			}
			
			
			break;
		case "startPOP3":
			if(startPOP3Button.getText().equals("启动POP3协议")){
				if(startButton.getText().equals("关闭服务器")){
					int n = JOptionPane.showConfirmDialog(null, "重启服务器后生效", "消息",JOptionPane.YES_NO_OPTION);
					if(n==0){
						serverMgr.restartServer();
						serverMgr.setPOP3State(true);
						startPOP3Button.setText("关闭POP3协议");
						pop3stateTextField.setText("协议已开启");
					}
				}else{
					serverMgr.setPOP3State(true);
					startPOP3Button.setText("关闭POP3协议");
					pop3stateTextField.setText("协议已开启");
				}
				
			}else{
				if(startButton.getText().equals("关闭服务器")){
					int n = JOptionPane.showConfirmDialog(null, "重启服务器后生效", "消息",JOptionPane.YES_NO_OPTION);
					if(n==0){
						serverMgr.restartServer();
						serverMgr.setPOP3State(false);
						startPOP3Button.setText("启动POP3协议");
						pop3stateTextField.setText("协议已停止");
					}
				}else{
					serverMgr.setPOP3State(false);
					startPOP3Button.setText("启动POP3协议");
					pop3stateTextField.setText("协议已停止");
				}
				
			}
			break;
			
		}
		
	}






}
