package com.ssm.service;

import java.util.List;

import com.ssm.model.Department;

public interface DepartmentService {
	
	public int deleteDeptById(Integer deptId);
	
	public int updateDeptById(Integer deptId, Department department);
	
	public int addDept(Department department);
	
	public int getDeptCount();
	
	public List<Department> getDeptList(Integer offset, Integer limit);
	
	public Department getDeptById(Integer deptId);
	
	public Department getDeptByName(String deptName);
	
	public List<Department> getDeptName();
}
