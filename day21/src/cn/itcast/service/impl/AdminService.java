package cn.itcast.service.impl;

import cn.itcast.dao.IAdminDao;
import cn.itcast.dao.impl.AdminDao;
import cn.itcast.entity.Admin;
import cn.itcast.service.IAdminService;

public class AdminService implements IAdminService {
	private IAdminDao adminDao = new AdminDao();

	public Admin findByNameAndPwd(Admin admin) {
		return adminDao.findByNameAndPwd(admin);
	}

}