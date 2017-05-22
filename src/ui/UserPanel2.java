package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class UserPanel2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserPanel2 frame = new UserPanel2();
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
	public UserPanel2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("操作");
		label.setFont(new Font("黑体", Font.BOLD, 16));
		label.setBounds(514, 42, 54, 23);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("用户名：");
		label_1.setFont(new Font("黑体", Font.PLAIN, 14));
		label_1.setBounds(533, 99, 67, 15);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(610, 91, 231, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("密码：");
		label_2.setFont(new Font("黑体", Font.PLAIN, 14));
		label_2.setBounds(533, 154, 67, 15);
		contentPane.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(610, 146, 231, 31);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_3 = new JLabel("状态：");
		label_3.setFont(new Font("黑体", Font.PLAIN, 14));
		label_3.setBounds(533, 211, 67, 15);
		contentPane.add(label_3);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("黑体", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"用户", "管理员"}));
		comboBox.setBounds(610, 203, 231, 31);
		contentPane.add(comboBox);
		
		JButton button = new JButton("添加");
		button.setFont(new Font("黑体", Font.PLAIN, 14));
		button.setBounds(543, 284, 67, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("更改");
		button_1.setFont(new Font("黑体", Font.PLAIN, 14));
		button_1.setBounds(631, 284, 67, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("删除");
		button_2.setFont(new Font("黑体", Font.PLAIN, 14));
		button_2.setBounds(724, 284, 67, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("清空");
		button_3.setFont(new Font("黑体", Font.PLAIN, 14));
		button_3.setBounds(807, 284, 67, 23);
		contentPane.add(button_3);
		
		JLabel label_4 = new JLabel("搜索用户");
		label_4.setFont(new Font("黑体", Font.BOLD, 16));
		label_4.setBounds(514, 354, 86, 23);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("请输入要查询的用户：");
		label_5.setFont(new Font("黑体", Font.PLAIN, 14));
		label_5.setBounds(514, 414, 157, 15);
		contentPane.add(label_5);
		
		textField_2 = new JTextField();
		textField_2.setBounds(514, 449, 246, 31);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton button_4 = new JButton("查询");
		button_4.setFont(new Font("黑体", Font.PLAIN, 14));
		button_4.setBounds(781, 453, 93, 23);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("刷新表单");
		button_5.setFont(new Font("黑体", Font.PLAIN, 14));
		button_5.setBounds(514, 10, 93, 23);
		contentPane.add(button_5);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBorder(null);
		textField_3.setBounds(514, 317, 66, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(514, 490, 360, 82);
		textField_4.setBorder(null);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
	}
}
