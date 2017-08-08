package cn.itcast.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

//只抽取到connection

public class JdbcUtil2 {
	private static final String DRIVERCLASS;
	private static final String URL;
	private static final String USERNAME;
	private static final String PASSWORD;
	
	static{
		//jdbc文件名
		DRIVERCLASS=ResourceBundle.getBundle("jdbc").getString("driverClass");
		URL=ResourceBundle.getBundle("jdbc").getString("url");
		USERNAME=ResourceBundle.getBundle("jdbc").getString("username");
		PASSWORD=ResourceBundle.getBundle("jdbc").getString("password");
	}
	static{
		try {
			//将加载驱动操作放在静态代码块里面
			Class.forName(DRIVERCLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
public static Connection getConnection() throws SQLException{
	
	Connection con=DriverManager.getConnection(URL,USERNAME,PASSWORD);
	return con;	
}
public static void closeStatement(Statement st) throws SQLException{
	if(st!=null){
		st.close();
	}
}
public static void closeConnection(Connection con) throws SQLException{
	if(con!=null){
		con.close();
	}
}
}
