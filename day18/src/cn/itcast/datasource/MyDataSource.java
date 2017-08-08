package cn.itcast.datasource;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.sql.DataSource;

import cn.itcast.utils.JdbcUtil;

public class MyDataSource implements DataSource {
	private LinkedList<Connection> ll;

	public MyDataSource() throws SQLException {
		ll = new LinkedList<Connection>();
		for (int i = 0; i < 5; i++) {
			Connection con = JdbcUtil.getConnection();
			ll.add(con);
		}
	}

	public Connection getConnection() throws SQLException {
		if (ll.isEmpty()) {
			Connection con = JdbcUtil.getConnection();
			ll.add(con);
		}
		final Connection con = ll.removeFirst();
		// 使用动态代理来实现
		Connection proxyCon = (Connection) Proxy.newProxyInstance(con
				.getClass().getClassLoader(), con.getClass().getInterfaces(),
				new InvocationHandler() {
					public Object invoke(Object proxy, Method method,
							Object[] args) throws Throwable {
						if ("close".equals(method.getName())) {
							// 重新装回去连接池
							ll.add(con);
							return null;
						} else {
							return method.invoke(con, args);// 如果不是close,执行此方法
						}
					}
				});
		return proxyCon;
	}

	// 使用完成的connection对象重新装入list集合中
	public void readd(Connection con) {
		ll.addLast(con);
	}

	public int getSize() {
		return ll.size();
	}
}
