package com.example.companyManagementSystem.service.hrmResourceService.impl;

import com.example.companyManagementSystem.repository.hrmResourceRepository.DepartmentRepository;
import com.example.companyManagementSystem.repository.hrmResourceRepository.PersonalRepository;
import com.example.companyManagementSystem.repository.hrmResourceRepository.PositionRepository;
import com.example.companyManagementSystem.repository.hrmResourceRepository.UserRepository;
import com.example.companyManagementSystem.service.hrmResourceService.DropHrmResourceService;
import com.example.companyManagementSystem.utils.utils.RepositoryUtil;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DropHrmResourceServiceImpl implements DropHrmResourceService {
    @Resource
    private DepartmentRepository departmentRepository;
    @Resource
    private PersonalRepository personalRepository;
    @Resource
    private PositionRepository positionRepository;
    @Resource
    private UserRepository userRepository;
    @Resource
    private RepositoryUtil repositoryUtil;

    @Override
    public boolean dropDepartments(List<Long> departments) {
        return repositoryUtil.deleteAllById(departmentRepository,departments);
    }

    @Override
    public boolean dropPositions(List<Long> positions) {
        return repositoryUtil.deleteAllById(positionRepository,positions);
    }
    @Override
    public boolean dropPersonals(List<Long> personals) {
        return repositoryUtil.deleteAllById(personalRepository,personals);
    }
    @Override
    public boolean dropUsers(List<Long> userIds) {
        return repositoryUtil.deleteAllById(userRepository,userIds);
    }
}
