package com.example.companyManagementSystem.controller.hrmResourceController.impl;

import com.example.companyManagementSystem.controller.hrmResourceController.DropHrmResourceController;
import com.example.companyManagementSystem.service.hrmResourceService.DropHrmResourceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/dropHrmResource")
public class DropHrmResourceControllerImpl implements DropHrmResourceController {
    @Resource
    private DropHrmResourceService dropHrmResourceService;

    @PostMapping("/dropDepartments")
    @Override
    public boolean dropDepartments(@RequestBody List<Long> departments) {
        return dropHrmResourceService.dropDepartments(departments);
    }

    @PostMapping("/dropPositions")
    @Override
    public boolean dropPositions(@RequestBody List<Long> positions) {
        return dropHrmResourceService.dropPositions(positions);
    }

    @PostMapping("/dropPersonals")
    @Override
    public boolean dropPersonals(@RequestBody List<Long> personals) {
        return dropHrmResourceService.dropPersonals(personals);
    }

    @PostMapping("/dropUsers")
    @Override
    public boolean dropUsers(@RequestBody List<Long> users) {
        return dropHrmResourceService.dropUsers(users);
    }
}
