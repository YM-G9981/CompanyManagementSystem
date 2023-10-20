package com.example.companyManagementSystem.controller.hrmResourceController;

import com.example.companyManagementSystem.entity.hrmResource.Department;
import com.example.companyManagementSystem.entity.hrmResource.Personal;
import com.example.companyManagementSystem.entity.hrmResource.Position;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ImportHrmResourceController {
    boolean singleImportPersonal(Personal personal);

    boolean batchImportPersonals(MultipartFile file);

    boolean singleImportDepartment(Department department);

    boolean batchImportDepartments(MultipartFile file);

    boolean singleImportPosition(Position department);

    boolean batchImportPositions(MultipartFile file);

    ResponseEntity<byte[]> getBatchImportPersonalsTemple();

    ResponseEntity<byte[]> getBatchImportDepartmentsTemple();

    ResponseEntity<byte[]> getBatchImportPositionsTemple();

}
