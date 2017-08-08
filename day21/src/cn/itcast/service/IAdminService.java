package cn.itcast.service;

import cn.itcast.entity.Admin;

public interface IAdminService {

	Admin findByNameAndPwd(Admin admin);

}
