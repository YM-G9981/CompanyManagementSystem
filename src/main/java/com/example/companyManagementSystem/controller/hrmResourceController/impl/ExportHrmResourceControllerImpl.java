package com.example.companyManagementSystem.controller.hrmResourceController.impl;

import com.example.companyManagementSystem.controller.hrmResourceController.ExportHrmResourceController;
import com.example.companyManagementSystem.service.hrmResourceService.ExportHrmResourceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/exportHrmResource")
public class ExportHrmResourceControllerImpl implements ExportHrmResourceController {
    @Resource
    private ExportHrmResourceService exportHrmResourceService;

    @GetMapping("/getDepartmentsExcel")
    @Override
    public ResponseEntity<byte[]> getDepartmentsExcel() {
        return exportHrmResourceService.getDepartmentsExcel();
    }

    @GetMapping("/getPersonalsExcel")
    @Override
    public ResponseEntity<byte[]> getPersonalsExcel() {
        return exportHrmResourceService.getPersonalsExcel();
    }

    @GetMapping("/getPositionsExcel")
    @Override
    public ResponseEntity<byte[]> getPositionsExcel() {
        return exportHrmResourceService.getPositionsExcel();
    }
}
