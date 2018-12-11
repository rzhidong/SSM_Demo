package com.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssm.dao.EmployeeDao;
import com.ssm.model.Employee;
import com.ssm.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class EmployeeTest {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private EmployeeService employeeService;
	
	//用来批量插入操作
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void testInsert() {
		Employee employee = new Employee();
		employee.setEmpName("cc");
		employee.setGender("男");
		employee.setEmpEmail("cc@qq.com");
		employee.setDepartmentId(2);
		
		int res = employeeDao.insertEmp(employee);
		System.out.println(res);
	}
	
	@Test
	public void testBatchInsert() {
		EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
		
		for (int i = 1; i < 200; i++) {
			String uid = UUID.randomUUID().toString().substring(0, 5);
			employeeDao.insertEmp(new Employee(i, "name_"+uid, uid+"@qq.com", i%2==0? "F":"M", i%6+1));
		}
	}
	
	@Test
	public void testUpdate() {
		Employee employee = new Employee();
		employee.setEmpName("bb");
		employee.setGender("女");
		employee.setEmpEmail("bb@qq.com");
		employee.setDepartmentId(3);
		
		int res = employeeDao.updateOneById(2, employee);
		System.out.println(res);
	}
	
	@Test
	public void testDelete() {
		System.out.println(employeeDao.deleteEmpById(3));
	}
	
	@Test
	public void testSelect() {
		System.out.println(employeeDao.selectByLimitAndOffset(0, 5));
		System.out.println(employeeService.getEmpList(0, 5));
	}
}
