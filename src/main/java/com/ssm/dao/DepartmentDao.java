package com.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ssm.model.Department;

public interface DepartmentDao {

	String TABLE_NAME = "tbl_dept";
	String INSERT_FIELDS = "dept_name, dept_leader";
	String SELECT_FIELDS = "dept_id as 'deptId', " + "dept_name as 'deptName', " + "dept_leader as 'deptLeader'";
	
	//新增
	@Insert({ "INSERT INTO", TABLE_NAME, "(", INSERT_FIELDS,
			")" + "VALUES(#{department.deptName},#{department.deptLeader})" })
	int insertDept(@Param("department") Department department);
	
	//更新
	@Update({ "UPDATE", TABLE_NAME,
			"SET dept_name=#{department.deptName},dept_leader=#{department.deptLeader} " + "WHERE dept_id=#{deptId}" })
	int updateDeptById(@Param("deptId") Integer deptId, 
			@Param("department") Department department);
	
	//删除
	@Delete({ "DELETE FROM", TABLE_NAME, "WHERE dept_id=#{deptId}" })
	int deleteDeptById(@Param("deptId") Integer deptId);

	// 查询
	@Select({ "SELECT", SELECT_FIELDS, "FROM", TABLE_NAME, "WHERE dept_id=#{deptId}" })
	Department selectOneById(@Param("deptId") Integer deptId);

	@Select({ "SELECT", SELECT_FIELDS, "FROM", TABLE_NAME, "WHERE dept_leader=#{deptLeader}" })
	Department selectOneByLeader(@Param("deptLeader") String deptLeader);

	@Select({ "SELECT", SELECT_FIELDS, "FROM", TABLE_NAME, "WHERE dept_name=#{deptName}" })
	Department selectOneByName(@Param("deptName") String deptName);

	@Select({ "SELECT", SELECT_FIELDS, "FROM", TABLE_NAME })
	List<Department> selectDeptList();
	
	@Select({"SELECT COUNT(dept_id) FROM", TABLE_NAME,
    		"WHERE dept_leader = #{deptLeader} OR dept_name = #{deptName}"})
	int checkDeptsExistsByNameORleader(@Param("deptName") String deptName,
			@Param("deptLeader") String deptLeader);
	
	@Select({"SELECT COUNT(*) FROM", TABLE_NAME})
    int countDepts();
	
	@Select({"SELECT",SELECT_FIELDS,"FROM",TABLE_NAME,"LIMIT #{offset},#{limit}"})
	List<Department> selectDeptsByLimitAndOffset(@Param("offset") Integer offset,
            @Param("limit") Integer limit);
}