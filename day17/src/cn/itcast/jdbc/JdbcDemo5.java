package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo5 {
	public static void main(String[] args){
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try{
			//String password="456";
			//String sql="update user set password='"+password+"'where id=3";
			//1.注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.获取连接
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/day17","root","root");
			//3.获取操作sql语句的对象statement
			 st=con.createStatement();
			//4.执行sql
			 rs=st.executeQuery("select * from user");
			//5.执行结果集
			while(rs.next()){
				int id=rs.getInt("id");
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
		}
			try {
				if(st!=null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			
			}
			try {
				if(con!=null)
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			
		}
		
		
	}
	}
}
