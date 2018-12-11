package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssm.dao.DepartmentDao;
import com.ssm.model.Department;
import com.ssm.service.DepartmentService;

@RunWith(SpringJUnit4ClassRunner.class)//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class DepartmentTest {
	
	@Autowired
	private DepartmentDao departmentDao;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Test
	public void testInsert() {
		Department department = new Department();
		department.setDeptName("dept");
		department.setDeptLeader("leader");
		int res = departmentDao.insertDept(department);
		System.out.println(res);
	}
	
	@Test
	public void testUpdate() {
		Department department = new Department(null, "研发部","Tomsom");
        int res = departmentDao.updateDeptById(4, department);
        System.out.println(res);
	}
	
	@Test
	public void testDelete() {
		int res = departmentDao.deleteDeptById(5);
		System.out.println(res);
	}
	
	@Test
	public void testSelect() {
		System.out.println(departmentDao.selectOneById(1));
		System.out.println(departmentDao.selectDeptList());
		System.out.println(departmentDao.checkDeptsExistsByNameORleader("技术部", "talk"));
		System.out.println(departmentDao.selectDeptsByLimitAndOffset(1, 3));
		
		System.out.println(departmentService.getDeptById(1));
		System.out.println(departmentService.getDeptName());
		System.out.println(departmentService.getDeptCount());
		System.out.println(departmentService.getDeptList(2, 3));
	}

}
