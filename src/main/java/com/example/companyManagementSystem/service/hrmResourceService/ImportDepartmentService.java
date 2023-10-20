package com.example.companyManagementSystem.service.hrmResourceService;

import com.example.companyManagementSystem.entity.hrmResource.Department;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ImportDepartmentService {
    boolean singleImportDepartment(Department department);

    boolean batchImportDepartments(MultipartFile multipartFile);

    ResponseEntity<byte[]> getBatchImportDepartmentsTemple();
}
