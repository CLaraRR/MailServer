package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JLabel nameLabel;
	private JLabel pwdLabel;
	private JTextField nametextField;
	private JTextField pwdtextField;
	private JPanel imgPanel;
	private JLabel imgLabel;
	private JLabel lblNetpower;
	private JLabel lblPoweredByNetpower;

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
		setTitle("MailServer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		imgPanel = new JPanel();
		imgPanel.setBounds(375, 60, 89, 82);
		contentPane.add(imgPanel);
		
		imgLabel = new JLabel();
		ImageIcon img = new ImageIcon("img\\2.png");//创建图片对象
		imgLabel.setIcon(img);
		imgPanel.add(imgLabel);
		
		lblNetpower = new JLabel("Welcome to MailServer");
		lblNetpower.setFont(new Font("Footlight MT Light", Font.PLAIN, 30));
		lblNetpower.setBounds(284, 152, 307, 31);
		contentPane.add(lblNetpower);
		
		lblPoweredByNetpower = new JLabel("Powered By NetPower&Apache James");
		lblPoweredByNetpower.setFont(new Font("Footlight MT Light", Font.PLAIN, 20));
		lblPoweredByNetpower.setBounds(530, 542, 323, 31);
		contentPane.add(lblPoweredByNetpower);
		
		
	}
}
