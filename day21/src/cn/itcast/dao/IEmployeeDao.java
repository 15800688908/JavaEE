package cn.itcast.dao;

import java.util.List;

import cn.itcast.entity.Employee;

public interface IEmployeeDao {
	List<Employee> getAll();
}
