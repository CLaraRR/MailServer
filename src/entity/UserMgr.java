package entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import db.DBBean;
import entity.User;

public class UserMgr {
	private HashMap<String, User> userList;

	public UserMgr() {
		super();
	}


	
	/**
	 * �õ������û����б�
	 * 
	 * @return
	 */
	public ResultSet getUserList() {
		userList = new HashMap<String, User>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		User user = null;
		try {
			conn = DBBean.getConnection();
			String sql = "select * from users";
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			while (rset.next()) 
			{
				user = new User(rset.getString("username"),rset.getString("pwdHash"),0);

				userList.put(rset.getString("username"), user);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} 
		
		return rset;
	}
	
	//����û�
	public int addUser(User newUser) {
		int result = 0; //
		if (findUser(newUser)) {//�Ȳ�����û������û������������findUser����
			result = 1; //
		} else {
			String sql = "insert into users(username,pwdHash)values('"
					+ newUser.getUsername()
					+ "','"
					+ newUser.getPsw() + "')";

			if (DBBean.update(sql)) {//�������ݿ��¼
				result = 2; //
			}
		}
		return result;
	}
	
	//�鿴���ݿ����Ƿ����м�¼
	public boolean findUser(User user) {
		boolean result = false;
		
		String sql = "select * from users where username=('"
				+ user.getUsername() + "')";
		result = DBBean.hasRecord(sql);
		
		return result;
	}
	
	//ɾ���û�
	public boolean deleteUser(String username) {
		boolean result = false;
		String sql = "delete from users where username =('" + username
				+ "')";
		result = DBBean.delete(sql);
		if(result==true) 
	    	System.out.println("delete user:" + sql);
		return result;
	}

	public User getUser(String username) {
		String sql = "select * from users where username=('" + username
				+ "')";
		User user = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		//userList = new HashMap<String, User>();
		try {
			conn = DBBean.getConnection();
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			while (rset.next()) {
				user = new User(rset.getString("username"), rset.getString("pwdHash"),0);
				//userList.put(rset.getString("username"), user);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBBean.clean(conn, stmt, rset);
		}
		return 	user;
	}
	

	public int editUser(User user) {
		int result = 1;
		String sql = "update users set pwdHash ='" + user.getPsw()
				+ "' " + "where username=('"
				+ user.getUsername() + "')";
		//System.out.println("edit user:" + sql);
		if (DBBean.update(sql)) {
			result = 2; 
		}

		return result;
	}
	
}
