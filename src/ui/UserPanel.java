package ui;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import ui.CreatExcel;

public class UserPanel {
	private JPanel detailPanel;
	private CreatExcel userExcel;
	public UserPanel(MainFrame mainFrame) {
		// TODO Auto-generated constructor stub
		detailPanel = mainFrame.getDetatilPanel();
	}

	public void setDetailPanel(JPanel detailPanel) {
		// TODO Auto-generated method stub
		detailPanel.removeAll();
		setTablePanel(detailPanel);//表格面板
		setOperationPanel(detailPanel); //操作面板
		setQueryPanel(detailPanel); //查询面板
		
		
	}

	
	/**
	 * 搜索用户面板
	 */
	private void setQueryPanel(JPanel detailPanel) {
		// TODO Auto-generated method stub

		JLabel label_4 = new JLabel("搜索用户");
		label_4.setFont(new Font("黑体", Font.BOLD, 16));
		label_4.setBounds(514, 354, 86, 23);
		detailPanel.add(label_4);
		
		JLabel label_5 = new JLabel("请输入要查询的用户：");
		label_5.setFont(new Font("黑体", Font.PLAIN, 14));
		label_5.setBounds(514, 414, 157, 15);
		detailPanel.add(label_5);
		
		JTextField textField_2 = new JTextField();
		textField_2.setBounds(671, 406, 203, 31);
		detailPanel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton button_4 = new JButton("查询");
		button_4.setFont(new Font("黑体", Font.PLAIN, 14));
		button_4.setBounds(543, 481, 93, 23);
		detailPanel.add(button_4);
		
		JButton button_5 = new JButton("刷新表单");
		button_5.setFont(new Font("黑体", Font.PLAIN, 14));
		button_5.setBounds(724, 481, 93, 23);
		detailPanel.add(button_5);
		
	}

	
	/**
	 * 设置操作面板
	 */
	private void setOperationPanel(JPanel detailPanel) {
		// TODO Auto-generated method stub

		JLabel label = new JLabel("操作");
		label.setFont(new Font("黑体", Font.BOLD, 16));
		label.setBounds(514, 42, 54, 23);
		detailPanel.add(label);
		
		JLabel label_1 = new JLabel("用户名：");
		label_1.setFont(new Font("黑体", Font.PLAIN, 14));
		label_1.setBounds(533, 99, 67, 15);
		detailPanel.add(label_1);
		
		JTextField textField = new JTextField();
		textField.setBounds(610, 91, 231, 31);
		detailPanel.add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("密码：");
		label_2.setFont(new Font("黑体", Font.PLAIN, 14));
		label_2.setBounds(533, 154, 67, 15);
		detailPanel.add(label_2);
		
		JTextField textField_1 = new JTextField();
		textField_1.setBounds(610, 146, 231, 31);
		detailPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_3 = new JLabel("状态：");
		label_3.setFont(new Font("黑体", Font.PLAIN, 14));
		label_3.setBounds(533, 211, 67, 15);
		detailPanel.add(label_3);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("黑体", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"用户", "管理员"}));
		comboBox.setBounds(610, 203, 231, 31);
		detailPanel.add(comboBox);
		
		JButton button = new JButton("添加");
		button.setFont(new Font("黑体", Font.PLAIN, 14));
		button.setBounds(543, 284, 67, 23);
		detailPanel.add(button);
		
		JButton button_1 = new JButton("更改");
		button_1.setFont(new Font("黑体", Font.PLAIN, 14));
		button_1.setBounds(631, 284, 67, 23);
		detailPanel.add(button_1);
		
		JButton button_2 = new JButton("删除");
		button_2.setFont(new Font("黑体", Font.PLAIN, 14));
		button_2.setBounds(724, 284, 67, 23);
		detailPanel.add(button_2);
		
		JButton button_3 = new JButton("清空");
		button_3.setFont(new Font("黑体", Font.PLAIN, 14));
		button_3.setBounds(807, 284, 67, 23);
		detailPanel.add(button_3);
		
	}

	
	/**
	 * 设置表格面板
	 */
	private void setTablePanel(JPanel detailPanel) {
		// TODO Auto-generated method stub
		
		JLabel userLbael=new JLabel("用户列表");
		userLbael.setBounds(5, 5, 54, 15);
		detailPanel.add(userLbael);
		final DefaultTableModel JTableModel = new DefaultTableModel();	//定义表格模板，model负责数据处理
		JTable ShowTable=new JTable(JTableModel);		//定义表格，tabel只负责数据显示
		JScrollPane jspShow=new JScrollPane(ShowTable);	//滚动面板
		userExcel=new CreatExcel();
		userExcel.Creat(0,JTableModel,ShowTable,jspShow);
		jspShow.setBounds(0,20,500,500);
		detailPanel.add(jspShow);
	}
	

}
