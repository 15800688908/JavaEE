package cn.itcast.metadata;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class ResultSetMetaDataTest {
	public static void main(String[] args) throws Exception {
		Connection con = JdbcUtil.getConnection();
		ResultSet rs=con.createStatement().executeQuery("select id,name from aacount");
	
		ResultSetMetaData rsmd=rs.getMetaData();
		rsmd.getColumnCount();
	}
}
