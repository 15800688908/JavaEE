package cn.itcast.dao;

import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.entity.User;
import cn.itcast.utils.JdbcUtils;
import cn.itcast.utils.MD5Utils;

public class UserDao {
	public User findByNameAndPwd(String username, String password)
			throws Exception {
		String sql = "";
		return JdbcUtils.getQueryRuner().query(sql,
				new BeanHandler<User>(User.class), MD5Utils.md5(password));
	}
}
