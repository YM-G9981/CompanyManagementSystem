package com.example.companyManagementSystem.controller.hrmResourceController.impl;

import com.example.companyManagementSystem.controller.hrmResourceController.GetDepartmentController;
import com.example.companyManagementSystem.entity.hrmResource.Department;
import com.example.companyManagementSystem.entity.hrmResource.departmentList.DepartmentListTree;
import com.example.companyManagementSystem.entity.hrmResource.personalList.PersonalListTree;
import com.example.companyManagementSystem.service.hrmResourceService.GetDepartmentService;
import com.example.companyManagementSystem.service.hrmResourceService.GetListService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/getDepartment")
public class GetDepartmentControllerImpl implements GetDepartmentController {
    @Resource
    private GetDepartmentService service;
    @Resource
    private GetListService getListService;
    @Override
    @PostMapping("/getAllDepartments")
    public List<Department> getAllDepartments() {
        return service.getAllDepartments();
    }
    @Override
    @PostMapping("/getDepartmentById/{departmentId}")
    public List<Department> getDepartmentById(@PathVariable long departmentId) {
        return service.getDepartmentById(departmentId);
    }

    @Override
    @PostMapping("/getDepartmentsByDepartmentNameLike/{departmentName}")
    public List<Department> getDepartmentsByDepartmentNameLike(@PathVariable String departmentName) {
        return service.getDepartmentsByDepartmentNameLike("%"+departmentName+"%");
    }

    @Override
    @PostMapping("/getDepartmentByDepartmentState/{state}")
    public List<Department> getDepartmentByDepartmentState(@PathVariable int state) {
        return service.getDepartmentByDepartmentState(state);
    }

    @Override
    @PostMapping("/getDepartmentByDepartmentCreateTime/{minCreateTime},{maxCreateTime}")
    public List<Department> getDepartmentByDepartmentCreateTime
            (@PathVariable Date minCreateTime, @PathVariable Date maxCreateTime) {
        return service.getDepartmentByDepartmentCreateTime(minCreateTime, maxCreateTime);
    }

    @PostMapping("/getPersonalListTreeByDepartmentId/{departmentId}")
    @Override
    public PersonalListTree getPersonalListTreeByDepartmentId(@PathVariable long departmentId) {
        return getListService.getPersonalListTreeByDepartmentId(departmentId);
    }

    @PostMapping("/getDepartmentListTreeByDepartmentId/{departmentId}")
    @Override
    public DepartmentListTree getDepartmentListTreeByDepartmentId(@PathVariable long departmentId) {
        return getListService.getDepartmentListTreeByDepartmentId(departmentId);
    }
}
