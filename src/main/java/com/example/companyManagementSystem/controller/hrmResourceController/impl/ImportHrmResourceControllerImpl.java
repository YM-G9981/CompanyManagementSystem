package com.example.companyManagementSystem.controller.hrmResourceController.impl;

import com.example.companyManagementSystem.controller.hrmResourceController.ImportHrmResourceController;
import com.example.companyManagementSystem.entity.hrmResource.Department;
import com.example.companyManagementSystem.entity.hrmResource.Personal;
import com.example.companyManagementSystem.entity.hrmResource.Position;
import com.example.companyManagementSystem.service.hrmResourceService.ImportDepartmentService;
import com.example.companyManagementSystem.service.hrmResourceService.ImportPersonalService;
import com.example.companyManagementSystem.service.hrmResourceService.impl.ImportPositionServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@RequestMapping("/importHrmResource")
public class ImportHrmResourceControllerImpl implements ImportHrmResourceController {
    @Resource
    private ImportPersonalService importPersonalService;
    @Resource
    private ImportDepartmentService importDepartmentService;
    @Resource
    private ImportPositionServiceImpl importPositionService;

    @PostMapping("/singleImportPersonal")
    @Override
    public boolean singleImportPersonal(@RequestBody Personal personal) {
        return importPersonalService.singleImportPersonal(personal);
    }

    @PostMapping("/batchImportPersonals")
    @Override
    public boolean batchImportPersonals(@RequestBody MultipartFile file) {
        return importPersonalService.batchImportPersonals(file);
    }

    @PostMapping("/singleImportDepartment")
    @Override
    public boolean singleImportDepartment(@RequestBody Department department) {
        return importDepartmentService.singleImportDepartment(department);
    }
    @PostMapping("/batchImportDepartments")
    @Override
    public boolean batchImportDepartments(@RequestBody MultipartFile file) {
        return importDepartmentService.batchImportDepartments(file);
    }



    @PostMapping("/singleImportPosition")
    @Override
    public boolean singleImportPosition(@RequestBody Position position) {
        System.out.println(position);
        return importPositionService.singleImportPosition(position);
    }

    @PostMapping("/batchImportPositions")
    @Override
    public boolean batchImportPositions(@RequestBody MultipartFile file) {
        return importPositionService.batchImportPositions(file);
    }

    @GetMapping("/batchImportPersonalsTemple")
    @Override
    public ResponseEntity<byte[]> getBatchImportPersonalsTemple() {
        return importPersonalService.getBatchImportPersonalsTemple();
    }

    @GetMapping("/batchImportDepartmentsTemple")
    @Override
    public ResponseEntity<byte[]> getBatchImportDepartmentsTemple() {
        return importDepartmentService.getBatchImportDepartmentsTemple();
    }

    @GetMapping("/batchImportPositionsTemple")
    @Override
    public ResponseEntity<byte[]> getBatchImportPositionsTemple() {
        return importPositionService.getBatchImportPositionsTemple();
    }


}
