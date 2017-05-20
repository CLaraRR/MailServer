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
		setTablePanel(detailPanel);//������
		setOperationPanel(detailPanel); //�������
		setQueryPanel(detailPanel); //��ѯ���
		
		
	}

	
	/**
	 * �����û����
	 */
	private void setQueryPanel(JPanel detailPanel) {
		// TODO Auto-generated method stub

		JLabel label_4 = new JLabel("�����û�");
		label_4.setFont(new Font("����", Font.BOLD, 16));
		label_4.setBounds(514, 354, 86, 23);
		detailPanel.add(label_4);
		
		JLabel label_5 = new JLabel("������Ҫ��ѯ���û���");
		label_5.setFont(new Font("����", Font.PLAIN, 14));
		label_5.setBounds(514, 414, 157, 15);
		detailPanel.add(label_5);
		
		JTextField textField_2 = new JTextField();
		textField_2.setBounds(671, 406, 203, 31);
		detailPanel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton button_4 = new JButton("��ѯ");
		button_4.setFont(new Font("����", Font.PLAIN, 14));
		button_4.setBounds(543, 481, 93, 23);
		detailPanel.add(button_4);
		
		JButton button_5 = new JButton("ˢ�±�");
		button_5.setFont(new Font("����", Font.PLAIN, 14));
		button_5.setBounds(724, 481, 93, 23);
		detailPanel.add(button_5);
		
	}

	
	/**
	 * ���ò������
	 */
	private void setOperationPanel(JPanel detailPanel) {
		// TODO Auto-generated method stub

		JLabel label = new JLabel("����");
		label.setFont(new Font("����", Font.BOLD, 16));
		label.setBounds(514, 42, 54, 23);
		detailPanel.add(label);
		
		JLabel label_1 = new JLabel("�û�����");
		label_1.setFont(new Font("����", Font.PLAIN, 14));
		label_1.setBounds(533, 99, 67, 15);
		detailPanel.add(label_1);
		
		JTextField textField = new JTextField();
		textField.setBounds(610, 91, 231, 31);
		detailPanel.add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("���룺");
		label_2.setFont(new Font("����", Font.PLAIN, 14));
		label_2.setBounds(533, 154, 67, 15);
		detailPanel.add(label_2);
		
		JTextField textField_1 = new JTextField();
		textField_1.setBounds(610, 146, 231, 31);
		detailPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_3 = new JLabel("״̬��");
		label_3.setFont(new Font("����", Font.PLAIN, 14));
		label_3.setBounds(533, 211, 67, 15);
		detailPanel.add(label_3);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("����", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"�û�", "����Ա"}));
		comboBox.setBounds(610, 203, 231, 31);
		detailPanel.add(comboBox);
		
		JButton button = new JButton("���");
		button.setFont(new Font("����", Font.PLAIN, 14));
		button.setBounds(543, 284, 67, 23);
		detailPanel.add(button);
		
		JButton button_1 = new JButton("����");
		button_1.setFont(new Font("����", Font.PLAIN, 14));
		button_1.setBounds(631, 284, 67, 23);
		detailPanel.add(button_1);
		
		JButton button_2 = new JButton("ɾ��");
		button_2.setFont(new Font("����", Font.PLAIN, 14));
		button_2.setBounds(724, 284, 67, 23);
		detailPanel.add(button_2);
		
		JButton button_3 = new JButton("���");
		button_3.setFont(new Font("����", Font.PLAIN, 14));
		button_3.setBounds(807, 284, 67, 23);
		detailPanel.add(button_3);
		
	}

	
	/**
	 * ���ñ�����
	 */
	private void setTablePanel(JPanel detailPanel) {
		// TODO Auto-generated method stub
		
		JLabel userLbael=new JLabel("�û��б�");
		userLbael.setBounds(5, 5, 54, 15);
		detailPanel.add(userLbael);
		final DefaultTableModel JTableModel = new DefaultTableModel();	//������ģ�壬model�������ݴ���
		JTable ShowTable=new JTable(JTableModel);		//������tabelֻ����������ʾ
		JScrollPane jspShow=new JScrollPane(ShowTable);	//�������
		userExcel=new CreatExcel();
		userExcel.Creat(0,JTableModel,ShowTable,jspShow);
		jspShow.setBounds(0,20,500,500);
		detailPanel.add(jspShow);
	}
	

}
