package com.ssm.model;

public class Department {
    private Integer deptId;

    private String deptName;

    private String deptLeader;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public String getDeptLeader() {
        return deptLeader;
    }

    public void setDeptLeader(String deptLeader) {
        this.deptLeader = deptLeader == null ? null : deptLeader.trim();
    }
    

	public Department() {
	}
	
	public Department(Integer deptId, String deptName, String deptLeader) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptLeader = deptLeader;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", deptLeader=" + deptLeader + "]";
	}
    
    
}