package cn.itcast.dao.impl;

import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.dao.IAdminDao;
import cn.itcast.entity.Admin;
import cn.itcast.utils.JdbcUtils;

public class AdminDao implements IAdminDao {

	public Admin findByNameAndPwd(Admin admin) {
		String sql = "";
		try {
			return JdbcUtils.getQueryRuner().query(sql,
					new BeanHandler<Admin>(Admin.class),admin.getUserName());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
