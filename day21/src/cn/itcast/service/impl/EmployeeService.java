package cn.itcast.service.impl;

import java.util.List;

import cn.itcast.dao.IEmployeeDao;
import cn.itcast.dao.impl.EmployeeDao;
import cn.itcast.entity.Employee;
import cn.itcast.service.IEmployeeService;

public class EmployeeService implements IEmployeeService {
	private IEmployeeDao employeeDao = new EmployeeDao();

	public List<Employee> getAll() {
		return employeeDao.getAll();
	}

}
