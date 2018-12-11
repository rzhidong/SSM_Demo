package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.EmployeeDao;
import com.ssm.model.Employee;
import com.ssm.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public int getEmpCount() {
		// TODO Auto-generated method stub
		return employeeDao.countEmps();
	}

	@Override
	public List<Employee> getEmpList(Integer offset, Integer limit) {
		// TODO Auto-generated method stub
		return employeeDao.selectByLimitAndOffset(offset, limit);
	}

	@Override
	public Employee getEmpById(Integer empId) {
		// TODO Auto-generated method stub
		return employeeDao.selectEmpById(empId);
	}

	@Override
	public Employee getEmpByName(String empName) {
		// TODO Auto-generated method stub
		return employeeDao.selectEmpByName(empName);
	}

	@Override
	public int updateEmpById(Integer empId, Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.updateOneById(empId, employee);
	}

	@Override
	public int deleteEmpById(Integer empId) {
		// TODO Auto-generated method stub
		return employeeDao.deleteEmpById(empId);
	}

	@Override
	public int addEmp(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.insertEmp(employee);
	}

}
