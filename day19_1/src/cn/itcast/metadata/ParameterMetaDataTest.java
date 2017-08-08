package cn.itcast.metadata;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;

public class ParameterMetaDataTest {
	// 获取sql语句中占位符的相关信息
	public static void main(String[] args) throws Exception {
		Connection con = JdbcUtil.getConnection();
		String sql = "select * from account where id=?";
		PreparedStatement pst = con.prepareStatement(sql);
		ParameterMetaData pmd = pst.getParameterMetaData();

		int count = pmd.getParameterCount();
		//结果集是varchar
		String type = pmd.getParameterTypeName(1);
	}
}
