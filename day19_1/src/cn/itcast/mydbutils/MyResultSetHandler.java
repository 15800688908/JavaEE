package cn.itcast.mydbutils;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface MyResultSetHandler {
	public Object handle(ResultSet rs)throws SQLException;
}
