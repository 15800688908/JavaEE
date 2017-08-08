package cn.itcast.transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import cn.itcast.utils.JdbcUtil;
public class TransactionTest {
	public static void main(String[] args)throws SQLException {
		String sql="update account set money=500 where id=2";
		Connection con=JdbcUtil.getConnection();
		con.setAutoCommit(false);//开启事务，相当于start transaction
		Statement st=con.createStatement();
		st.executeUpdate(sql);
		//事务回滚
		//con.rollback();
		con.commit();//事务提交
		st.close();
		con.close();
	}
}
