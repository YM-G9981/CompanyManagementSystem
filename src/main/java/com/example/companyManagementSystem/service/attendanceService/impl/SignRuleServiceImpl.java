package com.example.companyManagementSystem.service.attendanceService.impl;

import com.example.companyManagementSystem.entity.attendance.SignRule;
import com.example.companyManagementSystem.entity.hrmResource.Personal;
import com.example.companyManagementSystem.repository.attendanceRepository.SignRuleRepository;
import com.example.companyManagementSystem.repository.hrmResourceRepository.PersonalRepository;
import com.example.companyManagementSystem.service.attendanceService.SignRuleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SignRuleServiceImpl implements SignRuleService {
    @Resource
    private SignRuleRepository signRuleRepository;
    @Resource
    private PersonalRepository personalRepository;
    @Override
    public List<SignRule> getAllSignRule() {
        return signRuleRepository.findAll();
    }

    @Override
    public boolean dropSignRules(List<Long> signRulesId) {

        List<SignRule> signRules = signRuleRepository.findAllById(signRulesId);
        try {
            signRuleRepository.deleteAll(signRules);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<SignRule> getSignRuleByPersonalId(long personalId) {
        return signRuleRepository.findSignRulesBySignPersonal(personalId);
    }

    @Override
    public List<SignRule> getSignRuleByDepartmentId(long departmentId) {
        return signRuleRepository.findSignRulesByDepartment(departmentId);
    }

    @Override
    public boolean addSignRule(SignRule signRule) {
        List<Personal> personals = signRule.getSignPersonals();
        try {
            signRule =  signRuleRepository.save(signRule);
            for (Personal personal:personals ) {
                personal.setSignRule(signRule);
                personalRepository.save(personal);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
