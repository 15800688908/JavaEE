package cn.itcast.dbutils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import cn.itcast.utils.DataSourceUtils;
public class QueryRunnerTest {
 @Test
 public void fun1()throws SQLException{
	 QueryRunner runner=new QueryRunner();// 事务手动控制
	 Connection con=DataSourceUtils.getConnection();
 }
 @Test
 public void fun2(){
	 QueryRunner runner=new QueryRunner(DataSourceUtils.getDataSource());// 事务自动控制，即一个事务一个sql
 }
}
