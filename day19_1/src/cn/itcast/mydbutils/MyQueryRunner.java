package cn.itcast.mydbutils;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class MyQueryRunner {
	private DataSource ds;

	public MyQueryRunner() {
	}

	public MyQueryRunner(DataSource ds) {
		this.ds = ds;
	}

	public Object query(Connection con, String sql, Object... params)
			throws SQLException {
		// 将结果集封装成用户想要的
		return null;
	}

	public int update(Connection con, String sql, Object... params)
			throws SQLException {
		PreparedStatement pst = con.prepareStatement(sql);
		// 参数元数据
		ParameterMetaData pmd = pst.getParameterMetaData();
		int count = pmd.getParameterCount();
		pst.close();
		return pst.executeUpdate();
	}

	public int update(String sql, Object... params) throws SQLException {
		Connection con = ds.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		// 参数元数据
		ParameterMetaData pmd = pst.getParameterMetaData();
		int count = pmd.getParameterCount();
		pst.close();
		con.close();
		return pst.executeUpdate();
	}
}
