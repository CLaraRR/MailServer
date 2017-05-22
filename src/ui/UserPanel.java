package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import entity.User;
import entity.UserMgr;
import ui.CreatExcel;

public class UserPanel implements ActionListener{
	private JPanel detailPanel;
	private CreatExcel userExcel;
	private JTextField textFieldUsername;
	private JTextField textFieldPwd;
	private JComboBox<String> comboBox;
	private JTextField textFieldQuery;
	private JTextField textFieldResult;
	private UserMgr userMgr;

	public UserPanel(MainFrame mainFrame) {
		// TODO Auto-generated constructor stub
		detailPanel = mainFrame.getDetatilPanel();
		userMgr=new UserMgr();
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

		JLabel labelQuery = new JLabel("搜索用户");
		labelQuery.setFont(new Font("黑体", Font.BOLD, 16));
		labelQuery.setBounds(514, 354, 86, 23);
		detailPanel.add(labelQuery);
		
		JLabel labelQ = new JLabel("请输入要查询的用户：");
		labelQ.setFont(new Font("黑体", Font.PLAIN, 14));
		labelQ.setBounds(514, 414, 157, 15);
		detailPanel.add(labelQ);
		
		textFieldQuery = new JTextField();
		textFieldQuery.setBounds(514, 449, 246, 31);
		detailPanel.add(textFieldQuery);
		textFieldQuery.setColumns(10);
		
		JButton buttonQuery = new JButton("查询");
		buttonQuery.setFont(new Font("黑体", Font.PLAIN, 14));
		buttonQuery.setBounds(781, 453, 93, 23);
		buttonQuery.setActionCommand("query");
		buttonQuery.addActionListener(this);
		detailPanel.add(buttonQuery);
		
		textFieldResult = new JTextField();
		textFieldResult.setEditable(false);
		textFieldResult.setBounds(514, 490, 360, 82);
		textFieldResult.setBorder(null);
		detailPanel.add(textFieldResult);
		textFieldResult.setColumns(10);

		
	}

	
	/**
	 * 设置操作面板
	 */
	private void setOperationPanel(JPanel detailPanel) {
		// TODO Auto-generated method stub
		JButton buttonRefresh = new JButton("刷新表单");
		buttonRefresh.setFont(new Font("黑体", Font.PLAIN, 14));
		buttonRefresh.setBounds(514, 10, 93, 23);
		buttonRefresh.setActionCommand("refresh");
		buttonRefresh.addActionListener(this);
		detailPanel.add(buttonRefresh);
		
		JLabel labelOpr = new JLabel("操作");
		labelOpr.setFont(new Font("黑体", Font.BOLD, 16));
		labelOpr.setBounds(514, 42, 54, 23);
		detailPanel.add(labelOpr);
		
		JLabel labelUsername = new JLabel("用户名：");
		labelUsername.setFont(new Font("黑体", Font.PLAIN, 14));
		labelUsername.setBounds(533, 99, 67, 15);
		detailPanel.add(labelUsername);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(610, 91, 231, 31);
		detailPanel.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		JLabel labelPwd = new JLabel("密码：");
		labelPwd.setFont(new Font("黑体", Font.PLAIN, 14));
		labelPwd.setBounds(533, 154, 67, 15);
		detailPanel.add(labelPwd);
		
		textFieldPwd = new JTextField();
		textFieldPwd.setBounds(610, 146, 231, 31);
		detailPanel.add(textFieldPwd);
		textFieldPwd.setColumns(10);
		
		JLabel labelState = new JLabel("状态：");
		labelState.setFont(new Font("黑体", Font.PLAIN, 14));
		labelState.setBounds(533, 211, 67, 15);
		detailPanel.add(labelState);
		
		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("黑体", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"用户", "管理员"}));
		comboBox.setBounds(610, 203, 231, 31);
		detailPanel.add(comboBox);
		
		JButton buttonAdd = new JButton("添加");
		buttonAdd.setFont(new Font("黑体", Font.PLAIN, 14));
		buttonAdd.setBounds(543, 284, 67, 23);
		buttonAdd.setActionCommand("add");
		buttonAdd.addActionListener(this);
		detailPanel.add(buttonAdd);
		
		JButton buttonEdit = new JButton("更改");
		buttonEdit.setFont(new Font("黑体", Font.PLAIN, 14));
		buttonEdit.setBounds(631, 284, 67, 23);
		buttonEdit.setActionCommand("edit");
		buttonEdit.addActionListener(this);
		detailPanel.add(buttonEdit);
		
		JButton buttonDel = new JButton("删除");
		buttonDel.setFont(new Font("黑体", Font.PLAIN, 14));
		buttonDel.setBounds(724, 284, 67, 23);
		buttonDel.setActionCommand("del");
		buttonDel.addActionListener(this);
		detailPanel.add(buttonDel);
		
		JButton buttonClear = new JButton("清空");
		buttonClear.setFont(new Font("黑体", Font.PLAIN, 14));
		buttonClear.setBounds(807, 284, 67, 23);
		buttonClear.setActionCommand("clear");
		buttonClear.addActionListener(this);
		detailPanel.add(buttonClear);
		
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

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String event=e.getActionCommand();
		
		switch(event){
		case "refresh":
			setTablePanel(detailPanel);
			break;
		case "add":
			String username=textFieldUsername.getText();
			String pwd=textFieldPwd.getText();
			String state=(String) comboBox.getSelectedItem();
//			System.out.println(username);
//			System.out.println(pwd);
//			System.out.println(state);
			int result=1;
			if(state.equals("用户"))
				result=userMgr.addUser(new User(username,pwd,0));
			else if(state.equals("管理员"))
				result=userMgr.addUser(new User(username,pwd,1));
			if(result==2){
				JOptionPane.showMessageDialog(detailPanel, "添加成功！", "消息",JOptionPane.DEFAULT_OPTION);
				
			}else{
				JOptionPane.showMessageDialog(detailPanel, "添加失败！", "消息",JOptionPane.WARNING_MESSAGE); 
			}
			refreshOperationPanel();
			break;
		case "edit":
			String username2=textFieldUsername.getText();
			String pwd2=textFieldPwd.getText();
			String state2=(String) comboBox.getSelectedItem();
			User user=null;
			if(state2.equals("用户")){
				
				user=new User(username2,pwd2,0);
				if(userMgr.findUser(user)){
				
					int result2=userMgr.editUser(user);
					if(result2==2){
						JOptionPane.showMessageDialog(detailPanel, "更改成功！", "消息",JOptionPane.DEFAULT_OPTION); 
					}else{
						JOptionPane.showMessageDialog(detailPanel, "更改失败！", "消息",JOptionPane.WARNING_MESSAGE); 
					}
				}else{
					JOptionPane.showMessageDialog(detailPanel, "要先添加才能修改！", "消息",JOptionPane.WARNING_MESSAGE); 
				}
			}else if(state2.equals("管理员")){
				
				user=new User(username2,pwd2,1);
				if(userMgr.findAdmin(username2)){
					int result3=userMgr.editAdmin(user);
					if(result3==2){
						JOptionPane.showMessageDialog(detailPanel, "更改成功！", "消息",JOptionPane.DEFAULT_OPTION); 
					}else{
						JOptionPane.showMessageDialog(detailPanel, "更改失败！", "消息",JOptionPane.WARNING_MESSAGE); 
					}
					
				}else{
					JOptionPane.showMessageDialog(detailPanel, "要先添加才能修改！", "消息",JOptionPane.WARNING_MESSAGE); 
				}
			}
				
			refreshOperationPanel();
			break;
		case "del":
			String username3=textFieldUsername.getText();
			String state3=(String) comboBox.getSelectedItem();
			if(state3.equals("用户")){
				Boolean flag=userMgr.deleteUser(username3);
				if(flag){
					JOptionPane.showMessageDialog(detailPanel, "删除成功！", "消息",JOptionPane.DEFAULT_OPTION);
				}else{
					JOptionPane.showMessageDialog(detailPanel, "删除失败！", "消息",JOptionPane.WARNING_MESSAGE);
				}
			}else if(userMgr.equals("管理员")){
				int result4=userMgr.delAdmin(username3);
				if(result4==2){
					JOptionPane.showMessageDialog(detailPanel, "删除成功！", "消息",JOptionPane.DEFAULT_OPTION);
				}else{
					JOptionPane.showMessageDialog(detailPanel, "删除失败！", "消息",JOptionPane.WARNING_MESSAGE);
				}
			}
			refreshOperationPanel();
			break;
		case "clear":
			refreshOperationPanel();
			break;
			
		case "query":
			String username4=textFieldQuery.getText();
			System.out.println(username4);
			User user1=null;
			user1=userMgr.getUser(username4);
			if(user1!=null){
				textFieldResult.setText("用户名："+user1.getUsername()+"\n"+"加密的密码："+user1.getPsw());
			}else if((user1=userMgr.getAdmin(username4))!=null){
				textFieldResult.setText("用户名："+user1.getUsername()+"\n"+"密码："+user1.getPsw());
			}
			break;
			
		}
	}

	private void refreshOperationPanel() {
		// TODO Auto-generated method stub
		textFieldUsername.setText("");
		textFieldPwd.setText("");
		comboBox.setSelectedIndex(0);
		
	}
	

}
