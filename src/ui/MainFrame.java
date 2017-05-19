package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.GridLayout;

import javax.swing.JTabbedPane;

import java.awt.Color;

import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField IPtextField;
	private JTextField PorttextField;
	private JMenuBar menuBar;
	private JMenu menuFile;
	private JMenu menuHelp;
	private JTabbedPane tabbedPane;
	private JPanel panelControl;
	private JPanel panelUser;
	private JPanel panelLog;
	private JPanel panelSystem;
	private JLabel lblIp;
	private JLabel lblPort;
	private JLabel lblmailserver;
	private JLabel lblip;
	private JButton refreshButton;
	private JButton startButton;
	private JLabel lblsmtp;
	private JLabel lblsmtpstate;
	private JTextField smtpstateTextField;
	private JButton startSMTPButton;
	private JLabel lblpop;
	private JLabel lblpopstate;
	private JTextField popstateTextField;
	private JButton startPOPButton;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("MailServer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 660);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuFile = new JMenu("文件");
		menuBar.add(menuFile);
		
		JMenuItem menuItem = new JMenuItem("退出");
		menuFile.add(menuItem);
		
		menuHelp = new JMenu("帮助");
		menuBar.add(menuHelp);
		
		JMenuItem menuItem_1 = new JMenuItem("关于邮件服务器");
		menuHelp.add(menuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 874, 29);
		contentPane.add(tabbedPane);
		
		panelControl = new JPanel();
		tabbedPane.addTab("控制面板", null, panelControl, null);
		
		panelUser = new JPanel();
		tabbedPane.addTab("用户管理", null, panelUser, null);
		
		panelLog = new JPanel();
		tabbedPane.addTab("日志管理", null, panelLog, null);
		
		panelSystem = new JPanel();
		tabbedPane.addTab("系统管理", null, panelSystem, null);
		
		/**
		 * IP地址部分
		 */
		lblIp = new JLabel("IP地址");
		lblIp.setBounds(70, 39, 54, 15);
		contentPane.add(lblIp);
		
		lblmailserver = new JLabel("欢迎使用MailServer，版本号v1.0");
		lblmailserver.setBounds(154, 64, 277, 15);
		contentPane.add(lblmailserver);
		
		lblip = new JLabel("服务器当前IP地址:");
		lblip.setBounds(154, 109, 114, 15);
		contentPane.add(lblip);
		
		IPtextField = new JTextField();
		IPtextField.setEditable(false);
		IPtextField.setBackground(UIManager.getColor("Button.background"));
		IPtextField.setBounds(278, 106, 114, 21);
		contentPane.add(IPtextField);
		IPtextField.setColumns(10);
		
		lblPort = new JLabel("服务器当前端口:");
		lblPort.setBounds(154, 160, 114, 15);
		contentPane.add(lblPort);
		
		PorttextField = new JTextField();
		PorttextField.setBounds(278, 157, 114, 21);
		contentPane.add(PorttextField);
		PorttextField.setColumns(10);
		
		refreshButton=new JButton();
		refreshButton.setBounds(469, 106, 93, 21);
		refreshButton.setText("刷新IP");
		contentPane.add(refreshButton);
		
		startButton=new JButton();
		startButton.setBounds(646, 61, 100, 21);
		startButton.setText("启动服务器");
		contentPane.add(startButton);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 223, 864, 2);
		contentPane.add(separator);
		
		/**
		 * SMTP协议部分
		 */
		lblsmtp=new JLabel("SMTP协议");
		lblsmtp.setBounds(64, 253, 60, 15);
		contentPane.add(lblsmtp);
		
		lblsmtpstate=new JLabel("SMTP协议状态:");
		lblsmtpstate.setBounds(154, 313, 114, 15);
		contentPane.add(lblsmtpstate);
		
		smtpstateTextField=new JTextField();
		smtpstateTextField.setEditable(false);
		smtpstateTextField.setBounds(278, 310, 114, 21);
		//smtpstateTextField.setBackground();
		contentPane.add(smtpstateTextField);
		smtpstateTextField.setColumns(10);
		
		startSMTPButton=new JButton();
		startSMTPButton.setBounds(646, 310, 120, 21);
		startSMTPButton.setText("启动SMTP协议");
		contentPane.add(startSMTPButton);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 382, 864, 2);
		contentPane.add(separator_1);
		
		/**
		 * POP3协议
		 */
		lblpop=new JLabel("POP3协议");
		lblpop.setBounds(64, 416, 60, 15);
		contentPane.add(lblpop);
		
		lblpopstate=new JLabel("POP3协议状态:");
		lblpopstate.setBounds(154, 473, 114, 15);
		contentPane.add(lblpopstate);
		
		popstateTextField=new JTextField();
		popstateTextField.setEditable(false);
		popstateTextField.setBounds(278, 470, 114, 21);
		//smtpstateTextField.setBackground();
		contentPane.add(popstateTextField);
		popstateTextField.setColumns(10);
		
		startPOPButton=new JButton();
		startPOPButton.setBounds(646, 470, 120, 21);
		startPOPButton.setText("启动POP3协议");
		contentPane.add(startPOPButton);
		
		JButton button = new JButton("\u786E\u8BA4\u4FEE\u6539\u7AEF\u53E3");
		button.setBounds(469, 156, 114, 23);
		contentPane.add(button);

		
		
	}
}
