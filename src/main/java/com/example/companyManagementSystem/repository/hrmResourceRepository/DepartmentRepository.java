package com.example.companyManagementSystem.repository.hrmResourceRepository;

import com.example.companyManagementSystem.entity.hrmResource.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findAllByDepartmentId(long departmentId);

    Department findDepartmentByDepartmentId(long departmentId);


    List<Department> findAllByDepartmentNameLike(String departmentName);

    List<Department> findAllByDepartmentState(int state);

    List<Department> findAllByDepartmentCreateTimeBetween(Date minCreateTime, Date maxCreateTime);

    List<Department> findAllBySuperiorDepartment(Department superiorDepartment);

    Department findDepartmentByDepartmentName(String departmentName);

    List<Department> findDepartmentByDepartmentManagerPersonalId(long personalId);
}
