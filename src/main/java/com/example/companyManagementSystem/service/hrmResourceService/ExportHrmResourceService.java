package com.example.companyManagementSystem.service.hrmResourceService;

import org.springframework.http.ResponseEntity;

public interface ExportHrmResourceService {
    ResponseEntity<byte[]> getDepartmentsExcel();

    ResponseEntity<byte[]> getPersonalsExcel();

    ResponseEntity<byte[]> getPositionsExcel();
}
