package cn.itcast.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//只抽取到connection

public class JdbcUtil {
public static Connection getConnection() throws ClassNotFoundException,SQLException{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/day17","root","root");
	return con;	
}
}
