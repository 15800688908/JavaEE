package cn.itcast.datasource;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

public class DbcpTest {
	// 1.手动配置
	@Test
	public void test1() throws SQLException {
		BasicDataSource bds = new BasicDataSource();
		// 设置数据库配置
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql://day18");
		bds.setUsername("root");
		bds.setPassword("root");

		Connection con = bds.getConnection();
	}

	public void test2() throws Exception {
		Properties props = new Properties();
		// props.setProperty("driverClassName", "com.mysql.jdbc.Driver");
		FileInputStream fis = new FileInputStream(
				"D:\\MyElcipseWorkSpace\\day18\\src\\dbcp.properties");
		props.load(fis);
		DataSource ds = BasicDataSourceFactory.createDataSource(props);
	}
}
