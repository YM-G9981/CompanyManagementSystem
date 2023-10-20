package com.example.companyManagementSystem.controller.hrmResourceController.impl;

import com.example.companyManagementSystem.controller.hrmResourceController.ModifyHrmResourceController;
import com.example.companyManagementSystem.entity.hrmResource.Department;
import com.example.companyManagementSystem.entity.hrmResource.Personal;
import com.example.companyManagementSystem.entity.hrmResource.Position;
import com.example.companyManagementSystem.service.hrmResourceService.ModifyHrmResourceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/modifyHrmResource")
public class ModifyHrmResourceControllerImpl implements ModifyHrmResourceController {
    @Resource
    private ModifyHrmResourceService modifyHrmResourceService;

    @Override
    @PostMapping("/singleModifyPersonal")
    public boolean singleModifyPersonal(@RequestBody Personal personal) {
        return modifyHrmResourceService.singleModifyPersonal(personal);
    }

    @Override
    @PostMapping("/batchModifyPersonals")
    public boolean batchModifyPersonals(@RequestBody List<Personal> personals) {
        return modifyHrmResourceService.batchModifyPersonals(personals);
    }

    @Override
    @PostMapping("/singleModifyDepartment")
    public boolean singleModifyDepartment(@RequestBody Department department) {
        return modifyHrmResourceService.singleModifyDepartment(department);
    }

    @Override
    @PostMapping("/batchModifyDepartments")
    public boolean batchModifyDepartments(@RequestBody List<Department> departments) {
        return modifyHrmResourceService.batchModifyDepartments(departments);
    }

    @Override
    @PostMapping("/singleModifyPosition")
    public boolean singleModifyPosition(@RequestBody Position position) {
        return modifyHrmResourceService.singleModifyPosition(position);
    }

    @Override
    @PostMapping("/batchModifyPositions")
    public boolean batchModifyPositions(@RequestBody List<Position> positions) {
        return modifyHrmResourceService.batchModifyPositions(positions);
    }

}
