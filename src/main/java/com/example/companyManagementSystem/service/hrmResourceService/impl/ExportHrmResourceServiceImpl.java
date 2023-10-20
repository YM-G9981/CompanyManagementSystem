package com.example.companyManagementSystem.service.hrmResourceService.impl;

import com.example.companyManagementSystem.entity.hrmResource.Department;
import com.example.companyManagementSystem.entity.hrmResource.Personal;
import com.example.companyManagementSystem.entity.hrmResource.Position;
import com.example.companyManagementSystem.repository.hrmResourceRepository.DepartmentRepository;
import com.example.companyManagementSystem.repository.hrmResourceRepository.PersonalRepository;
import com.example.companyManagementSystem.repository.hrmResourceRepository.PositionRepository;
import com.example.companyManagementSystem.service.hrmResourceService.ExportHrmResourceService;
import com.example.companyManagementSystem.utils.utils.FileUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExportHrmResourceServiceImpl implements ExportHrmResourceService {
    @Resource
    private FileUtil fileUtil;
    @Resource
    private DepartmentRepository departmentRepository;
    @Resource
    private PersonalRepository personalRepository;
    @Resource
    private PositionRepository positionRepository;

    @Override
    public ResponseEntity<byte[]> getDepartmentsExcel() {
        List<Department> departments = departmentRepository.findAll();
        return fileUtil.getExcelFile(departments, Department.class);
    }

    @Override
    public ResponseEntity<byte[]> getPersonalsExcel() {
        List<Personal> personals = personalRepository.findAll();
        return fileUtil.getExcelFile(personals, Personal.class);
    }

    @Override
    public ResponseEntity<byte[]> getPositionsExcel() {
        List<Position> positions = positionRepository.findAll();
        return fileUtil.getExcelFile(positions, Position.class);
    }
}
