package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import entity.ServerMgr;




public class ControlPanel implements ActionListener{
	private JPanel detailPanel;
	private JTextField IPtextField;
	private JTextField PorttextField;
	private JButton startButton;
	private ServerMgr serverMgr;
	
	public ControlPanel(MainFrame mFrame){
		detailPanel=mFrame.getDetatilPanel();
		serverMgr=new ServerMgr();
	}


	public void setDetailPanel(JPanel panel){
		panel.removeAll();
		panel.setLayout(null);
		/**
		 * IP��ַ����
		 */
		JLabel lblIp = new JLabel("IP��ַ");
		lblIp.setBounds(70, 39, 54, 15);
		panel.add(lblIp);
		
		JLabel lblmailserver = new JLabel("��ӭʹ��MailServer���汾��v1.0");
		lblmailserver.setBounds(154, 64, 277, 15);
		panel.add(lblmailserver);
		
		JLabel lblip = new JLabel("��������ǰIP��ַ:");
		lblip.setBounds(154, 109, 114, 15);
		panel.add(lblip);
		
		IPtextField = new JTextField();
		IPtextField.setEditable(false);
		IPtextField.setBorder(null);
		IPtextField.setBounds(278, 106, 114, 21);
		panel.add(IPtextField);
		IPtextField.setColumns(10);
		
		JLabel lblPort = new JLabel("��������ǰ�˿�:");
		lblPort.setBounds(154, 160, 114, 15);
		panel.add(lblPort);
		
		PorttextField = new JTextField();
		PorttextField.setBounds(278, 157, 114, 21);
		panel.add(PorttextField);
		PorttextField.setColumns(10);
		
		JButton refreshButton=new JButton();
		refreshButton.setBounds(469, 106, 93, 21);
		refreshButton.setText("ˢ��IP");
		refreshButton.setActionCommand("refresh");
		refreshButton.addActionListener(this);
		panel.add(refreshButton);
		
		JButton button = new JButton("ȷ���޸Ķ˿�");
		button.setBounds(469, 156, 114, 23);
		button.setActionCommand("edit");
		button.addActionListener(this);
		panel.add(button);
		
		startButton=new JButton();
		startButton.setBounds(646, 61, 100, 21);
		startButton.setText("����������");
		startButton.setActionCommand("run");
		startButton.addActionListener(this);
		panel.add(startButton);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 223, 864, 2);
		panel.add(separator);
		
		/**
		 * SMTPЭ�鲿��
		 */
		JLabel lblsmtp=new JLabel("SMTPЭ��");
		lblsmtp.setBounds(64, 253, 60, 15);
		panel.add(lblsmtp);
		
		JLabel lblsmtpstate=new JLabel("SMTPЭ��״̬:");
		lblsmtpstate.setBounds(154, 313, 114, 15);
		panel.add(lblsmtpstate);
		
		JTextField smtpstateTextField=new JTextField();
		smtpstateTextField.setEditable(false);
		smtpstateTextField.setBorder(null);
		smtpstateTextField.setBounds(278, 310, 114, 21);
		//smtpstateTextField.setBackground();
		panel.add(smtpstateTextField);
		smtpstateTextField.setColumns(10);
		
		JButton startSMTPButton=new JButton();
		startSMTPButton.setBounds(646, 310, 120, 21);
		startSMTPButton.setText("����SMTPЭ��");
		startSMTPButton.setActionCommand("startSMTP");
		startSMTPButton.addActionListener(this);
		panel.add(startSMTPButton);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 382, 864, 2);
		panel.add(separator_1);
		
		/**
		 * POP3Э��
		 */
		JLabel lblpop=new JLabel("POP3Э��");
		lblpop.setBounds(64, 416, 60, 15);
		panel.add(lblpop);
		
		JLabel lblpopstate=new JLabel("POP3Э��״̬:");
		lblpopstate.setBounds(154, 473, 114, 15);
		panel.add(lblpopstate);
		
		JTextField popstateTextField=new JTextField();
		popstateTextField.setEditable(false);
		popstateTextField.setBorder(null);
		popstateTextField.setBounds(278, 470, 114, 21);
		//smtpstateTextField.setBackground();
		panel.add(popstateTextField);
		popstateTextField.setColumns(10);
		
		JButton startPOPButton=new JButton();
		startPOPButton.setBounds(646, 470, 120, 21);
		startPOPButton.setText("����POP3Э��");
		startPOPButton.setActionCommand("startPOP3");
		startPOPButton.addActionListener(this);
		panel.add(startPOPButton);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String event=e.getActionCommand();
		switch(event){
		case "refresh":
			String host=serverMgr.getLocalHost();//��ȡ����IP��ַ
			IPtextField.setText(host);
		case "run":
			if(startButton.getText().equals("����������")){
				serverMgr.runServer();
				startButton.setText("�رշ�����");
				
			}else if(startButton.getText().equals("�رշ�����")){
				int port=Integer.parseInt(PorttextField.getText());
				serverMgr.shutdownServer(port);
				startButton.setText("����������");
			}
		case "startSMTP":
			
		case "startPOP3":
			
			
		}
		
	}






}
