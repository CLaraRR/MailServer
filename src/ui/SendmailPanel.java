package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import entity.ServerMgr;
import entity.User;
import entity.UserMgr;
import method.MailSender;

public class SendmailPanel extends JFrame implements ActionListener{

	private JPanel detailPanel;
	private JTextField textFieldSender;
	private JTextField textFieldReceiver;
	private JTextField textFieldSubject;
	//private JTextField textFieldContent;
	private JTextArea textArea;
	private User userCurrent;
	private UserMgr userMgr;
	private ServerMgr serverMgr;

	/**
	 * Create the frame.
	 */
	public SendmailPanel(MainFrame mFrame) {
		detailPanel=mFrame.getDetatilPanel();
		userMgr=new UserMgr();
		serverMgr=new ServerMgr();
		
	}

	public void setDetailPanel(JPanel panel) {
		// TODO Auto-generated method stub
		panel.removeAll();
		panel.setLayout(null);
		
		
		JLabel labelSender = new JLabel("发件人：");
		labelSender.setBounds(39, 27, 54, 15);
		panel.add(labelSender);
		
		textFieldSender = new JTextField();
		textFieldSender.setBounds(103, 24, 719, 21);
		panel.add(textFieldSender);
		textFieldSender.setColumns(10);
		
		JLabel labelReceiver = new JLabel("收件人：");
		labelReceiver.setBounds(39, 64, 54, 15);
		panel.add(labelReceiver);
		
		textFieldReceiver = new JTextField();
		textFieldReceiver.setBounds(103, 61, 719, 21);
		panel.add(textFieldReceiver);
		textFieldReceiver.setColumns(10);
		
		JLabel labelTheme = new JLabel("主题：");
		labelTheme.setBounds(39, 103, 54, 15);
		panel.add(labelTheme);
		
		textFieldSubject = new JTextField();
		textFieldSubject.setBounds(103, 100, 719, 21);
		panel.add(textFieldSubject);
		textFieldSubject.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setBounds(39, 153, 783, 359);
		panel.add(textArea);
		
		JLabel labelBody = new JLabel("正文");
		labelBody.setBounds(39, 128, 54, 15);
		panel.add(labelBody);
		
		JButton buttonClear = new JButton("清空");
		buttonClear.setBounds(39, 522, 93, 23);
		buttonClear.setActionCommand("clear");
		buttonClear.addActionListener(this);
		panel.add(buttonClear);
		
		JButton buttonSend = new JButton("发送");
		buttonSend.setBounds(729, 522, 93, 23);
		buttonSend.setActionCommand("send");
		buttonSend.addActionListener(this);
		panel.add(buttonSend);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String event=e.getActionCommand();
		switch(event){
		case "send":
			String from=textFieldSender.getText();
			String to=textFieldReceiver.getText();
			String mailSubject=textFieldSubject.getText();
			String mailContent=textArea.getText();
			List<String> userlist=new ArrayList<String>();
			String host=serverMgr.getServerName();
			//System.out.println("***"+to);
			if(to.equals("ALL")){
				List<String> rs=userMgr.getUserList1();
				for(int i=0;i<rs.size();i++){
					
					String touser=rs.get(i)+"@"+host;
					System.out.println(touser);
					userlist.add(touser);
				}

			}else if(to.contains(";")){
				String[] users=to.split(";");
				for(int i=0;i<users.length;i++){
					userlist.add(users[i]);
				}
				
			}else{
				userlist.add(to);
			}
			
			for(int i=0;i<userlist.size();i++){
				System.out.println(userlist.get(i));
			}
			MailSender sender=new MailSender(from,userlist,mailSubject,mailContent);
			int result=sender.send();
			if(result==2){
				JOptionPane.showMessageDialog(detailPanel, "发送成功！", "消息",JOptionPane.DEFAULT_OPTION);
				
			}else{
				JOptionPane.showMessageDialog(detailPanel, "发送失败！", "消息",JOptionPane.WARNING_MESSAGE); 
			}
			break;
		case "clear":
			textFieldSender.setText("");
			textFieldReceiver.setText("");
			textFieldSubject.setText("");
			textArea.setText("");
			break;
		}
		
	}

}
