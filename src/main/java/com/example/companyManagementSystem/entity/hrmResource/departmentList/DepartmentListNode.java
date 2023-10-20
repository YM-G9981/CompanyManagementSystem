package com.example.companyManagementSystem.entity.hrmResource.departmentList;

import com.example.companyManagementSystem.entity.hrmResource.Department;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DepartmentListNode {
    private Department department;
    private List<DepartmentListNode> juniorDepartmentListNodes;

    public DepartmentListNode() {
        this.department = null;
        this.juniorDepartmentListNodes = new ArrayList<>();
    }

    public DepartmentListNode(Department department) {
        this.department = department;
        this.juniorDepartmentListNodes = new ArrayList<>();
    }
}
