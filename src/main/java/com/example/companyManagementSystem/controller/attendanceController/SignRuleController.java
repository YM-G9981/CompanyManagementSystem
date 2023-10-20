package com.example.companyManagementSystem.controller.attendanceController;

import com.example.companyManagementSystem.entity.attendance.SignRule;

import java.util.List;

public interface SignRuleController {
    List<SignRule> getAllSignRule();


    boolean dropSignRules(List<Long> signRulesId);

    List<SignRule> getSignRuleByPersonalId(long personalId);

    List<SignRule> getSignRuleByDepartmentId(long departmentId);

    boolean addSignRule(SignRule signRule);
}
