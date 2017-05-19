package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("文件");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("退出");
		menu.add(menuItem);
		
		JMenu menu_1 = new JMenu("帮助");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_1 = new JMenuItem("关于邮件服务器");
		menu_1.add(menuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 874, 29);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("控制面板", null, panel, null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("用户管理", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("日志管理", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("系统管理", null, panel_3, null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 155, 864, 2);
		contentPane.add(separator);
		
		JLabel lblIp = new JLabel("IP\u5730\u5740");
		lblIp.setBounds(24, 39, 54, 15);
		contentPane.add(lblIp);
		
		JLabel lblmailserver = new JLabel("\u6B22\u8FCE\u4F7F\u7528MailServer,\u5F53\u524D\u7248\u672C1.0");
		lblmailserver.setBounds(64, 64, 277, 15);
		contentPane.add(lblmailserver);
		
		JLabel lblip = new JLabel("\u670D\u52A1\u5668\u5F53\u524DIP\u5730\u5740\uFF1A");
		lblip.setBounds(64, 109, 114, 15);
		contentPane.add(lblip);
		
		textField = new JTextField();
		textField.setBounds(176, 106, 93, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
	}
}
