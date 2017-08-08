package cn.itcast.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

//只抽取到connection

public class JdbcUtil {
	private static final String DRIVERCLASS;
	private static final String URL;
	private static final String USERNAME;
	private static final String PASSWORD;
	private static final ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	static {
		// jdbc文件名
		DRIVERCLASS = ResourceBundle.getBundle("jdbc").getString("driverClass");
		URL = ResourceBundle.getBundle("jdbc").getString("url");
		USERNAME = ResourceBundle.getBundle("jdbc").getString("username");
		PASSWORD = ResourceBundle.getBundle("jdbc").getString("password");
	}
	static {
		try {
			// 将加载驱动操作放在静态代码块里面
			Class.forName(DRIVERCLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		Connection con = tl.get();// 第一次拿到的是null
		if (con == null) {
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			tl.set(con);// 将con装入到ThreadLocal中
		}
		// 对装饰类进行增强
		// return new MyConnection()
		
		return con;
	}

	public static void closeStatement(Statement st) throws SQLException {
		if (st != null) {
			st.close();
		}
	}

	public static void closeConnection(Connection con) throws SQLException {
		if (con != null) {
			con.close();
		}
	}
}

class MyConnection implements Connection {
	private Connection con;

	public MyConnection(Connection con) {
		this.con = con;
	}

	public void close() {
		// 重点改变其行为
		// add(con);
	}
}