package com.example.companyManagementSystem.service.attendanceService;

import com.example.companyManagementSystem.entity.attendance.Sign;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface SignService {
    boolean saveSign(Sign sign);

    boolean importSignExcel(MultipartFile file);

    ResponseEntity<byte[]> getBatchImportSignsTemple();
}
