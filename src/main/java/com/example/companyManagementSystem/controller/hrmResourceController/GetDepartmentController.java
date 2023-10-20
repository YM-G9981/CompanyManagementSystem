package com.example.companyManagementSystem.controller.hrmResourceController;

import com.example.companyManagementSystem.entity.hrmResource.Department;
import com.example.companyManagementSystem.entity.hrmResource.departmentList.DepartmentListTree;
import com.example.companyManagementSystem.entity.hrmResource.personalList.PersonalListTree;

import java.util.Date;
import java.util.List;

public interface GetDepartmentController {
    List<Department> getAllDepartments();
    List<Department> getDepartmentById(long departmentId);

    List<Department> getDepartmentsByDepartmentNameLike(String departmentName);

    List<Department> getDepartmentByDepartmentState(int state);

    List<Department> getDepartmentByDepartmentCreateTime(Date minCreateTime, Date maxCreateTime);

    PersonalListTree getPersonalListTreeByDepartmentId(long departmentId);

    DepartmentListTree getDepartmentListTreeByDepartmentId(long departmentId);

}
