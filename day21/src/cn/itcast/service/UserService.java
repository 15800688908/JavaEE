package cn.itcast.service;

import cn.itcast.dao.UserDao;
import cn.itcast.entity.User;

public class UserService {
	public User login(String username, String password) throws Exception {
		return new UserDao().findByNameAndPwd(username, password);
	}
}
