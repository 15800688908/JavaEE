package cn.itcast.service;

import java.sql.Connection;
import java.sql.SQLException;

import cn.itcast.dao.AccountDao;
import cn.itcast.utils.JdbcUtil;

public class AccountService {
	//开启事务Connection 保证事务统一
	public void account(String accountIn,String accountOut,double money){
		AccountDao dao=new AccountDao();
		Connection con=null;
		try{
			con=JdbcUtil.getConnection();
			con.setAutoCommit(false);
			
			dao.accountOut(con,accountOut, money);
			dao.accountIn(con,accountIn, money);
			
			
		}catch(SQLException e){
			e.printStackTrace();
			if(con!=null){
				con.rollback();
			}
			throw e;
		}finally{
			if(con!=null){
				con.commit();
				con.close();
			}
		}
	}		
}
