package com.example.companyManagementSystem.service.hrmResourceService.impl;

import com.example.companyManagementSystem.entity.hrmResource.Department;
import com.example.companyManagementSystem.entity.hrmResource.Personal;
import com.example.companyManagementSystem.entity.hrmResource.Position;
import com.example.companyManagementSystem.repository.hrmResourceRepository.DepartmentRepository;
import com.example.companyManagementSystem.repository.hrmResourceRepository.PersonalRepository;
import com.example.companyManagementSystem.repository.hrmResourceRepository.PositionRepository;
import com.example.companyManagementSystem.service.hrmResourceService.ModifyHrmResourceService;
import com.example.companyManagementSystem.utils.utils.RepositoryUtil;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ModifyHrmResourceServiceImpl implements ModifyHrmResourceService {
    @Resource
    private PersonalRepository personalRepository;
    @Resource
    private DepartmentRepository departmentRepository;
    @Resource
    private PositionRepository positionRepository;
    @Resource
    private RepositoryUtil repositoryUtil;

    @Override
    @Modifying
    public boolean singleModifyPersonal(Personal personal) {
        return repositoryUtil.save(personalRepository, personal);
    }

    @Override
    @Modifying
    public boolean batchModifyPersonals(List<Personal> personals) {
        return repositoryUtil.saveAll(personalRepository, personals);
    }

    @Override
    @Modifying
    public boolean singleModifyDepartment(Department department) {
        return repositoryUtil.save(departmentRepository, department);
    }

    @Override
    @Modifying
    public boolean batchModifyDepartments(List<Department> departments) {
        return repositoryUtil.saveAll(departmentRepository, departments);
    }

    @Override
    @Modifying
    public boolean singleModifyPosition(Position position) {
        return repositoryUtil.save(positionRepository, position);
    }

    @Override
    public boolean batchModifyPositions(List<Position> positions) {
        return repositoryUtil.saveAll(positionRepository,positions);
    }
}
