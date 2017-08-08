package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.itcast.utils.JdbcUtil2;
//滚动结果集

public class JdbcDemo7 {
	public static void main(String[] args) throws SQLException{
		Connection con=JdbcUtil2.getConnection();
		Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=st.executeQuery("select * from user");
		//定位
		rs.absolute(3);
		System.out.println(rs.getInt("id"));
		rs.updateString("password", "456");
		rs.updateRow();
		rs.close();
		st.close();
		con.close();
		
	}
}
