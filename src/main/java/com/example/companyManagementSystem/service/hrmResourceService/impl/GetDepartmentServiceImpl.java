package com.example.companyManagementSystem.service.hrmResourceService.impl;

import com.example.companyManagementSystem.entity.hrmResource.Department;
import com.example.companyManagementSystem.repository.hrmResourceRepository.DepartmentRepository;
import com.example.companyManagementSystem.service.hrmResourceService.GetDepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class GetDepartmentServiceImpl implements GetDepartmentService {
    @Resource
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getDepartmentById(long departmentId) {
        return departmentRepository.findAllByDepartmentId(departmentId);
    }

    @Override
    public List<Department> getDepartmentsByDepartmentNameLike(String departmentName) {
        return departmentRepository.findAllByDepartmentNameLike(departmentName);
    }

    @Override
    public Department getDepartmentByDepartmentName(String departmentName) {
        return departmentRepository.findDepartmentByDepartmentName(departmentName);
    }

    @Override
    public List<Department> getDepartmentByDepartmentState(int state) {
        return departmentRepository.findAllByDepartmentState(state);
    }

    @Override
    public List<Department> getDepartmentByDepartmentCreateTime(Date minCreateTime, Date maxCreateTime) {
        return departmentRepository.findAllByDepartmentCreateTimeBetween(minCreateTime, maxCreateTime);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
}
