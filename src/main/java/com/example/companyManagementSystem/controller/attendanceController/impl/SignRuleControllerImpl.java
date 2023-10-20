package com.example.companyManagementSystem.controller.attendanceController.impl;

import com.example.companyManagementSystem.controller.attendanceController.SignRuleController;
import com.example.companyManagementSystem.entity.attendance.SignRule;
import com.example.companyManagementSystem.service.attendanceService.SignRuleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/signRule")
public class SignRuleControllerImpl implements SignRuleController {
    @Resource
    private SignRuleService service;

    @Override
    @PostMapping("/getAllSignRule")
    public List<SignRule> getAllSignRule() {
        return service.getAllSignRule();
    }



    @Override
    @PostMapping("/dropSignRules")
    public boolean dropSignRules(@RequestBody List<Long> signRulesId) {
        return service.dropSignRules(signRulesId);
    }

    @Override
    @PostMapping("/getSignRuleByPersonal/{personalId}")
    public List<SignRule> getSignRuleByPersonalId(@PathVariable long personalId) {
        return service.getSignRuleByPersonalId(personalId);
    }

    @PostMapping("/getSignRuleByDepartment/{departmentId}")
    @Override
    public List<SignRule> getSignRuleByDepartmentId(@PathVariable long departmentId) {
        return service.getSignRuleByDepartmentId(departmentId);
    }


    @PostMapping("/addSignRule")
    @Override
    public boolean addSignRule(@RequestBody SignRule signRule) {
        System.out.println(signRule);
        return service.addSignRule(signRule);
    }

}
