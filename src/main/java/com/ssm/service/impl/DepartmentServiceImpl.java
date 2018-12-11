package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.DepartmentDao;
import com.ssm.model.Department;
import com.ssm.service.DepartmentService;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public int deleteDeptById(Integer deptId) {
		// TODO Auto-generated method stub
		return departmentDao.deleteDeptById(deptId);
	}

	@Override
	public int updateDeptById(Integer deptId, Department department) {
		// TODO Auto-generated method stub
		return departmentDao.updateDeptById(deptId, department);
	}

	@Override
	public int addDept(Department department) {
		// TODO Auto-generated method stub
		return departmentDao.insertDept(department);
	}

	@Override
	public int getDeptCount() {
		// TODO Auto-generated method stub
		return departmentDao.countDepts();
	}

	@Override
	public List<Department> getDeptList(Integer offset, Integer limit) {
		// TODO Auto-generated method stub
		return departmentDao.selectDeptsByLimitAndOffset(offset, limit);
	}

	@Override
	public Department getDeptById(Integer deptId) {
		// TODO Auto-generated method stub
		return departmentDao.selectOneById(deptId);
	}

	@Override
	public Department getDeptByName(String deptName) {
		// TODO Auto-generated method stub
		return departmentDao.selectOneByName(deptName);
	}

	@Override
	public List<Department> getDeptName() {
		// TODO Auto-generated method stub
		return departmentDao.selectDeptList();
	}

}
