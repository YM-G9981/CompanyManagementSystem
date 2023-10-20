package com.example.companyManagementSystem.controller.attendanceController;

import com.example.companyManagementSystem.entity.attendance.Sign;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface SignController {
    boolean saveSign(Sign sign);

    boolean importSignExcel(MultipartFile multipartFile);

    ResponseEntity<byte[]> getBatchImportSignsTemple();


}
