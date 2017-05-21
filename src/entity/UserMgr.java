package entity;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import org.apache.james.security.DigestUtil;

import db.DBBean;
import entity.User;
import method.XMLHelper;

public class UserMgr {
	private HashMap<String, User> userList;
	private XMLHelper xmlHelper;
	
	
	public UserMgr(){
		super();
	}
	public UserMgr(String configFile) {
//		super();
		xmlHelper=new XMLHelper(configFile);
	}


	
	/**
	 * 得到所有用户的列表
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
	
	//添加用户
	public int addUser(User newUser) {
		int result = 0; //
		if (findUser(newUser)) {//先查找有没有这个用户。调用下面的findUser函数
			result = 1; //
		} else {
			if(newUser.getUsertype()==0){
				//如果是普通用户就插入到数据库
				//首先要把明文密码转换成密文，才能存到数据库中
				String pwdHash=null;
				try {
					pwdHash = DigestUtil.digestString(newUser.getPsw(), "SHA");
					System.out.println(pwdHash);
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String sql = "insert into users(username,pwdHash,pwdAlgorithm,useForwarding,"
						+ "useAlias)values('"
						+ newUser.getUsername()
						+ "','"+ pwdHash 
						+ "','"+"SHA"
						+ "','"+"0"
						+ "','"+"0"
						+"')";

				if (DBBean.update(sql)) {//更新数据库记录
					result = 2; //
				}
			}else if(newUser.getUsertype()==1){
				//如果是管理员就插入到配置文件中
				
				xmlHelper.addAdministrator(newUser.getUsername(),newUser.getPsw());
				
			}
			
		}
		return result;
	}
	
	//查看数据库中是否已有记录
	public boolean findUser(User user) {
		boolean result = false;
		
		String sql = "select * from users where username=('"
				+ user.getUsername() + "')";
		result = DBBean.hasRecord(sql);
		
		return result;
	}
	
	//删除用户
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
