package cn.itcast.jdbc;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;
public class JdbcDemo1 {
	public static void main(String[] args)throws SQLException{
		//1.注册驱动
		DriverManager.registerDriver(new Driver());
		
		//2.获取连接对象
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/day17","root","root");
		Statement st=con.createStatement();
		String sql="select * from user";
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()){
			int id=rs.getInt(1);
			//rs.getInt("id");
			String username=rs.getString(2);
		}
		rs.close();
		st.close();
		con.close();
		
	}
}
