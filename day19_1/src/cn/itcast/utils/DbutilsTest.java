package cn.itcast.utils;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;
import cn.itcast.domain.Account;
import cn.itcast.metadata.JdbcUtil;

public class DbutilsTest {
	@Test
	public void selectTest() throws SQLException {
		String sql = "select * from account";

		QueryRunner runner = new QueryRunner();

		List<Account> as = runner.query(JdbcUtil.getConnection(), sql,
				new BeanListHandler<Account>(Account.class));
		for (Account a : as) {
			System.out.print(a);
		}
	}

	@Test
	public void addTest() throws SQLException {
		String sql = "insert into account values(null,?,?)";
		QueryRunner runner = new QueryRunner();
		int row = runner.update(JdbcUtil.getConnection(), sql, "Allen", 1000);

	}
}
