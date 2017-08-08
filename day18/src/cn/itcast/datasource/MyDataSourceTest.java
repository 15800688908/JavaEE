package cn.itcast.datasource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class MyDataSourceTest {
	public static void main(String[] args) throws SQLException {
		DataSource mds = new MyDataSource();
		Connection con = mds.getConnection();
		ResultSet rs = con.createStatement().executeQuery("");
		while (rs.next()) {

		}
		rs.close();
		// mds.readd(con);
		// 将连接对象重新放入连接池
		con.close();// 改变了原来的方式，不再是销毁，而是将其放回
		// mds.getSize();
	}
}
