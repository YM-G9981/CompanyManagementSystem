package com.example.companyManagementSystem.service.hrmResourceService.impl;

import com.alibaba.excel.EasyExcel;
import com.example.companyManagementSystem.entity.hrmResource.Department;
import com.example.companyManagementSystem.entity.hrmResource.Personal;
import com.example.companyManagementSystem.repository.hrmResourceRepository.DepartmentRepository;
import com.example.companyManagementSystem.repository.hrmResourceRepository.PersonalRepository;
import com.example.companyManagementSystem.service.hrmResourceService.ImportDepartmentService;
import com.example.companyManagementSystem.utils.utils.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

@Service
public class ImportDepartmentServiceImpl implements ImportDepartmentService {
    @Resource
    private DepartmentRepository departmentRepository;
    @Resource
    private PersonalRepository personalRepository;
    @Resource
    private FileUtil fileUtil;
    @Value("${filePath.importDepartmentsTemple}")
    private String fileName;
    @Override
    public boolean singleImportDepartment(Department department) {
        try {
            departmentRepository.save(department);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean batchImportDepartments(MultipartFile multipartFile) {
        try {
            List<Department> list = EasyExcel.read(multipartFile.getInputStream()).head(Department.class).sheet().doReadSync();
            for (Department department : list) {
                if (department.getSuperiorDepartment() != null) {
                    String superiorDepartmentName = department.getSuperiorDepartment().getDepartmentName();
                    Department superiorDepartment = departmentRepository.findDepartmentByDepartmentName(superiorDepartmentName);
                    department.setSuperiorDepartment(superiorDepartment);
                }
                if (department.getDepartmentManager() != null) {
                    String managerName = department.getDepartmentManager().getName();
                    Personal manager = personalRepository.findPersonalByName(managerName);
                    department.setDepartmentManager(manager);
                }
                departmentRepository.save(department);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public ResponseEntity<byte[]> getBatchImportDepartmentsTemple() {
        String filePath =  fileUtil.getResource()+"/"+fileName;
        File file = new File(filePath);
        return fileUtil.getResponseEntity(file);
    }
}
