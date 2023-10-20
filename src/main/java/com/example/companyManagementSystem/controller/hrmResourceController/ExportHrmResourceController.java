package com.example.companyManagementSystem.controller.hrmResourceController;

import org.springframework.http.ResponseEntity;

public interface ExportHrmResourceController {
    ResponseEntity<byte[]> getDepartmentsExcel();

    ResponseEntity<byte[]> getPersonalsExcel();

    ResponseEntity<byte[]> getPositionsExcel();

}
