package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class SendmailPanel2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton button_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SendmailPanel2 frame = new SendmailPanel2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SendmailPanel2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("发件人：");
		label.setBounds(39, 27, 54, 15);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(103, 24, 719, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("收件人：");
		label_1.setBounds(39, 64, 54, 15);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(103, 61, 719, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("主题：");
		label_2.setBounds(39, 103, 54, 15);
		contentPane.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(103, 100, 719, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("正文");
		label_3.setBounds(39, 128, 54, 15);
		contentPane.add(label_3);
		
		JButton button = new JButton("发送");
		button.setBounds(729, 522, 93, 23);
		contentPane.add(button);
		
		button_1 = new JButton("清空");
		button_1.setBounds(39, 522, 93, 23);
		contentPane.add(button_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(39, 153, 783, 359);
		contentPane.add(textArea);
	}
}
