package cn.itcast.dao;


public interface AccountDao {
	public void accountOut(String accountOut,double money)throws Exception;
//	public void accountOut(Connection con, String accountOut, double money)
//			throws SQLException {
//		String sql = "update account set money=money-? where name=?";
//		PreparedStatement pst = con.prepareStatement(sql);
//		pst.setDouble(1, money);
//		pst.setString(2, accountOut);
//		int row=pst.executeUpdate();
//		if(row==0){
//			//抛异常
//		}
//		pst.close();
	//}
public void accountIn(String accountIn,double money)throws Exception;

//	public void accountIn(Connection con, String accountIn, double money)
//			throws SQLException {
//		String sql = "update account set money=money+? where name=?";
//		PreparedStatement pst = con.prepareStatement(sql);
//		pst.setDouble(1, money);
//		pst.setString(2, accountIn);
//		pst.executeUpdate();
//		pst.close();
	//}
}
