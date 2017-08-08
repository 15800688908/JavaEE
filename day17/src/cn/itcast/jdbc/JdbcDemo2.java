package cn.itcast.jdbc;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
//解决加载两个驱动问题
public class JdbcDemo2 {
	public static void main(String[] args)throws SQLException,ClassNotFoundException{
		//1.注册驱动
		//会加载两个驱动DriverManager.registerDriver(new Driver());
		//降低耦合，不依赖jar包
		Class.forName("com.mysql.jdbc.Driver");
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		//2.获取连接对象
		//可以操作事务setAutoCommit(boolean flag)rollback()commit()
		//PreparedStatement 
		//CallableStatement存储过程
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/day17","root","root");
		//可以简写jdbc:mysql:///day17前提是本机和端口
		Statement st=con.createStatement();
		
		String sql="select * from user";
		//批处理操作addBatch() executeBatch() clearBatch()
		//execute可以执行任何sql
		int row=st.executeUpdate("update user set password='123456'");
		ResultSet rs=st.executeQuery(sql);
		//多条语句使用while，单条可以使用if
		while(rs.next()){
			int id=rs.getInt(1);
			//rs.getInt("id");列的名称或列号，如果列类型不知道，可以getObject()
			//getString()兼容性强，可以获取任何类型
			String username=rs.getString(2);
		}
		rs.close();
		st.close();
		con.close();
		
	}
}
