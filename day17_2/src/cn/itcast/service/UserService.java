package cn.itcast.service;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.exception.LoginException;

public class UserService {

	public User login(User user) throws LoginException{
		return new UserDao().findUser(user);
	}

}
