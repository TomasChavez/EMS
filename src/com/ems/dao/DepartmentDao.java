package com.ems.dao;

import java.util.List;

import com.ems.model.Department;

public interface DepartmentDao {

	/***
	 * Used to retrieve all departments
	 * @return 
	 */
	List<Department> getAllDepartments();
}
