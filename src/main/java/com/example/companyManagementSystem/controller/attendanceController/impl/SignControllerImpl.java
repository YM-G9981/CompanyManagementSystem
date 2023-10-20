package com.example.companyManagementSystem.controller.attendanceController.impl;

import com.example.companyManagementSystem.controller.attendanceController.SignController;
import com.example.companyManagementSystem.entity.attendance.Sign;
import com.example.companyManagementSystem.service.attendanceService.SignService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@RequestMapping("/sign")
public class SignControllerImpl implements SignController {
    @Resource
    private SignService signService;

    @PostMapping("/saveSign")
    @Override
    public boolean saveSign(@RequestBody Sign sign) {
        return signService.saveSign(sign);
    }

    @PostMapping("/importSignExcel")
    @Override
    public boolean importSignExcel(@RequestBody MultipartFile file) {
        return signService.importSignExcel(file);
    }

    @PostMapping("/getBatchImportSignsTemple")
    @Override
    public ResponseEntity<byte[]> getBatchImportSignsTemple() {
        return signService.getBatchImportSignsTemple();
    }

}
