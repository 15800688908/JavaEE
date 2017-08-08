package cn.itcast.dao;

import cn.itcast.entity.Admin;

public interface IAdminDao {
	Admin findByNameAndPwd(Admin admin);
}
