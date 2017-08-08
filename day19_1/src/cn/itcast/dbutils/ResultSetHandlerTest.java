package cn.itcast.dbutils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.junit.Test;

import cn.itcast.domain.Account;
import cn.itcast.utils.DataSourceUtils;

public class ResultSetHandlerTest {
	@Test
	public void fun1() throws SQLException {
		String sql = null;
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		Account a = runner.query(sql, new ResultSetHandler<Account>() {
			public Account handle(ResultSet rs) throws SQLException {
				Account a = null;
				return a;
			}
		}, 2);
	}

}
