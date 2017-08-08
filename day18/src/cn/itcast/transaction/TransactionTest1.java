package cn.itcast.transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import cn.itcast.utils.JdbcUtil;
public class TransactionTest1 {
	public static void main(String[] args) {
		String sql="update account set money=500 where id=2";
		Connection con=null;
		Statement st=null;
		try{
		con=JdbcUtil.getConnection();
		con.setAutoCommit(false);//开启事务，相当于start transaction
		st=con.createStatement();
		st.executeUpdate(sql);
		}catch(SQLException e){
			e.printStackTrace();
			//事务回滚
			try{
				con.rollback();
			}catch(SQLException e1){
				e1.printStackTrace();
			}
			
			
			
		}finally{
			try{
				con.commit();//事务提交
				st.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			
			
		}
		
		
	}
	}
}
