package com.example.companyManagementSystem.service.hrmResourceService;

import com.example.companyManagementSystem.entity.hrmResource.Department;

import java.util.Date;
import java.util.List;

public interface GetDepartmentService {
    List<Department> getDepartmentById(long departmentId);

    List<Department> getDepartmentsByDepartmentNameLike(String departmentName);

    Department getDepartmentByDepartmentName(String departmentName);

    List<Department> getDepartmentByDepartmentState(int state);

    List<Department> getDepartmentByDepartmentCreateTime(Date minCreateTime, Date maxCreateTime);

    List<Department> getAllDepartments();
}
