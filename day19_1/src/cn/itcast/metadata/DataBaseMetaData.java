package cn.itcast.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseMetaData {
	public static void main(String[] args) throws SQLException {
		Connection con = JdbcUtil.getConnection();
		DatabaseMetaData dmd = con.getMetaData();

		String driverName = dmd.getDriverName();
		String userName = dmd.getUserName();
		String url = dmd.getURL();

		String databaseProductName = dmd.getDatabaseProductName();
		String dataVersion = dmd.getDatabaseProductVersion();

		ResultSet rs = dmd.getPrimaryKeys(null, null, "account");
	}
}
