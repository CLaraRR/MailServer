package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.UserMgr;

import java.awt.GridBagLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;

public class LoginFrame extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JLabel nameLabel;
	private JLabel pwdLabel;
	private JTextField nametextField;
	private JTextField pwdtextField;
	private JPanel imgPanel;
	private JLabel imgLabel;
	private JLabel lblNetpower;
	private JLabel lblPoweredByNetpower;
	
	private UserMgr userMgr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		LoginFrame frame = new LoginFrame();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		init();
		userMgr=new UserMgr();

	}

	private void init() {
		// TODO Auto-generated method stub
		setTitle("MailServer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNetpower = new JLabel("Welcome to MailServer");
		lblNetpower.setFont(new Font("Footlight MT Light", Font.PLAIN, 30));
		lblNetpower.setBounds(284, 152, 307, 31);
		contentPane.add(lblNetpower);
		
		imgPanel = new JPanel();
		imgPanel.setBounds(375, 60, 89, 82);
		contentPane.add(imgPanel);
		
		imgLabel = new JLabel();
		ImageIcon img = new ImageIcon("img\\2.png");//创建图片对象
		imgLabel.setIcon(img);
		imgPanel.add(imgLabel);
		
		nameLabel = new JLabel("用户名：");
		nameLabel.setBounds(311, 260, 54, 15);
		contentPane.add(nameLabel);
		
		nametextField = new JTextField();
		nametextField.setBounds(375, 257, 167, 21);
		contentPane.add(nametextField);
		nametextField.setColumns(10);
		
		pwdLabel = new JLabel("密码：");
		pwdLabel.setBounds(311, 300, 54, 15);
		contentPane.add(pwdLabel);
		
		pwdtextField = new JTextField();
		pwdtextField.setBounds(375, 297, 167, 21);
		contentPane.add(pwdtextField);
		pwdtextField.setColumns(10);
		
		JButton button = new JButton("登录");
		button.setBounds(391, 380, 93, 23);
		button.setActionCommand("login");
		button.addActionListener(this);
		contentPane.add(button);
		
		
		lblPoweredByNetpower = new JLabel("Powered By NetPower&Apache James");
		lblPoweredByNetpower.setFont(new Font("Footlight MT Light", Font.PLAIN, 20));
		lblPoweredByNetpower.setBounds(530, 542, 323, 31);
		contentPane.add(lblPoweredByNetpower);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String event=e.getActionCommand();
		switch(event){
		case "login":
			String adminname=nametextField.getText();
			String pwd=pwdtextField.getText();
			System.out.println(adminname);
			System.out.println(pwd);
			Boolean flag=userMgr.verifyAdmin(adminname, pwd);
			if(flag){
				MainFrame.getInstance();
			}else{
				nametextField.setText("");
				pwdtextField.setText("");
				JOptionPane.showMessageDialog(contentPane, "账号或密码错误！", "消息",JOptionPane.WARNING_MESSAGE);  
			}
			break;
		}
		
		
	}
}
