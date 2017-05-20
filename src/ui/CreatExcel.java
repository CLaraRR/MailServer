package ui;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import entity.UserMgr;

public class CreatExcel {
	public void Creat(int flag,DefaultTableModel JTableModel,JTable ShowTable,JScrollPane jspShow){
		try{
			ResultSet rs=null;
			UserMgr userMgr=new UserMgr();
			rs=userMgr.getUserList();
			ResultSetMetaData rsmd=rs.getMetaData();
			int colCount=rsmd.getColumnCount();		//得到列数
			String[] name=new String[colCount];
			JTableModel.setRowCount(0);	//表格模板的行数和列数清零
			JTableModel.setColumnCount(0);
			//得到列名
			for(int i=1;i<=colCount;i++){
				name[i-1]=rsmd.getColumnName(i);
				JTableModel.addColumn(name[i-1]);
			}
			rs.beforeFirst();
			//得到各行的属性�??
			while(rs.next()){
				String[] value=new String[colCount];
				for(int i=1;i<=colCount;i++)
					value[i-1]=rs.getString(i);
				JTableModel.addRow(value);
			}
			rs.close();
			JTableModel.setRowCount(JTableModel.getRowCount()+15);
			JTableModel.setColumnCount(JTableModel.getColumnCount()+1);
		    ShowTable=new JTable(JTableModel);	//用表格模板初始化表格 
			ShowTable.setEnabled(true);		//设置表格能被编辑
			ShowTable.setRowHeight(20);		//设置行高
			ShowTable.setFillsViewportHeight(true);
			ShowTable.setFont(new Font("宋体",0,15));
			FitTableColumns(ShowTable);
			ShowTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//关闭自动调节列宽
			ShowTable.setCellSelectionEnabled(true);			//允许选取单元�?
			ShowTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);	//允许多�??
			jspShow.add(ShowTable);		//添加到显示面板上
			jspShow.setViewportView(ShowTable);
			
		}catch(SQLException wrong){
			JOptionPane.showMessageDialog(jspShow, "数据库访问异�?","错误",0);
		}
	}
	public void FitTableColumns(JTable myTable){
		  JTableHeader header = myTable.getTableHeader();
		  int rowCount = myTable.getRowCount();
		  Enumeration columns = myTable.getColumnModel().getColumns();
		  while(columns.hasMoreElements()){
			  TableColumn column = (TableColumn)columns.nextElement();
			  int col = header.getColumnModel().getColumnIndex(column.getIdentifier());
			  int width = (int)myTable.getTableHeader().getDefaultRenderer()
		                 .getTableCellRendererComponent(myTable, column.getIdentifier()
		                         , false, false, -1, col).getPreferredSize().getWidth();
			  for(int row = 0; row<rowCount; row++){
				  int preferedWidth = (int)myTable.getCellRenderer(row, col).getTableCellRendererComponent(myTable,
						  myTable.getValueAt(row, col), false, false, row, col).getPreferredSize().getWidth();
				  width = Math.max(width, preferedWidth);
			  }
			  header.setResizingColumn(column); // 此行很重�?
			  column.setWidth(width+myTable.getIntercellSpacing().width+11);
		  }
	}
}
