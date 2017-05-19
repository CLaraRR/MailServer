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
		
		menuFile = new JMenu("�ļ�");
		menuBar.add(menuFile);
		
		JMenuItem menuItem = new JMenuItem("�˳�");
		menuFile.add(menuItem);
		
		menuHelp = new JMenu("����");
		menuBar.add(menuHelp);
		
		JMenuItem menuItem_1 = new JMenuItem("�����ʼ�������");
		menuHelp.add(menuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 874, 29);
		contentPane.add(tabbedPane);
		
		panelControl = new JPanel();
		tabbedPane.addTab("�������", null, panelControl, null);
		
		panelUser = new JPanel();
		tabbedPane.addTab("�û�����", null, panelUser, null);
		
		panelLog = new JPanel();
		tabbedPane.addTab("��־����", null, panelLog, null);
		
		panelSystem = new JPanel();
		tabbedPane.addTab("ϵͳ����", null, panelSystem, null);
		
		/**
		 * IP��ַ����
		 */
		lblIp = new JLabel("IP��ַ");
		lblIp.setBounds(24, 39, 54, 15);
		contentPane.add(lblIp);
		
		lblmailserver = new JLabel("��ӭʹ��MailServer���汾��1.0");
		lblmailserver.setBounds(64, 64, 277, 15);
		contentPane.add(lblmailserver);
		
		lblip = new JLabel("��������ǰIP��ַ");
		lblip.setBounds(64, 109, 114, 15);
		contentPane.add(lblip);
		
		IPtextField = new JTextField();
		IPtextField.setBounds(176, 106, 93, 21);
		contentPane.add(IPtextField);
		IPtextField.setColumns(10);
		
		lblPort = new JLabel("��������ǰ�˿�");
		lblPort.setBounds(300, 109, 114, 15);
		contentPane.add(lblPort);
		
		PorttextField = new JTextField();
		PorttextField.setBounds(420, 106, 93, 21);
		contentPane.add(PorttextField);
		PorttextField.setColumns(10);
		
		refreshButton=new JButton();
		refreshButton.setBounds(600, 106, 93, 21);
		refreshButton.setText("ˢ��IP");
		contentPane.add(refreshButton);
		
		startButton=new JButton();
		startButton.setBounds(700, 106, 100, 21);
		startButton.setText("����������");
		contentPane.add(startButton);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 155, 864, 2);
		contentPane.add(separator);
		
		/**
		 * SMTPЭ�鲿��
		 */
		lblsmtp=new JLabel("SMTPЭ��");
		lblsmtp.setBounds(24, 160, 60, 15);
		contentPane.add(lblsmtp);
		
		lblsmtpstate=new JLabel("SMTPЭ��״̬");
		lblsmtpstate.setBounds(64, 184, 114, 15);
		contentPane.add(lblsmtpstate);
		
		smtpstateTextField=new JTextField();
		smtpstateTextField.setBounds(176, 184, 93, 21);
		//smtpstateTextField.setBackground();
		contentPane.add(smtpstateTextField);
		smtpstateTextField.setColumns(10);
		
		startSMTPButton=new JButton();
		startSMTPButton.setBounds(300, 184, 120, 21);
		startSMTPButton.setText("����SMTPЭ��");
		contentPane.add(startSMTPButton);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 250, 864, 2);
		contentPane.add(separator_1);
		
		/**
		 * POP3Э��
		 */
		lblpop=new JLabel("POP3Э��");
		lblpop.setBounds(24, 300, 60, 15);
		contentPane.add(lblpop);
		
		lblpopstate=new JLabel("POP3Э��״̬");
		lblpopstate.setBounds(64, 324, 114, 15);
		contentPane.add(lblpopstate);
		
		popstateTextField=new JTextField();
		popstateTextField.setBounds(176, 324, 93, 21);
		//smtpstateTextField.setBackground();
		contentPane.add(popstateTextField);
		popstateTextField.setColumns(10);
		
		startPOPButton=new JButton();
		startPOPButton.setBounds(300, 324, 120, 21);
		startPOPButton.setText("����POP3Э��");
		contentPane.add(startPOPButton);

		
		
	}
}
