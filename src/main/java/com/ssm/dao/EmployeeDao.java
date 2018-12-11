package com.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ssm.model.Employee;

public interface EmployeeDao {
	String TABLE_NAME = "tbl_emp";
	String INSERT_FIELDS = "emp_name, emp_email, gender, department_id";
	String SELECT_FIELDS = "emp_id, " + INSERT_FIELDS;
	
	//新增
	@Insert({"INSERT INTO",TABLE_NAME,"(",INSERT_FIELDS,") "
			+ "VALUES(#{empName,jdbcType = VARCHAR},#{empEmail},#{gender},#{departmentId})"})
	int insertEmp(Employee employee);
	
	//@Insert({"INSERT INTO",TABLE_NAME,"(",INSERT_FIELDS,") VALUES(#{employee.empName},#{employee.empEmail},#{employee.gender},#{employee.departmentId})"})
	//int insertOne(@Param("employee")Employee employee);
	
	//更改
	int updateOneById(@Param("empId") Integer empId,@Param("employee") Employee employee); 
	
	//删除
	@Delete({"DELETE FROM",TABLE_NAME,"WHERE emp_id=#{empId}"})
	int deleteEmpById(@Param("empId") Integer empId);
	
	//查询
	Employee selectEmpById(@Param("empId") int empId);
	
    Employee selectEmpByName(@Param("empName") String empName);
    
    //查询带有部门信息的Employee
    Employee selectWithDeptById(@Param("empId") Integer empId);
    
    /**
     * 分页查询
     * @param limit 返回记录最大行数
     * @param offset 返回记录行的偏移量
     * @return 如offset=10，limit=5的时候，就会从数据库第11行记录开始返回5条查询结果，即范围从(offset+1)---(offset+limit)
     */
    List<Employee> selectByLimitAndOffset(@Param("offset") Integer offset,
                                          @Param("limit") Integer limit);
    
    /**
     * 查询总记录数
     * @return
     */
    @Select({"SELECT count(*) FROM", TABLE_NAME})
    int countEmps();
    
}