package cn.itcast.dao;
import cn.itcast.utils.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import cn.itcast.domain.User;
import cn.itcast.exception.LoginException;

public class UserDao {

	public User _findUser(User user) throws LoginException{
		String sql="select  * from user where username='" +
				user.getUsername()+"' and password='"+
				user.getPassword()+"'";
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		try {
			con=JdbcUtil.getConnection();
			st=con.createStatement();
			rs=st.executeQuery(sql);
			
			if(rs.next()){
				User u=new User();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new LoginException(e.getMessage());
		}
		return null;
	}
	public User findUser(User user) throws LoginException{
		String sql="select  * from user where username=? and password=?";
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try {
			con=JdbcUtil.getConnection();
			pst=con.prepareStatement(sql);
			
			//1,2代表问号的序号
			pst.setString(1,user.getUsername());
			pst.setString(2,user.getPassword());
			
			rs=pst.executeQuery();
			if(rs.next()){
				User u=new User();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new LoginException(e.getMessage());
		}
		return null;
	}
}
