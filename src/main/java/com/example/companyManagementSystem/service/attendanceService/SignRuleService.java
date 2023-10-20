package com.example.companyManagementSystem.service.attendanceService;

import com.example.companyManagementSystem.entity.attendance.SignRule;

import java.util.List;

public interface SignRuleService {
    List<SignRule> getAllSignRule();

    boolean dropSignRules(List<Long> signRulesId);

    List<SignRule> getSignRuleByPersonalId(long personalId);

    List<SignRule> getSignRuleByDepartmentId(long departmentId);

    boolean addSignRule(SignRule signRule);
}
